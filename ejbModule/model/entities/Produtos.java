package model.entities;

import java.io.Serializable;
import java.util.Base64;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author alberto sales
 */
@Entity
@Table(name = "produtos")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
		@NamedQuery(name = "Produtos.findById", query = "SELECT p FROM Produtos p WHERE p.id = :id") })
public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	protected Integer id;

	@Basic(optional = false)
	@NotNull
	@Lob
	@Size(min = 1, max = 65535)
	@Column(name = "nome")
	private String nome;

	@Lob
	@Size(max = 65535)
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "preco")
	private Double preco;

	@Column(name = "quantidade", nullable = false)
	private Double quantidade = 0.0;

	@Column(name = "referencia", nullable = false)
	private String referencia;

	@Column(name = "marca", nullable = false)
	private String marca;
	
	@Column(name = "quantidade_minima", nullable = false)
	private Double quantidadeMinima;

	@Column(name = "preco_promocional", nullable = true)
	private Double precoPromocional;

	@Lob
	@Column(name = "imagem", nullable = false, columnDefinition = "longblob")
	private byte[] imagem;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
	private List<DiarioEstoque> diarioEstoqueList;
	
	public Produtos() {
	}

	public Produtos(Integer id) {
		this.id = id;
	}

	public Produtos(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(Double quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Produtos)) {
			return false;
		}
		Produtos outro = (Produtos) object;
		if ((this.id == null && outro.id != null) || (this.id != null && !this.id.equals(outro.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entities.Produtos[ id=" + id + " ]";
	}

	public String getImagemBase64() {
		return Base64.getEncoder().encodeToString(imagem);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecoPromocional() {
		return precoPromocional;
	}

	public void setPrecoPromocional(Double precoPromocional) {
		this.precoPromocional = precoPromocional;
	}

	public List<DiarioEstoque> getDiarioEstoqueList() {
		return diarioEstoqueList;
	}

	public void setDiarioEstoqueList(List<DiarioEstoque> diarioEstoqueList) {
		this.diarioEstoqueList = diarioEstoqueList;
	}
	
}
