package pjweb.hashEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class CadastradorDeProdutos {

	public static void main(String[] args) {
		Collection<Produto> produtos = new ArrayList<>();
		
		System.out.println("##### Cadastro de produtos #####\n");
	
		try (Scanner scanner = new Scanner(System.in)) {
			String continuar = "s";
			while ("s".equalsIgnoreCase(continuar)) {
				System.out.print("SKU: ");
				String sku = scanner.nextLine();
				
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				
				Produto produto = new Produto(sku, nome);
				if(produtos.contains(produto)) {
					System.err.println("Esse poduto já foi adicionado. Utilize outro SKU!");
					System.err.flush();
				} else {
					produtos.add(produto);
					System.out.println("Produto adicionado!");
				}
				
				System.out.println("\nDeseja adicionar mais algum produto? (s/n)");
				
				continuar = scanner.nextLine();
			}
		}
		produtos.forEach(System.out::println);
		
		System.out.println("Fim!");
	}
}
