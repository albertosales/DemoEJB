/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.entities.ListaCompra;
import model.entities.Produtos;


@Stateless
public class ListaFacade extends AbstractFacade<ListaCompra> {

    @PersistenceContext(unitName = "OnLine-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListaFacade() {    	
        super(ListaCompra.class);
    }
    
    public List<Produtos> getProdutos() {
     Query query =	em.createNativeQuery("SELECT * FROM Produtos p WHERE p.quantidade < 15", Produtos.class);
     
     List<Produtos> lista =  query.getResultList();
     
     return lista;
     
    	
    	
    	
    }
    
}
