package test;

import static org.junit.Assert.assertEquals;
import impl.Ingresso;
import impl.TipoIngresso;
import impl.DiaDaSemana;

import org.junit.Before;
import org.junit.Test;

public class IngressoTest {
	TipoIngresso ingressoCrianca;
	TipoIngresso ingressoEstudante;
	TipoIngresso ingressoIdoso;
	public Ingresso ingresso;

	@Before
	public void setup(){
		ingressoCrianca = TipoIngresso.valueOf("CRIANCA");
		ingressoEstudante = TipoIngresso.valueOf("ESTUDANTE");
		ingressoIdoso = TipoIngresso.valueOf("IDOSO");
		ingresso = new Ingresso();
	}
		
	@Test
	public void CriancasPagamValorNormalAosSabados() {
		assertEquals(ingressoCrianca.retornaPrecoConvencional(),ingresso.precoAPagar(ingressoCrianca,DiaDaSemana.SAB_DOM_FER));
	}

}
