package steps;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import browsers.Executa;
import metodos.Metodos;

public class BuscarCepTeste {
Metodos metodo = new Metodos();
	
	By buscarCep = By.id("relaxation");
	By btnBuscarCep = By.xpath("//div[@class='card card-mais-acessados ordem'][2]//button[@class='bt-link-ic']");
	
	
	
	
	@Before
	public void iniciarTeste() {
		Executa.iniciarTeste();
	}
	
	@Test
	public void buscarCep() {
		metodo.scroll(0, 350);
		metodo.escrever(buscarCep, "06544300", "buscar cep");
		metodo.clicar(btnBuscarCep, "lupa para buscar cep");
		metodo.trocarAba();
		metodo.evidencia("Buscar cep");
		// criar um metodo para validar um texto
	}

}
