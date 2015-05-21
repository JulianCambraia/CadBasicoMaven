/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.julianfernando.suport;

import br.com.julianfernando.model.dao.HibernateDAO;
import br.com.julianfernando.model.dao.InterfaceDAO;
import br.com.julianfernando.model.entities.TipoEndereco;
import br.com.julianfernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author julian
 */
@ManagedBean(name = "TipoEnderecoBackinBean")
@RequestScoped
public class TipoEnderecoBackingBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<TipoEndereco> getTiposEndereco() {
        
        InterfaceDAO<TipoEndereco> tipoEnderecoDAO = new HibernateDAO<TipoEndereco>(TipoEndereco.class, FacesContextUtil.getRequestSession());
        
        return tipoEnderecoDAO.getEntities();
    }
}
