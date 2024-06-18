package Services;

import java.util.ArrayList;

import Entities.Product;

public class InventoryManager {
	private ArrayList<Product> inventario;

	public InventoryManager() {
		this.inventario = new ArrayList<>();
	}

	public void adicionarProduct(String name, int quantity) {

		for (Product p : inventario) {
			if (p.getName().equals(name)) {

				p.setQuantity(p.getQuantity() + quantity);
				System.out.println("Quantidade de " + name + " atualizada para: " + p.getQuantity());
				return;
			}
		}

		Product novoProduct = new Product(name, quantity);
		inventario.add(novoProduct);
		System.out.println("Produto adicionado ao inventário: " + name);
	}

	public void removerProduct(String name) {
		for (Product p : inventario) {
			if (p.getName().equals(name)) {
				inventario.remove(p);
				System.out.println("Produto removido do inventário: " + name);
				return;
			}
		}
		System.out.println("Produto não encontrado: " + name);
	}

	public void listarProducts() {
		System.out.println("Produtos no inventário:");
		for (Product p : inventario) {
			System.out.println("Nome: " + p.getName() + ", Quantity: " + p.getQuantity());
		}
	}

	public void buscarProduct(String name) {
		for (Product p : inventario) {
			if (p.getName().equals(name)) {
				System.out.println("Produto encontrado:");
				System.out.println("Nome: " + p.getName() + ", Quantidade: " + p.getQuantity());
				return;
			}
		}
		System.out.println("Produto não encontrado: " + name);
	}
}
