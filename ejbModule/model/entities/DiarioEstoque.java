package model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import model.enums.RazaoMovimentoEstoque;

@Entity
public class DiarioEstoque  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	protected Long id;

	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produtos produto;
	
	@Column(name = "data", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "razao_movimento_estoque", nullable = false)
	private RazaoMovimentoEstoque razaoMovimentoEstoque;
	
	@Column(name = "quantidade", nullable = false)
	private Double quantidade;
	
	public DiarioEstoque() {}

	
	public DiarioEstoque(Produtos produto, Date data, RazaoMovimentoEstoque razaoMovimentoEstoque, Double quantidade) {
		super();
		this.produto = produto;
		this.data = data;
		this.razaoMovimentoEstoque = razaoMovimentoEstoque;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RazaoMovimentoEstoque getRazaoMovimentoEstoque() {
		return razaoMovimentoEstoque;
	}

	public void setRazaoMovimentoEstoque(RazaoMovimentoEstoque razaoMovimentoEstoque) {
		this.razaoMovimentoEstoque = razaoMovimentoEstoque;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((razaoMovimentoEstoque == null) ? 0 : razaoMovimentoEstoque.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiarioEstoque other = (DiarioEstoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (razaoMovimentoEstoque != other.razaoMovimentoEstoque)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DiarioEstoque [id=" + id + ", produto=" + produto + ", data=" + data + ", razaoMovimentoEstoque="
				+ razaoMovimentoEstoque + "]";
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String dataFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(this.data);
	}
	
}
