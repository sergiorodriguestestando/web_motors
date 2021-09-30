package br.com.automacao.pages;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.automacao.ultils.BrowserTypes;

public class BasePage {

	static WebDriver driver;
	static String url = "https://www.webmotors.com.br/";
	static BrowserTypes brownser = BrowserTypes.CHROME_WINDOWS_WEB;
	static String navegador = brownser.getLabel();

	static WebDriverWait espera;

	public static WebDriver getDriver(String navegador) {

		if (navegador.equals("CHROME_WINDOWS_WEB")) {
			File file = new File("src\\test\\resources\\drives\\chromedriver94_4_96.exe");
			System.setProperty("webdriver.chrome.driver", file.getPath());
			driver = new ChromeDriver();
			espera = new WebDriverWait(driver, 20);
			driver.get(url);
			driver.manage().window().maximize();

		}

		else if (navegador.equals("CHROME_WINDOWS_HEADLESS")) {
			File file = new File("C:\\arquivos\\chromedriver88_04.exe");
			System.setProperty("webdriver.chrome.driver", file.getPath());
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", "c:\\arquivos");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(cap);
			espera = new WebDriverWait(driver, 200);
			driver.navigate().to(url);
			driver.manage().window().maximize();

		}

		return driver;

	}

	public static void FecharNavegador() {
		driver.quit();
	}

	public static void IrParaPagina(String texto) {
		driver.get(texto);
	}

	public static void IrParaPaginaInicial() {
		driver.get(url);
	}

	public static void tempo() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<WebElement> listaElemetos(By by) {

		List<WebElement> results = driver.findElements(by);

		return results;

	}

	public void escrever(By by, String texto) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver.findElement(by).click();
		driver.findElement(by).sendKeys(texto);
	}

	public void escreverCompassado(By by, String texto) {

		driver.findElement(by).clear();
		for (int i = 0; i < texto.length(); i++) {
			String letra = String.valueOf(texto.charAt(i));
			driver.findElement(by).sendKeys(letra);
		}
		tempo();
	}

	public void entrarFrame(String frame) {
		espera.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}

	public void ValidarTexto(String esperado, String Atual) {
		Assert.assertEquals(esperado, Atual);
	}

	public void sairFrame() {
		driver.switchTo().defaultContent();
	}

	public void EsperarElementoOff(By locator) {
		espera.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	public void irParaMenu(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement element = driver.findElement(by);
		Actions actionProvider = new Actions(driver);
		actionProvider.clickAndHold(element).build().perform();
	}

	public void clicar(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver.findElement(by).click();
	}

	public void pressionarEnter(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement textbox = driver.findElement(by);
		textbox.sendKeys(Keys.ENTER);
	}

	public void fecharNavegador() {
		driver.quit();

	}

	public void clickDuplo(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement element = driver.findElement(by);
		Actions act = new Actions(driver);
		act.moveToElement(element).doubleClick().build().perform();

	}

	public void rolarParaBaixo() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,500)", "");
	}

	public String obterTextoPath(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		String texto = driver.findElement(by).getAttribute("value");
		return texto;
	}

	public String obterTexto(By by) {
		espera.until(ExpectedConditions.visibilityOfElementLocated(by));
		String texto = driver.findElement(by).getText();
		return texto;
	}

	public void rolagemParaBaixo() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,250)", "");

	}

	public void rolagemParaCima() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,-250)", "");

	}

	public void javaScriptBuytotal() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementById(\"buytotal\").removeAttribute(\"data-base\");");

	}

	public void voltar() {
		tempo();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("history.go(-1);");

	}

	public void selectComboText(By by, String texto) {
		Select drpCountry = new Select((driver.findElement(by)));
		drpCountry.selectByVisibleText(texto);

	}

	public int listaTable(By by) {
		int qtd = driver.findElements(by).size();
		return qtd;
	}

	public String retornaTextoElemento(By by) {
		String text = driver.findElement(by).getText();
		return text;
	}

	public List<WebElement> retornaListaElementos(By by) {

		List<WebElement> list = driver.findElements(by);
		return list;
	}

	public void clicaNoPrimeiroDaLista(By by, String text) {

		List<WebElement> list = driver.findElements(by);

		for (WebElement webElement : list) {
			Actions act = new Actions(driver);
			act.moveToElement(webElement).doubleClick().build().perform();
			break;

		}

	}

	public String verificarElementoPagina(By by) {

		try {
			WebElement element = driver.findElement(by);
			return "logado";
		} catch (Exception e) {
			System.out.println(e);
			return "não logado";
		}

	}

}
