package impl;

public class Ingresso {
	CalculaDescontosDoDia calculaDescontosDoDia;

	public Ingresso() {

	}

	public double precoAPagar(TipoIngresso tipoIngresso, DiaDaSemana diaDaSemana) {
		double precoAPagar, desconto, precoConvencional;

		precoConvencional = tipoIngresso.retornaPrecoConvencional();
		calculaDescontosDoDia = new CalculaDescontosDoDia(diaDaSemana);
		desconto = precoConvencional
				* calculaDescontosDoDia.percentualDescontoPorTipo(tipoIngresso)
				/ 100;
		precoAPagar = precoConvencional - desconto;
		return precoAPagar;
	}

}
