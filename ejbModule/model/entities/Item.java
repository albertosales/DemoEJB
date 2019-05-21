package model.entities;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author alberto sales
 */
public class Item implements Serializable {
    
	private static final long serialVersionUID = 1L;
	public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String DESCRICAO = "descricao";
    public static final String QTDE = "qtde";
    
    private int id;
    private String nome;
    private String descricao;
    private int qtde;

    public Item(Produtos p) {
        this.id = p.getId();
        this.nome = p.getNome();
        this.descricao = p.getDescricao();
        this.qtde = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int antId = id;
        this.id = id;
        propertySupport.firePropertyChange(ID, antId, id);
    }

    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
        String antNome = nome;
        this.nome = nome;
        propertySupport.firePropertyChange(NOME, antNome, nome);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
        String antDesc = descricao;
        this.descricao = descricao;
        propertySupport.firePropertyChange(DESCRICAO, antDesc, descricao);
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

    private PropertyChangeSupport propertySupport;
    
    public Item() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
