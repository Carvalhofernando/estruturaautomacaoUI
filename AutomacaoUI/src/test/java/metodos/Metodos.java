package metodos;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import drivers.DriversFactory;

public class Metodos extends DriversFactory {

	public void escrever(By elemento, String texto, String campo) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.err.println("************ERRO AO ESCREVER NO CAMPO " + campo + "*******");
			System.err.println("************CAUSA DO ERRO***************" + e.getCause());
		}
	}

	public void clicar(By elemento, String campo) {
		try {
			driver.findElement(elemento).click();

		} catch (Exception e) {
			System.err.println("************ERRO AO CLICAR NO CAMPO " + campo + "*******");
			System.err.println("************CAUSA DO ERRO***************" + e.getCause());
		}

	}

	public void scroll(int n1, int n2) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy("+n1+","+n2+")", "");

		} catch (Exception e) {
			System.err.println("************ERRO DE SCROLL*******");
			System.err.println("************CAUSA DO ERRO***************" + e.getCause());
		}
	}
/**
	 * Método responsável por trocar de aba
	 */
	public void trocarAba() {
		try {

			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> iterator = allWindowHandles.iterator();
			
			while(iterator.hasNext()) {
				String ChildWindow = iterator.next();
				if(!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					System.out.println("Aba acessada é " + driver.getCurrentUrl());
					System.out.println("O titula da Aba acessada é " + driver.getTitle());
				}
			}
			
		} catch (Exception e) {
			System.err.println("************ERRO AO TENTAR TROCAR DE ABA*******");
			System.err.println("************CAUSA DO ERRO***************" + e.getCause());
		}
	}
	public void evidencia(String evidencia) {
		try {
			TakesScreenshot srcShot = (TakesScreenshot) driver;
			File scrFile = srcShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./evidencias/"+evidencia+".png");
			FileUtils.copyFile(scrFile, destFile);

		} catch (Exception e) {
			System.err.println("************ERRO AO TENTAR TIRAR EVIDENCIA " + evidencia + "*******");
			System.err.println("************CAUSA DO ERRO***************" + e.getCause());
		}
	}	
	}