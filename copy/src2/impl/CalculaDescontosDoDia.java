package impl;

import java.util.HashMap;
import java.util.Map;

public class CalculaDescontosDoDia {

	DiaDaSemana diaDaSemana;
	public final int DESCONTO_GERAL_ESTUDANTE = 35;
	Map<TipoIngresso, Integer> descontosPorTipo = new HashMap<TipoIngresso, Integer>();

	public CalculaDescontosDoDia(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
		inicializaPercentuaisDesconto();
	}

	private void inicializaPercentuaisDesconto() {
		switch (diaDaSemana) {
		case SEGUNDA:
			descontosPorTipo.put(TipoIngresso.ESTUDANTE, 10);
			break;
		case QUARTA:
			descontosPorTipo.put(TipoIngresso.ESTUDANTE, 50);
			break;
		case SEXTA:
			descontosPorTipo.put(TipoIngresso.ESTUDANTE, 50);
			break;
		case SAB_DOM_FER:
			descontosPorTipo.put(TipoIngresso.IDOSO, 5);
			break;
		default:
			break;
		}
	}

	public int percentualDescontoPorTipo(TipoIngresso tipoIngresso) {
		Integer percentual = descontosPorTipo.get(tipoIngresso);
		if (percentual == null) {
			percentual = 0;
		}
		if (tipoIngresso == TipoIngresso.ESTUDANTE
				&& percentual < DESCONTO_GERAL_ESTUDANTE) {
			return DESCONTO_GERAL_ESTUDANTE;
		} else
			return percentual.intValue();

	}
}
