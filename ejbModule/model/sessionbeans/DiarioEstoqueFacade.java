/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.sessionbeans;

import model.entities.DiarioEstoque;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Israel Gomes
 */
@Stateless
public class DiarioEstoqueFacade extends AbstractFacade<DiarioEstoque> {

    @PersistenceContext(unitName = "OnLine-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiarioEstoqueFacade() {    	
        super(DiarioEstoque.class);
    }
    
}
