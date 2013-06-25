package impl;

public enum TipoIngresso {
	CRIANCA(5.50), ESTUDANTE(8.00), IDOSO(6.00);

	private double precoConvencional;

	TipoIngresso(double precoConvencional) {
		this.precoConvencional = precoConvencional;
	}

	public double retornaPrecoConvencional() {
		return this.precoConvencional;
	}

}