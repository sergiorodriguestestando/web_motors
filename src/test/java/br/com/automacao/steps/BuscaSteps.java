package br.com.automacao.steps;

import br.com.automacao.pages.BuscaPage;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class BuscaSteps {

	BuscaPage cp = new BuscaPage();

	@Quando("^realizar uma busca por \"([^\"]*)\"$")
	public void realizar_uma_busca_por(String assunto) throws Throwable {

		cp.digitarNoCampoPesuisa(assunto);

	}

	@Então("^o resultado da consulta será \"([^\"]*)\"$")
	public void o_resultado_da_consulta_será(String arg1) throws Throwable {
		cp.listarResultadosPesquisa(arg1);
	}

	@Então("^o resultado é \"([^\"]*)\"$")
	public void o_resultado_é(String arg1) throws Throwable {
		cp.listarResultadosPesquisaSemResultado(arg1);
	}

}
