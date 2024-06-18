package Program;

import java.util.Scanner;

import Services.InventoryManager;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		InventoryManager inventoryManager = new InventoryManager();

		int escolha;
		do {
			System.out.println("\n===== Menu =====");
			System.out.println("1. Adicionar Produto");
			System.out.println("2. Remover Produto");
			System.out.println("3. Listar Produtos");
			System.out.println("4. Buscar Produto");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");

			while (!scanner.hasNextInt()) {
				System.out.println("Por favor, digite um número válido!");
				scanner.next();
			}
			escolha = scanner.nextInt();
			scanner.nextLine();

			switch (escolha) {
			case 1:
				addProduct(scanner, inventoryManager);
				break;
			case 2:
				removeProduct(scanner, inventoryManager);
				break;
			case 3:
				inventoryManager.listProducts();
				break;
			case 4:
				searchProduct(scanner, inventoryManager);
				break;
			case 0:
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (escolha != 0);

		scanner.close();
	}

	private static void addProduct(Scanner scanner, InventoryManager inventoryManager) {
		System.out.print("Digite o nome do produto: ");
		String nomeProduto = scanner.nextLine().trim();
		if (nomeProduto.isEmpty()) {
			System.out.println("Nome do produto não pode estar em branco!");
			return;
		}

		System.out.print("Digite a quantidade: ");
		int quantidade = validateNumericInput(scanner);
		scanner.nextLine();

		if (quantidade <= 0) {
			System.out.println("Quantidade deve ser maior que zero!");
			return;
		}

		inventoryManager.addProduct(nomeProduto, quantidade);
	}

	private static void removeProduct(Scanner scanner, InventoryManager inventoryManager) {
		System.out.print("Digite o nome do produto a ser removido: ");
		String nomeProduto = scanner.nextLine().trim();
		if (nomeProduto.isEmpty()) {
			System.out.println("Nome do produto não pode estar em branco!");
			return;
		}

		inventoryManager.removeProduct(nomeProduto);
	}

	private static void searchProduct(Scanner scanner, InventoryManager inventoryManager) {
		System.out.print("Digite o nome do produto a ser buscado: ");
		String nomeProduto = scanner.nextLine().trim();
		if (nomeProduto.isEmpty()) {
			System.out.println("Nome do produto não pode estar em branco!");
			return;
		}

		inventoryManager.searchProduct(nomeProduto);
	}

	private static int validateNumericInput(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("Por favor, digite um número válido!");
			scanner.next();
		}
		return scanner.nextInt();
	}

}