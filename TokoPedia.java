package comel;

import java.util.ArrayList;

class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayInventory() {
        for (Product product : products) {
            System.out.println("Nama Barang: " + product.getName() + ", Harga: " + product.getPrice());
        }
    }

    public void sortInventory() {
        int n = products.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (products.get(j).getPrice() < products.get(minIndex).getPrice()) {
                    minIndex = j;
                }
            }

            Product temp = products.get(minIndex);
            products.set(minIndex, products.get(i));
            products.set(i, temp);
        }
    }

    public void searchByName(String searchQuery) {
        ArrayList<Product> searchResults = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(searchQuery)) {
                searchResults.add(product);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("Barang tidak ditemukan.");
        } else {
            System.out.println("Hasil pencarian untuk '" + searchQuery + "':");
            for (Product product : searchResults) {
                System.out.println("Nama Barang: " + product.getName() + ", Harga: " + product.getPrice());
            }
        }
    }
}

public class TokoPedia {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Menambahkan data barang ke inventory
        inventory.addProduct(new Product("Buku Tulis", 5000));
        inventory.addProduct(new Product("Pensil", 2000));
        inventory.addProduct(new Product("Penghapus", 1000));
        inventory.addProduct(new Product("Buku Gambar", 7000));
        inventory.addProduct(new Product("Pulpen", 3000));

        System.out.println("Inventory sebelum diurutkan:");
        inventory.displayInventory();

        System.out.println("\nInventory setelah diurutkan berdasarkan harga:");
        inventory.sortInventory();
        inventory.displayInventory();

        System.out.println("\nPencarian berdasarkan 'Buku Tulis':");
        inventory.searchByName("Buku Tulis");
    }
}