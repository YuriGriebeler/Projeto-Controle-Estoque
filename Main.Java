package Estoque.produto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<produto> produtos = new ArrayList<>();
	
	public static void main(String[] args) {
		while (true) {
			int acao;
			String nome;
			int codigo;
			int qtd;
			Scanner scanner = new Scanner(System.in);
			System.out.print("O que você deseja fazer agora? \n 1-> Adicionar \n 2-> Atualizar \n 3-> Consultar \n 4-> Excluir:\n ");
			acao = scanner.nextInt();
			switch (acao) {
				case 1:
					adicionarProduto(scanner);
					break;
				case 2:
					atualizarProduto(scanner);
					break;
				case 3:
					visualizarProdutos(scanner);
					break;
				case 4:
					excluirProdutos(scanner);
					break;
				default:
					System.out.print("Por favor digite uma opção valida.\n");
					break;
					
			}
			
		}
	}
	public static void adicionarProduto(Scanner scanner) {
		String nome;
		int codigo;
		int qtd;
		System.out.print("Insira as informações do produto: \nNome:");
		nome = scanner.nextLine();
		System.out.print("Codigo: ");
		codigo = scanner.nextInt();
		System.out.print("Quantidade: ");
		qtd = scanner.nextInt();
		scanner.nextLine();
		if (verificarExistencia(codigo)) {
			System.out.println("Produto já existe, atualize a quantidade ou confira o código digitado.");
		}
		else {
			produto produto = new produto(nome, codigo, qtd);
	        produtos.add(produto);
	        System.out.println("Produto adicionado com sucesso!");
        }
    }
	public static void atualizarProduto(Scanner scanner) {
		String nome;
		int codigo;
		int qtd;
		int aux = 0;
		System.out.print("Codigo: ");
		codigo = scanner.nextInt();
		System.out.print("Quantidade: ");
		qtd = scanner.nextInt();
		for (produto produto1 : produtos) {
			if (codigo == produto1.getCodigo()) {
				produto1.setQtd(qtd);
				aux = 1;
			}
		}
		if (aux == 0) {
			System.out.println("O produto não existe na base, favor digitar um código existente.");
		} else {
			System.out.println("Produto alterado com sucesso!");
		}
		
	}
	public static void visualizarProdutos(Scanner scanner) {
		System.out.println("| Nome | Código | Qtd | \n");
		for (produto produto : produtos) {
			System.out.println("| " + produto.getNome() + " | " + produto.getCodigo() + " | " + produto.getQtd() + " |\n");
		}

	}
	
	public static void excluirProdutos(Scanner scanner) {
		int codigo;
		System.out.print("Codigo: ");
		codigo = scanner.nextInt();
		if (verificarExistencia(codigo)) {
			for (produto produto : produtos) {
				if (codigo == produto.getCodigo()) {
					produtos.remove(produto);
					System.out.println("Produto excluído com sucesso!");
					break;
				}
			}
		} else {
			System.out.println("O produto não existe na base, favor digitar um código existente.");
		}
		
    }
	
	public static boolean verificarExistencia(int codigo) {
		for (produto produto : produtos) {
			if (codigo == produto.getCodigo()) {
				return true;
			}
		}
		return false;
    }
	

}
