package br.com.julianfernando.suport;

import br.com.julianfernando.model.dao.HibernateDAO;
import br.com.julianfernando.model.dao.InterfaceDAO;
import br.com.julianfernando.model.entities.Cidade;
import br.com.julianfernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author julian
 */
@ManagedBean(name = "CidadeBackingBean")
@RequestScoped
public class CidadeBackingBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<Cidade> getCidades() {
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        
        return cidadeDAO.getEntities();
    }
}
