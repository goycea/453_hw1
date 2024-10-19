import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner user = new Scanner(System.in);
        // Create a cart
        ShoppingCart cart = new ShoppingCart();
        // Get products from Dummy products
        ProductModel[] products = DummyProducts.getProducts();

        String response;
        int quantity;
        while (true) {
            System.out.println("Choose a product to add to cart or to see the cart or exit to stop");
            System.out.println("0. Exit");
            if (cart.getTotalProducts() == 0) {
                System.out.println("1. Show the Cart: There is no product in the cart");
            } else {
                System.out.println("1. Show the Cart: There is/are " + cart.getTotalProducts() + " product(s) in the cart");
            }
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 2) + ". " + products[i].getName() + " - " + products[i].getPrice() + " - " + products[i].getQuantity() + " - " + products[i].getUnit());
            }
            response = user.next();
            if (response.equals("1")) {

                    if (cart.getTotalProducts() == 0) {
                        System.out.println("There is no product in the cart");
                    } else {
                        System.out.println("Total cost: " + cart.getTotalCost());
                        cart.printCart();
                        while (true) {
                            System.out.println("Choose a product to remove or exit to stop");
                            System.out.println("0. Exit");
                            ProductModel[] productsInCart = cart.getProducts();
                            for (int i = 0; i < cart.getTotalProducts(); i++) {
                                System.out.println((i + 1) + ". " + productsInCart[i].getName() + " - "
                                        + productsInCart[i].getPrice() + " - " + productsInCart[i].getQuantity() + " - " + productsInCart[i].getUnit());
                            }
                            response = user.next();

                            if (response.equals("0")) {
                                break;
                            } else {
                                int productIndex = Integer.parseInt(response) - 1;
                                System.out.println("Enter quantity to remove");
                                quantity = Integer.parseInt(user.next());
                                if (productIndex >= 0 && productIndex < cart.getTotalProducts()
                                        && productsInCart[productIndex].getQuantity() > 0 && quantity > 0) {
                                    final ProductModel product = productsInCart[Integer.parseInt(response) - 1];
                                    products[product.getId()].setQuantity(products[product.getId()].getQuantity()
                                            + cart.removeProduct(product, quantity));
                                } else {
                                    System.out.println("Invalid product");
                                }
                            }
                        }
                    }

            } else if (response.equals("0")) {
                break;
            } else {
                int productIndex = Integer.parseInt(response) - 2;
                System.out.println("Enter quantity to add");
                quantity = Integer.parseInt(user.next());
                if (productIndex >= 0 && productIndex < products.length
                        && products[productIndex].getQuantity() >= quantity && quantity > 0) {

                    cart.addProduct(products[productIndex]);
                    products[productIndex].setQuantity(products[productIndex].getQuantity() - quantity);

                } else {
                    System.out.println("Invalid product");
                }
            }
        }

    }
}
