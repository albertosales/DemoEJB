package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "listacompra")
public class ListaCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	protected Integer id;


	@Temporal(TemporalType.DATE)
	private Date dtinicio;

	@Temporal(TemporalType.DATE)
	private Date dtfim;
	
	@OneToMany(mappedBy = "listaproduto", fetch = FetchType.LAZY)
	private List<itemCompra> itemLista;

	private Boolean comprado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<itemCompra> getItemLista() {
		return itemLista;
	}

	public void setItemLista(List<itemCompra> itemLista) {
		this.itemLista = itemLista;
	}

	public Boolean getComprado() {
		return comprado;
	}

	public void setComprado(Boolean comprado) {
		this.comprado = comprado;
	}
	
	public ListaCompra() {
		}
	
}
