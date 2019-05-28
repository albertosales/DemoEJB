package model.sessionbeans;

import java.util.List;


import javax.persistence.EntityManager;

/**
 *
 * @author alberto sales
 */
public abstract class AbstractFacade<T> {

    private Class<T> entidadesClasses;

    public AbstractFacade(Class<T> entidadeClass) {
        this.entidadesClasses = entidadeClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entidade) {
        System.out.println("dados do objeto ABSTRACT FACADE " +entidade.toString());
        getEntityManager().persist(entidade);
    }

    public void edit(T entidade) {
        getEntityManager().merge(entidade);
    }

    public void remove(T entidade) {
        getEntityManager().remove(getEntityManager().merge(entidade));
    }

    public T find(Object id) {
        return getEntityManager().find(entidadesClasses, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entidadesClasses));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entidadesClasses));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entidadesClasses);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }   
}
