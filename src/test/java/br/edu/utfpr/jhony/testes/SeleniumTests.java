package br.edu.utfpr.jhony.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTests {

	@Test
	public void testesSimples() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.quit();
	}

	@Test
	public void testeHelloWorld() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "http://localhost:8080/hello-world";
		driver.get(baseUrl);

		WebElement corpo = driver.findElement(By.tagName("body"));

		Assertions.assertEquals("Olá Mundo", corpo.getText());

		driver.close();
	}

	@Test
	public void testePessoa() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/buscaPessoaTeste");
		Assertions.assertEquals("{\"id\":1,\"nome\":\"Jhony\",\"peso\":72,\"altura\":173,\"pesovezescem\":0.0}", driver.findElement(By.tagName("body")).getText());
		driver.close();
	}

	@Test
	public void verificaJhonyESalario() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "http://localhost:8080/pagina1";
		driver.get(baseUrl);

		WebElement nome = driver.findElement(By.id("jhony"));
		WebElement salario = driver.findElement(By.id("salario"));

		Assertions.assertEquals("Jhony Sganzerla", nome.getText());
		Assertions.assertTrue(Integer.parseInt(salario.getText()) > 100000);

		driver.close();
	}


	@Test
	public void testeRelatarErros() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.utfpr.edu.br/relatar-erros?url=http://www.utfpr.edu.br/&referer=");

		WebElement nome = driver.findElement(By.id("seu-nome"));
		nome.sendKeys("Fulano de Tal");

		WebElement email = driver.findElement(By.id("replyto"));
		email.sendKeys("contato@utfpr.edu.br");

		WebElement msg = driver.findElement(By.id("comments"));
		msg.sendKeys("Favor melhorar a busca deste portal.");
	}

	@Test
	public void testeCompra() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://prospin.com.br");

		WebElement busca = driver.findElement(By.id("search"));
		busca.sendKeys("bola");
		busca.sendKeys(Keys.RETURN);

		List<WebElement> elem = driver.findElements(By.className("nm-product-img"));
		WebElement im1 = elem.get(1);
		im1.click();

	}
}
