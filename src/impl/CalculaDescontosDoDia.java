package impl;

import java.util.HashMap;
import java.util.Map;

public class CalculaDescontosDoDia {

	DiaDaSemana diaDaSemana;
	public final int DESCONTO_GERAL_ESTUDANTE = 35;
	Map<TiposDeIngresso, Integer> descontosPorTipo = new HashMap<TiposDeIngresso, Integer>();

	public CalculaDescontosDoDia(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
		inicializaPercentuaisDesconto();
	}

	private void inicializaPercentuaisDesconto() {
		switch (diaDaSemana) {
		case SEGUNDA:
			descontosPorTipo.put(TiposDeIngresso.CRIANCA, 10);
			descontosPorTipo.put(TiposDeIngresso.ESTUDANTE, 10);
			descontosPorTipo.put(TiposDeIngresso.IDOSO, 10);
			break;
		case TERCA:
			descontosPorTipo.put(TiposDeIngresso.CRIANCA, 15);
			descontosPorTipo.put(TiposDeIngresso.ESTUDANTE, 5);
			descontosPorTipo.put(TiposDeIngresso.IDOSO, 15);
			break;
		case QUARTA:
			descontosPorTipo.put(TiposDeIngresso.CRIANCA, 30);
			descontosPorTipo.put(TiposDeIngresso.ESTUDANTE, 50);
			descontosPorTipo.put(TiposDeIngresso.IDOSO, 40);
			break;
		case QUINTA:
			descontosPorTipo.put(TiposDeIngresso.ESTUDANTE, 30);
			descontosPorTipo.put(TiposDeIngresso.IDOSO, 30);
			break;
		case SEXTA:
			descontosPorTipo.put(TiposDeIngresso.CRIANCA, 11);
			break;
		case SAB_DOM_FER:
			descontosPorTipo.put(TiposDeIngresso.IDOSO, 5);
			break;
		}
	}

	public int percentualDescontoPorTipo(TipoDoIngresso tipoIngresso) {
		Integer percentual = descontosPorTipo.get(tipoIngresso.retornaTipoDoIngresso());
		if (percentual == null) {
			percentual = 0;
		}
		if (isEstudanteComCarteirinha(tipoIngresso)) {
			if (DESCONTO_GERAL_ESTUDANTE > percentual && diaDaSemana != DiaDaSemana.SAB_DOM_FER ) {
				percentual = DESCONTO_GERAL_ESTUDANTE;
			}
		}
		return percentual.intValue();
	}

	private boolean isEstudanteComCarteirinha(TipoDoIngresso tipoIngresso) {
		if (tipoIngresso.getClass() == IngressoEstudante.class) {
			IngressoEstudante ingressoEstudante = (IngressoEstudante) tipoIngresso;
			return ingressoEstudante.possuiCarteirinha();
		} else return false;
	}

}
