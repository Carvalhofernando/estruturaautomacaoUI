package browsers;

import org.openqa.selenium.chrome.ChromeDriver;

import drivers.DriversFactory;

public class Executa extends DriversFactory {

	public static void iniciarTeste() {

		System.setProperty("webdriver.http.factory", "jdk-http-cliente");
		driver = new ChromeDriver();
		driver.get("https://www.correios.com.br");
		driver.manage().window().maximize();

	}

	
	public void finalizarTeste() {
		driver.quit();
		
	}
	
}
