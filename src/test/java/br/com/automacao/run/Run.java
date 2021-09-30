package br.com.automacao.run;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.automacao.pages.BasePage;
import br.com.automacao.ultils.BrowserTypes;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = "src/test/resources/features/buscas_veiculos.feature",
				features = ".",
		glue = "br.com.automacao.steps", 
		plugin = {
		"pretty", "html:target/site" }, 
		monochrome = true,
		dryRun = false

)

public class Run {

	static WebDriver driver;
	static BasePage base;

	@BeforeClass
	public static void IniciandoNavegador() {

		BrowserTypes brownser = BrowserTypes.CHROME_WINDOWS_WEB;
		String navegador = brownser.getLabel();
		driver = BasePage.getDriver(navegador);
		base = new BasePage();

	}

	@AfterClass
	public static void FechandoNavegador() {
		base.fecharNavegador();
	}
}
