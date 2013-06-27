package impl;

public class IngressoEstudante implements TipoDoIngresso {
	boolean possuiCarteirinha;

	public IngressoEstudante(boolean possuiCarteirinha) {
		this.possuiCarteirinha = possuiCarteirinha;
	}

	public boolean possuiCarteirinha() {
		return possuiCarteirinha;
	}

	public double retornaPrecoConvencional() {
		return 8.00;
	}
	
	public TiposDeIngresso retornaTipoDoIngresso() {
		return TiposDeIngresso.ESTUDANTE;
	}
}
