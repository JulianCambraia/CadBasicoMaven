package br.com.julianfernando.suport;

import br.com.julianfernando.model.dao.HibernateDAO;
import br.com.julianfernando.model.dao.InterfaceDAO;
import br.com.julianfernando.model.entities.Estado;
import br.com.julianfernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author julian
 */
@ManagedBean(name = "EstadoBackinBean")
@RequestScoped
public class EstadoBackingBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<Estado> getEstados() {
        
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        
        return estadoDAO.getEntities();
    }
}
