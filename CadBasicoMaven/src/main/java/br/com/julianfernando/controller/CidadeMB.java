/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.julianfernando.controller;

import br.com.julianfernando.model.dao.HibernateDAO;
import br.com.julianfernando.model.dao.InterfaceDAO;
import br.com.julianfernando.model.entities.Cidade;
import br.com.julianfernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author julian
 */
@ManagedBean(name="CidadeMB")
@SessionScoped
public class CidadeMB implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Cidade cidade = new Cidade();
    
    private List<Cidade> cidades;

    public CidadeMB() {
        
    }
    
    private InterfaceDAO<Cidade> cidadeDAO() {
        
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        
        return cidadeDAO;
    }
    
    public String addCidade() {
        // se o objeto Cidade não existir ou for o primeiro registro a ação será de insert do contrário será update
        if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0) {
            insertCidade();
        } else {
            updateCidade();
        }
        // após inserção ou atualização de objeto Cidade limpá-lo
        limparCidade();
        return null;
    }
    
    public String editCidade() {
        return "/restrict/cadastrarcidade.faces";
    }
    
    
    public void deleteCidade() {
        cidadeDAO().remove(cidade); 
    }
    
    private void insertCidade() {
        cidadeDAO().save(cidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravação efetuada com sucesso","") );
    }

    private void updateCidade() {
        cidadeDAO().update(cidade);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização efetuada com sucesso","") );
    }
    
    public String limparCidade() {
        cidade = new Cidade();
        return "/restrict/cadastrarcidade.faces";
    }


    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        cidades = cidadeDAO().getEntities();
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
