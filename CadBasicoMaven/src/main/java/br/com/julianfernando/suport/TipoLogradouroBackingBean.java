package br.com.julianfernando.suport;

import br.com.julianfernando.model.dao.HibernateDAO;
import br.com.julianfernando.model.dao.InterfaceDAO;
import br.com.julianfernando.model.entities.TipoLogradouro;
import br.com.julianfernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author julian
 */
@ManagedBean(name = "TipoLogradouroBackingBean")
@RequestScoped
public class TipoLogradouroBackingBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<TipoLogradouro> getTiposLogradouro() {

        InterfaceDAO<TipoLogradouro> tipoLogradouroDAO = new HibernateDAO<TipoLogradouro>(TipoLogradouro.class, FacesContextUtil.getRequestSession());

        return tipoLogradouroDAO.getEntities();
    }
}
