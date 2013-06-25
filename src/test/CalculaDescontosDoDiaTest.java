package test;

import static org.junit.Assert.assertEquals;
import impl.CalculaDescontosDoDia;
import impl.DiaDaSemana;
import impl.TipoIngresso;

import org.junit.Before;
import org.junit.Test;

public class CalculaDescontosDoDiaTest {
	public final int SEM_DESCONTO = 0;
	public final int DESCONTO_IDOSO_SABADO = 5;
	public final int DESCONTO_GERAL_ESTUDANTE = 35;
	public final int DESCONTO_QUARTA_ESTUDANTE = 50;
	
	
	CalculaDescontosDoDia calculaDescontosDoDia;

	@Before
	public void setup(){
	}
		
	@Test
	public void ApenasIdososTemDescontoAosSabadosDomingosEFeriados() {
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SAB_DOM_FER);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.CRIANCA),SEM_DESCONTO);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.ESTUDANTE),SEM_DESCONTO);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.IDOSO),DESCONTO_IDOSO_SABADO);
	}
	
	@Test
	public void CriancasNaoTemDescontoQuintas(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUINTA);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.CRIANCA),SEM_DESCONTO);
	}

	@Test
	public void QuandoHouverSobreposicaoDescontosEstudanteMaiorPrevalece(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUARTA);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.ESTUDANTE),DESCONTO_QUARTA_ESTUDANTE);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEGUNDA);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.ESTUDANTE),DESCONTO_GERAL_ESTUDANTE);
	}
	
	@Test
	public void EstudantesTemDescontoGeralSextas(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEXTA);
		assertEquals(calculaDescontosDoDia.percentualDescontoPorTipo(TipoIngresso.ESTUDANTE),DESCONTO_GERAL_ESTUDANTE);
	}

}
