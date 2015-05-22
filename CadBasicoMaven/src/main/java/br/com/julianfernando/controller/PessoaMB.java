package br.com.julianfernando.controller;

import br.com.julianfernando.model.dao.HibernateDAO;
import br.com.julianfernando.model.dao.InterfaceDAO;
import br.com.julianfernando.model.entities.Pessoa;
import br.com.julianfernando.model.entities.Endereco;
import br.com.julianfernando.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author julian
 */
@ManagedBean
@SessionScoped
public class PessoaMB implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Pessoa pessoa = new Pessoa();
    
    private Endereco endereco = new Endereco();
    
    private List<Endereco> enderecos;
    
    private List<Pessoa> pessoas;

    public PessoaMB() {
    }
    
    private InterfaceDAO<Pessoa> pessoaDAO() {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class,FacesContextUtil.getRequestSession());
        
        return pessoaDAO;
    }
    
    private InterfaceDAO<Endereco> enderecoDAO() {
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class,FacesContextUtil.getRequestSession());
        
        return enderecoDAO;
    }
    
    public String limparPessoa() {
        pessoa = new Pessoa();
        endereco = new Endereco();
        return editPessoa();
    }
    
    public String editPessoa() {
        return "/restrict/cadastrarpessoa.faces";
    }
    
    public String addPessoa() {
        // seta a data em que está sendo realizado o cadastramento da pessoa
        Date data = new Date();
        
        if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0) {
            pessoa.setDataDeCadastro(data);
            insertPessoa();
        } else {
            updatePessoa();
        }
        return null;
    }
    
    public void deletePessoa() {
        enderecoDAO().remove(endereco);
        pessoaDAO().remove(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso",""));
    }
    
    private void insertPessoa() {
        pessoaDAO().save(pessoa);
        endereco.setPessoa(pessoa);
        enderecoDAO().save(endereco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravação efetuada com sucesso",""));
    }

    private void updatePessoa() {
        pessoaDAO().update(pessoa);
        enderecoDAO().update(endereco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        enderecos = enderecoDAO().getEntities();
        this.enderecos = enderecos;
    }

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }    
}