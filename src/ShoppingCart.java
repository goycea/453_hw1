import java.util.Timer;

public class ShoppingCart {
    private final ProductModel[] products;
    private int totalProducts;
    private int totalCost;

    public ShoppingCart() {
        products = new ProductModel[5];
        totalProducts = 0;
        totalCost = 0;
    }

    public ProductModel[] getProducts() {
        return products;
    }

    public void addProduct(ProductModel product, int quantity) {
        // This method should add the product to the cart and update the total cost of the cart.
        // If the cart is full, it should print "Cart is full".
        ProductModel newProduct = new ProductModel(product.getName(), product.getPrice(), quantity, product.getUnit());
        if (totalProducts == 5) {
            System.out.println("Cart is full");
        } else {
            int productIndex = findProductIndex(newProduct);
            if (productIndex == -1) {
                products[totalProducts] = newProduct;
                totalProducts++;
            } else {
                products[productIndex].setQuantity(products[productIndex].getQuantity() + quantity);
            }
            totalCost += newProduct.getPrice() * newProduct.getQuantity();

            System.out.println("Product added successfully");
        }
    }

    public int removeProduct(ProductModel product, int quantity) {
        // This method should remove the product from the cart and return the quantity of the product removed.
        // Also, it should update the total cost of the cart.
        // If the product is not found in the cart, it should print "Product not found" and return 0.
        // If the quantity is greater than the quantity of the product in the cart, it should print "Invalid quantity" and return 0.
        // If the product is found and the quantity is valid, it should return the quantity of the product removed.

        int productIndex = findProductIndex(product);
        if (productIndex == -1) {
            System.out.println("Product not found");
            return 0;
        } else if (products[productIndex].getQuantity() < quantity) {
            System.out.println("Invalid quantity");
            return 0;
        } else {

            products[productIndex].setQuantity(products[productIndex].getQuantity() - quantity);
            totalCost -= products[productIndex].getPrice() * quantity;
            // if user remove all quantity of the product, remove the product from the cart
            if (products[productIndex].getQuantity() == 0) {
                for (int i = productIndex; i < totalProducts - 1; i++) {
                    products[i] = products[i + 1];
                }
                totalProducts--;
            }
            return quantity;
        }

    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public int findProductIndex ( ProductModel product ) {
        for (int i = 0; i < totalProducts; i++) {
            if (products[i].getName().equals(product.getName())) {
                return i;
            }
        }
        return -1;
    }

    public void printCart() {
        for (int i = 0; i < totalProducts; i++) {
            System.out.println( i +". "+products[i].getName() + " -  price: " + products[i].getPrice() + " - quantity: " + products[i].getQuantity() + " - unit: " + products[i].getUnit());
        }
        System.out.println("Total cost: " + totalCost);
    }

    public void clearCart() {
        for (int i = 0; i < totalProducts; i++) {
            products[i] = null;
        }
        totalProducts = 0;
        totalCost = 0;
    }
}
