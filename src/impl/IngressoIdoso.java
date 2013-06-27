package impl;

public class IngressoIdoso implements TipoDoIngresso{	
	public double retornaPrecoConvencional(){
		return 6.00;
	}

	public TiposDeIngresso retornaTipoDoIngresso() {
		return TiposDeIngresso.IDOSO;
	}

}
