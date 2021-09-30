package br.com.automacao.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuscaPage extends BasePage {

	

	
	By listaResultados = By.xpath("//h2[@class='sc-uJMKN hNiOat']");

	By listaInputResultados = By.cssSelector("div.SearchBar__results__result__name");

	By testBuscaSemResultado = By.id("SearchBar__results__result no-resul");

	By inputBusca = By.id("searchBar");

	

	public BuscaPage digitarNoCampoPesuisa(String assunto) {

		IrParaPaginaInicial();
		escreverCompassado(inputBusca, assunto);
//		tempo();
		
		clicaNoPrimeiroDaLista(listaInputResultados, assunto);
		tempo();

		return this;
	}

	public BuscaPage listarResultadosPesquisa(String resultado) {

		List<WebElement> listaElementos = retornaListaElementos(listaResultados);

		for (WebElement webElement : listaElementos) {
			System.out.println("-----resultado: " + webElement.getText());
			Assert.assertTrue(webElement.getText().contains(resultado));

		}

		return this;
	}

	public BuscaPage listarResultadosPesquisaSemResultado(String resultado) {

		ValidarTexto("Não encontramos este termo, verifique a ortografia", resultado);

		return this;
	}

}
