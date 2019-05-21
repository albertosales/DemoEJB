package model.sessionbeans;

import model.entities.Item;
import model.entities.Produtos;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author alberto sales
 */
@Stateless
@LocalBean
public class GerenciarCarrinho {
    
    CarroItemList items = new CarroItemList();
    
    @EJB
    ProdutosFacade produtosFacade;

    public void adicionarItem(int id) {
        Produtos p = produtosFacade.find(id);
        
        if (p != null) {
            Item item;
            try{
                item = items.getItem(id);
                
                if(item != null){
                    item.setQtde(item.getQtde() + 1);
                }
                else {
                    Item novoItem = new Item(p);
                    items.add(novoItem);
                }
            }
            catch(IndexOutOfBoundsException e){
                 Item novoItem = new Item(p);
                 items.add(novoItem);
            }

        }
    }
    
    public void removeItem(int id) {
        Produtos p = produtosFacade.find(id);

        if (p != null) {
            Item item = items.getItem(id);

            if(item != null){
                if(item.getQtde() > 1)
                    item.setQtde(item.getQtde() - 1);
                else 
                    items.remove(item);
            }
            
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
    
    public int getCarrinhoTam(){
        int tam = 0;
        for(Item item : items){
            tam += item.getQtde();
        }
        return tam;
    }
    
    public void removeTodos() {
        items.removeAll(items);
    }
    
    class CarroItemList extends ArrayList<Item> {

		private static final long serialVersionUID = 1L;

		public Item getItem(int i) {
            for(Item item : this){
                if(item.getId() == i)
                    return item;
            }
            return null;
        }
        
    }
    
}
