package model.enums;

public enum RazaoMovimentoEstoque {
	
	VENDA(1, "Venda", TipoMovimento.SAIDA),
	PERCA(2, "Perca", TipoMovimento.SAIDA),
	BRINDE(3, "Brinde", TipoMovimento.SAIDA),
	COMPRA(4, "Entrada", TipoMovimento.ENTRADA);
	
	private Integer cod;
	private String descricao;
	private TipoMovimento tipoMovimento;
	
	private RazaoMovimentoEstoque(Integer cod, String descricao, TipoMovimento tipoMovimento) {
		this.cod = cod;
		this.descricao = descricao;
		this.tipoMovimento = tipoMovimento;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}
	
	public String toString() {
		return this.name();
	}
	
	public static RazaoMovimentoEstoque toEnum(Integer cod) throws Exception {
		for (RazaoMovimentoEstoque razao : RazaoMovimentoEstoque.values()) {
			if (razao.getCod().equals(cod)) {
				return razao;
			}
		}
		throw new Exception("Enum não encontrada para o cod: " + cod);
		
	}
}
