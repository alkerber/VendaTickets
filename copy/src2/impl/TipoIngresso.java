package impl;

import java.math.BigDecimal;

public enum TipoIngresso {
	CRIANCA(new BigDecimal(5.5)),
	ESTUDANTE(new BigDecimal(8.0)),
	IDOSO(new BigDecimal(6.0));
	
	private BigDecimal precoConvencional;
	
	TipoIngresso(BigDecimal precoConvencional){
		this.precoConvencional = precoConvencional;
	}	
	public BigDecimal retornaPrecoConvencional(){
		return this.precoConvencional;
	}

}