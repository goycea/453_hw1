public class DummyProducts {
    public static ProductModel[] getProducts() {
        ProductModel[] products = new ProductModel[20];
        // Product unit kg
        products[0] = new ProductModel("Apple", 100, 10, "kg");
        products[1] = new ProductModel("Banana", 50, 20, "kg");
        products[2] = new ProductModel("Orange", 80, 15, "kg");
        products[3] = new ProductModel("Mango", 150, 5, "kg");
        products[4] = new ProductModel("Pineapple", 200, 3, "kg");

        // Product unit piece
        products[5] = new ProductModel("Bleach", 10, 10, "piece");
        products[6] = new ProductModel("Toilet Paper", 5, 20, "piece");
        products[7] = new ProductModel("Shampoo", 50, 5, "piece");
        products[8] = new ProductModel("Soap", 20, 10, "piece");
        products[9] = new ProductModel("Toothpaste", 30, 10, "piece");

        // Product unit liter
        products[10] = new ProductModel("Milk", 20, 10, "liter");
        products[11] = new ProductModel("Water", 5, 20, "liter");
        products[12] = new ProductModel("Juice", 30, 5, "liter");
        products[13] = new ProductModel("Soda", 10, 10, "liter");
        products[14] = new ProductModel("Beer", 50, 3, "liter");

        // Product unit pack
        products[15] = new ProductModel("Chips", 10, 10, "pack");
        products[16] = new ProductModel("Chocolate", 5, 20, "pack");
        products[17] = new ProductModel("Candy", 1, 50, "pack");
        products[18] = new ProductModel("Gum", 2, 25, "pack");
        products[19] = new ProductModel("Cookies", 10, 10, "pack");

        return products;
    }
}
