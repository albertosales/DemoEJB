/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.entities.Pedido;

@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "OnLine-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {    	
        super(Pedido.class);
    }    
    
    @Override
    public void create(Pedido entidade) {
    	if (entidade.getId() != null) {
    		super.edit(entidade);
    		return;
    	}
    	super.create(entidade);
    }
}
