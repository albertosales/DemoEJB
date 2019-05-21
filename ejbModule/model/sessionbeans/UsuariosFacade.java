package model.sessionbeans;

import model.entities.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alberto sales
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "OnLine-ejbPU")
    private EntityManager em;
    
    private Usuarios logUsuario;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    public boolean estaAutenticado(final String nome, final String senha) {
        Usuarios usuario = find(nome);
        if(usuario != null && usuario.getSenha().equals(senha)){
            logUsuario = usuario;
            return true;
        }
        return false;
    }

    public boolean estaLogado() {
        return logUsuario != null;
    }
    
    public void logout() {
        logUsuario = null;
    }
    
}
