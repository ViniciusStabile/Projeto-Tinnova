package Services;

import java.util.ArrayList;

import Entities.Product;

public class InventoryManager {
	private ArrayList<Product> inventory;

	public InventoryManager() {
		this.inventory = new ArrayList<>();
	}

	public void addProduct(String name, int quantity) {

		for (Product p : inventory) {
			if (p.getName().equals(name)) {

				p.setQuantity(p.getQuantity() + quantity);
				System.out.println("Quantidade de " + name + " atualizada para: " + p.getQuantity());
				return;
			}
		}

		Product newProduct = new Product(name, quantity);
		inventory.add(newProduct);
		System.out.println("Produto adicionado ao inventário: " + name);
	}

	public void removeProduct(String name) {
		for (Product p : inventory) {
			if (p.getName().equals(name)) {
				inventory.remove(p);
				System.out.println("Produto removido do inventário: " + name);
				return;
			}
		}
		System.out.println("Produto não encontrado: " + name);
	}

	public void listProducts() {
		System.out.println("Produtos no inventário:");
		for (Product p : inventory) {
			System.out.println("Nome: " + p.getName() + ", Quantidade: " + p.getQuantity());
		}
	}

	public void searchProduct(String name) {
		for (Product p : inventory) {
			if (p.getName().equals(name)) {
				System.out.println("Produto encontrado:");
				System.out.println("Nome: " + p.getName() + ", Quantidade: " + p.getQuantity());
				return;
			}
		}
		System.out.println("Produto não encontrado: " + name);
	}
}
