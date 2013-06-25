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
			descontosPorTipo.put(TipoIngresso.CRIANCA, 10);
			descontosPorTipo.put(TipoIngresso.ESTUDANTE, 10);
			descontosPorTipo.put(TipoIngresso.IDOSO, 10);
			break;
		case TERCA:
			descontosPorTipo.put(TipoIngresso.CRIANCA, 15);
			descontosPorTipo.put(TipoIngresso.ESTUDANTE, 5);
			descontosPorTipo.put(TipoIngresso.IDOSO, 15);
			break;	
		case QUARTA:
			descontosPorTipo.put(TipoIngresso.CRIANCA, 30);
			descontosPorTipo.put(TipoIngresso.ESTUDANTE, 50);
			descontosPorTipo.put(TipoIngresso.IDOSO, 40);
			break;
		case QUINTA:
			descontosPorTipo.put(TipoIngresso.ESTUDANTE, 30);
			descontosPorTipo.put(TipoIngresso.IDOSO, 30);
			break;	
		case SEXTA:
			descontosPorTipo.put(TipoIngresso.CRIANCA, 11);
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
		if (tipoIngresso == TipoIngresso.ESTUDANTE && percentual < DESCONTO_GERAL_ESTUDANTE && diaDaSemana != DiaDaSemana.SAB_DOM_FER) {
			return DESCONTO_GERAL_ESTUDANTE;
		} else
			return percentual.intValue();

	}
}
