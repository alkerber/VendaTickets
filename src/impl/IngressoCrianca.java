package impl;

public class IngressoCrianca implements TipoDoIngresso{	
	
	public double retornaPrecoConvencional(){
		return 5.50;
	}

	public TiposDeIngresso retornaTipoDoIngresso() {
		return TiposDeIngresso.CRIANCA;
	}
	
}
