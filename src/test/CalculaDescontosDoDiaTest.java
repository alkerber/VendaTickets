package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import impl.CalculaDescontosDoDia;
import impl.DiaDaSemana;
import impl.IngressoCrianca;
import impl.IngressoEstudante;
import impl.IngressoIdoso;

import org.junit.Before;
import org.junit.Test;

public class CalculaDescontosDoDiaTest {
	private final int SEM_DESCONTO = 0;
	private final int DESCONTO_IDOSO_SABADO = 5;
	private final int DESCONTO_ESTUDANTE_CARTEIRINHA = 35;
	private final int DESCONTO_QUARTA_ESTUDANTE = 50;	
	
	private IngressoCrianca ingressoCrianca;
	private IngressoEstudante ingressoEstudanteSemCarteirinha;
	private IngressoEstudante ingressoEstudanteComCarteirinha;
	private IngressoIdoso ingressoIdoso;
	
	CalculaDescontosDoDia calculaDescontosDoDia;

	@Before
	public void setup(){
		ingressoCrianca = new IngressoCrianca();
		ingressoEstudanteSemCarteirinha = new IngressoEstudante(false);
		ingressoEstudanteComCarteirinha = new IngressoEstudante(true);
		ingressoIdoso = new IngressoIdoso();
	}
		
	
	@Test
	public void CriancasNaoTemDescontoQuintas(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUINTA);
		assertEquals(SEM_DESCONTO, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoCrianca));
	}
	
	@Test
	public void CriancasTemDescontoSegundaTercaQuartaESexta(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEGUNDA);		
		assertTrue("Crianca sem desconto na segunda", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoCrianca) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.TERCA);		
		assertTrue("Crianca sem desconto na terca", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoCrianca) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUARTA);		
		assertTrue("Crianca sem desconto na quarta", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoCrianca) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEXTA);		
		assertTrue("Crianca sem desconto na sexta", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoCrianca) > SEM_DESCONTO);
	}
	
	@Test
	public void ApenasIdososTemDescontoAosSabadosDomingosEFeriados() {
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SAB_DOM_FER);

		assertEquals(SEM_DESCONTO, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteSemCarteirinha));
		assertEquals(SEM_DESCONTO, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha));
		assertEquals(SEM_DESCONTO, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoCrianca));		
		assertEquals(DESCONTO_IDOSO_SABADO, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoIdoso));
	}
	
	@Test 
	public void IdososNaoTemDescontoSextas(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEXTA);
		assertEquals(SEM_DESCONTO, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoIdoso));
	}
	
	@Test
	public void IdososTemDescontoSegundaTercaQuartaQuintaESabadoDomingoEFeriados(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEGUNDA);		
		assertTrue("Idoso sem desconto na segunda", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoIdoso) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.TERCA);		
		assertTrue("Idoso sem desconto na terca", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoIdoso) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUARTA);		
		assertTrue("Idoso sem desconto na quarta", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoIdoso) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUINTA);		
		assertTrue("Idoso sem desconto na quinta", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoIdoso) > SEM_DESCONTO);
				
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SAB_DOM_FER);		
		assertTrue("Idoso sem desconto no sábado domingo ou feriado", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoIdoso) > SEM_DESCONTO);
	}

	@Test
	public void QuandoHouverSobreposicaoDescontosEstudanteMaiorPrevalece(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUARTA);
		assertEquals(DESCONTO_QUARTA_ESTUDANTE, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha));
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEGUNDA);
		assertEquals(DESCONTO_ESTUDANTE_CARTEIRINHA, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha));
	}	
	
	@Test
	public void EstudantesComCarteirinhaTemDescontoSextas(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEXTA);
		assertEquals(DESCONTO_ESTUDANTE_CARTEIRINHA, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha));
	}
	
	@Test
	public void EstudantesSemCarteirinhaNaoTemDescontoSextas(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEXTA);
		assertEquals(SEM_DESCONTO, calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteSemCarteirinha));
	}

	@Test
	public void EstudantesComCarteirinhaTemDescontoTodosOsDiasUteis(){
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEGUNDA);		
		assertTrue("Estudante sem desconto na segunda", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.TERCA);		
		assertTrue("Estudante sem desconto na terca", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUARTA);		
		assertTrue("Estudante sem desconto na quarta", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha) > SEM_DESCONTO);
		
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.QUINTA);		
		assertTrue("Estudante sem desconto na quinta", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha) > SEM_DESCONTO);
				
		calculaDescontosDoDia = new CalculaDescontosDoDia(DiaDaSemana.SEXTA);		
		assertTrue("Estudante sem desconto na sexta", calculaDescontosDoDia.percentualDescontoPorTipo(ingressoEstudanteComCarteirinha) > SEM_DESCONTO);
	}
}
