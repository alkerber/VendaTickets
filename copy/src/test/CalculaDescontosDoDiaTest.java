package test;

import static org.junit.Assert.assertEquals;
import impl.CalculaDescontosDoDia;
import impl.DiaDaSemana;
import impl.TipoIngresso;

import org.junit.Before;
import org.junit.Test;

public class CalculaDescontosDoDiaTest {
	
	CalculaDescontosDoDia calculaDescontosDoDia;

	@Before
	public void setup(){
	}
		
	@Test
	public void ApenasIdososTemDescontoAosSabadosDomingosEFeriados() {
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SAB_DOM_FER);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.CRIANCA),0);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.ESTUDANTE),0);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.IDOSO),5);
	}


}
