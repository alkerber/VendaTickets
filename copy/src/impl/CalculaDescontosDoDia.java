package impl;

import java.util.HashMap;
import java.util.Map;

public class CalculaDescontosDoDia {
	
	DiaDaSemana diaDaSemana;
	Map<TipoIngresso,Integer> descontosPorTipo = new HashMap<TipoIngresso,Integer>();
	
	
	public CalculaDescontosDoDia(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
		inicializaPercentuaisDesconto();
	}

	
	private void inicializaPercentuaisDesconto() {
		switch (diaDaSemana) {
		case SAB_DOM_FER:
			descontosPorTipo.put(TipoIngresso.IDOSO, 5);
			break;
		default: break;	
		}
	}
	
	public int percentualDescontoPorTipo(TipoIngresso tipoIngresso){
		//Integer percentual descontosPorTipo.get(tipoIngresso);
		return 0;
		
	}

}
