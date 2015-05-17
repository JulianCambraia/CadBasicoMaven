package br.com.julianfernando.model.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author julian
 */
@Entity
@Table(name = "endereco")
class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "IdEndereco", nullable = false)
    private Integer idEndereco;

    @Column(name = "Bairro", length = 100)
    private String bairro;

    @Column(name = "NomeLogradouro", length = 120)
    private String nomeLogradouro;

    @Column(name = "CEP", length = 9)
    private String cep;

    @Column(name = "Numero")
    private Integer numero;

    @Column(name = "Complemento", length = 20)
    private String complemento;

    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPessoa", referencedColumnName = "idPessoa", foreignKey = @javax.persistence.ForeignKey(name = "EnderecoPessoa"))
    private Pessoa pessoa;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTipoLogradouro", referencedColumnName = "IdTipoLogradouro", foreignKey = @javax.persistence.ForeignKey(name = "EnderecoTipoLogradouro"))
    private TipoLogradouro tipologradouro;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoEndereco tipoendereco;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdEstado", nullable = false, foreignKey = @javax.persistence.ForeignKey(name = "EnderecoEstado"))
    private Estado estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCidade", referencedColumnName = "IdCidade", foreignKey = @javax.persistence.ForeignKey(name = "EnderecoCidade"))
    private Cidade cidade;

    public Endereco() {
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipologradouro = new TipoLogradouro();
        this.tipoendereco = new TipoEndereco();
        this.pessoa = new Pessoa();
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipologradouro() {
        return tipologradouro;
    }

    public void setTipologradouro(TipoLogradouro tipoLogradouro) {
        this.tipologradouro = tipoLogradouro;
    }

    public TipoEndereco getTipoendereco() {
        return tipoendereco;
    }

    public void setTipoendereco(TipoEndereco tipoEndereco) {
        this.tipoendereco = tipoEndereco;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idEndereco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.idEndereco, other.idEndereco)) {
            return false;
        }
        return true;
    }

}
