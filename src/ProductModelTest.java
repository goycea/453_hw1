import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductModelTest {

    @org.junit.jupiter.api.Test
    void getName() {
        ProductModel product = new ProductModel("TestProduct", 100, 10, "unit");
        assertEquals("TestProduct", product.getName());    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        ProductModel product = new ProductModel("TestProduct", 100, 10, "unit");
        assertEquals(100, product.getPrice());
    }

    @org.junit.jupiter.api.Test
    void getQuantity() {
        ProductModel product = new ProductModel("TestProduct", 100, 10, "unit");
        assertEquals(10, product.getQuantity());
    }

    @org.junit.jupiter.api.Test
    void getUnit() {
        ProductModel product = new ProductModel("TestProduct", 100, 10, "kg");
        assertEquals("kg", product.getUnit());
    }

    @org.junit.jupiter.api.Test
    void setQuantity() {
        ProductModel product = new ProductModel("TestProduct", 100, 10, "unit");
        product.setQuantity(20);
        assertEquals(20, product.getQuantity());
    }
}
