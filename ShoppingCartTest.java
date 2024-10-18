import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {

    @Test
    void addProduct() {
        ShoppingCart cart = new ShoppingCart();
        ProductModel product = new ProductModel("TestProduct", 100, 10, "kg");
        cart.addProduct(product);
        assertEquals(100, cart.getTotalCost());
        assertEquals(1, cart.getTotalProducts());
    }

    @Test
    void removeProduct() {
        ShoppingCart cart = new ShoppingCart();
        ProductModel product = new ProductModel("TestProduct", 100, 10, "piece");
        cart.addProduct(product);
        cart.removeProduct(product, 10);
        assertEquals(0, cart.getTotalCost());
        assertEquals(0, cart.getTotalProducts());
    }

    @Test
    void printCart() {
        ShoppingCart cart = new ShoppingCart();
        ProductModel product = new ProductModel("TestProduct", 100, 10, "liter");
        cart.addProduct(product);
        cart.printCart();
        assertEquals(1000, cart.getTotalCost());
        assertEquals(1, cart.getTotalProducts());

    }
}
