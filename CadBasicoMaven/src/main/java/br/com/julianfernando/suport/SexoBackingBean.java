package br.com.julianfernando.suport;

import br.com.julianfernando.model.dao.HibernateDAO;
import br.com.julianfernando.model.dao.InterfaceDAO;
import br.com.julianfernando.model.entities.Sexo;
import br.com.julianfernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author julian
 */

@ManagedBean(name = "SexoBackingBean")
@RequestScoped
public class SexoBackingBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<Sexo> getSexos() {
        
        InterfaceDAO<Sexo> sexoDAO = new HibernateDAO(Sexo.class, FacesContextUtil.getRequestSession());
        
        return sexoDAO.getEntities();
    }
}
