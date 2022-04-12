package carrinho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculadora.Calculadora;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste de Carrinho")
public class carrinhoTest {

	private Carrinho carrinho;
		
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}
	
	@DisplayName("Testa adicionar item ao carrinho")
	@Test
	public void testAdicionarItem() {
		Produto item1 = new Produto("oleo", 10.00);
		carrinho.addItem(item1);		
		int qtde = carrinho.getQtdeItems();
		Assertions.assertNotEquals(0, qtde);		
	}
	
	@DisplayName("Testa remover item")
	@Test
	public void testRemoverItem() throws ProdutoNaoEncontradoException {
		Produto item1 = new Produto("oleo", 10.00);
		carrinho.addItem(item1);		
		int qtde = carrinho.getQtdeItems();
		Assertions.assertNotEquals(0, qtde);
		carrinho.removeItem(item1);
		qtde = carrinho.getQtdeItems();
		Assertions.assertEquals(0, qtde);
	}

	@DisplayName("Obter Valor total do carrinho")
	@Test
	public void testValorTotal(){
		Produto item1 = new Produto("oleo", 10.00);
		Produto item2 = new Produto("feijao", 8.00);
		Produto item3 = new Produto("sal", 0.99);
		Produto item4 = new Produto("carne", 50.00);
		carrinho.addItem(item1);
		carrinho.addItem(item2);
		carrinho.addItem(item3);
		carrinho.addItem(item4);
		double total = carrinho.getValorTotal();
		Assertions.assertEquals(68.99, total);
	}
	
	@DisplayName("Esvazia carrinho")
	@Test
	public void testEsvazia(){
		Produto item1 = new Produto("oleo", 10.00);
		Produto item2 = new Produto("feijao", 8.00);
		Produto item3 = new Produto("sal", 0.99);
		Produto item4 = new Produto("carne", 50.00);
		carrinho.addItem(item1);
		carrinho.addItem(item2);
		carrinho.addItem(item3);
		carrinho.addItem(item4);
		carrinho.esvazia();
		int quantidade = carrinho.getQtdeItems();
		Assertions.assertEquals(0, quantidade);
	}
}
