package test;

import impl.DiaDaSemana;
import impl.Ingresso;
import impl.TipoIngresso;

import java.math.MathContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngressoTest {
	MathContext precisao = new MathContext(2);

	TipoIngresso ingressoCrianca;
	TipoIngresso ingressoEstudante;
	TipoIngresso ingressoIdoso;

	public Ingresso ingresso;

	@Before
	public void setup() {
		ingressoCrianca = TipoIngresso.valueOf("CRIANCA");
		ingressoEstudante = TipoIngresso.valueOf("ESTUDANTE");
		ingressoIdoso = TipoIngresso.valueOf("IDOSO");
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
	public void EstudanteTem50PorcentoDescontoQuarta() {
		Assert.assertTrue(ingresso.precoAPagar(ingressoEstudante,
				DiaDaSemana.QUARTA) - 4.0 == 0);
	}
}
