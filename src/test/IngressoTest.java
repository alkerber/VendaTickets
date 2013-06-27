package test;

import impl.DiaDaSemana;
import impl.Ingresso;
import impl.IngressoCrianca;
import impl.IngressoEstudante;
import impl.IngressoIdoso;
import impl.TipoDoIngresso;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IngressoTest {

	TipoDoIngresso ingressoCrianca;
	TipoDoIngresso ingressoEstudanteComCarteirinha;
	TipoDoIngresso ingressoEstudanteSemCarteirinha;
	TipoDoIngresso ingressoIdoso;

	public Ingresso ingresso;

	@Before
	public void setup() {
		ingressoCrianca = new IngressoCrianca();
		ingressoEstudanteSemCarteirinha = new IngressoEstudante(false);
		ingressoEstudanteComCarteirinha = new IngressoEstudante(true);
		ingressoIdoso = new IngressoIdoso();
		ingresso = new Ingresso();
	}

	@Test
	public void CriancasPagamValorNormalAosSabados() {
		Assert.assertTrue((ingressoCrianca.retornaPrecoConvencional() - ingresso
				.precoAPagar(ingressoCrianca, DiaDaSemana.SAB_DOM_FER)) == 0);
	}

	@Test
	public void IdososTem10porcentoDescontoSegunda() {
		Assert.assertTrue(ingresso.precoAPagar(ingressoIdoso,
				DiaDaSemana.SEGUNDA) - 5.4 == 0);
	}

	@Test
	public void EstudanteComCarteirinhaTem50PorcentoDescontoQuarta() {
		Assert.assertTrue(ingresso.precoAPagar(ingressoEstudanteComCarteirinha,
				DiaDaSemana.QUARTA) - 4.0 == 0);
	}
	
	@Test
	public void EstudanteSemCarteirinhaTem50PorcentoDescontoQuarta() {
		Assert.assertTrue(ingresso.precoAPagar(ingressoEstudanteSemCarteirinha,
				DiaDaSemana.QUARTA) - 4.0 == 0);
	}
}
