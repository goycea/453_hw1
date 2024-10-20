import java.util.Scanner;

public class Main {
    private static ShoppingCart cart = new ShoppingCart();
    private static ProductModel[] products = DummyProducts.getProducts();
    private static Scanner user = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String response = user.next();
            if (response.equals("0")) {
                break;
            } else if (response.equals("1")) {
                showCart();
            } else {
                addProductToCart(response);
            }
        }
    }

    private static void displayMenu() {
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
    }

    private static void showCart() {
        if (cart.getTotalProducts() == 0) {
            System.out.println("There is no product in the cart");
        } else {
            System.out.println("Total cost: " + cart.getTotalCost());
            cart.printCart();
            while (true) {
                System.out.println("Choose a product to remove or exit to stop");
                System.out.println("0. Exit");
                System.out.println("1. Buy Products");
                ProductModel[] productsInCart = cart.getProducts();
                for (int i = 0; i < cart.getTotalProducts(); i++) {
                    System.out.println((i + 2) + ". " + productsInCart[i].getName() + " - "
                            + productsInCart[i].getPrice() + " - " + productsInCart[i].getQuantity() + " - " + productsInCart[i].getUnit());
                }
                String response = user.next();
                if (response.equals("0")) {
                    break;
                } else if (response.equals("1")) {
                    buyProducts();
                    break;
                }  else {
                    removeProductFromCart(response);
                }
            }
        }
    }

    private static void addProductToCart(String response) {
        int productIndex = Integer.parseInt(response) - 2;
        System.out.println("Enter quantity to add");
        int quantity = Integer.parseInt(user.next());
        if (productIndex >= 0 && productIndex < products.length && products[productIndex].getQuantity() > 0 && quantity > 0) {
            ProductModel product = new ProductModel(products[productIndex].getName(), products[productIndex].getPrice(), quantity, products[productIndex].getUnit());
            cart.addProduct(product);
            products[productIndex].setQuantity(products[productIndex].getQuantity() - quantity);
        } else {
            System.out.println("Invalid product");
        }
    }

    private static void removeProductFromCart(String response) {
        int productIndex = Integer.parseInt(response) - 1;
        System.out.println("Enter quantity to remove");
        int quantity = Integer.parseInt(user.next());
        ProductModel[] productsInCart = cart.getProducts();
        if (productIndex >= 0 && productIndex < cart.getTotalProducts()
                && productsInCart[productIndex].getQuantity() > 0 && quantity > 0) {
            int removedQuantity = cart.removeProduct(productsInCart[productIndex], quantity);
            products[findProductIndex(productsInCart[productIndex])].setQuantity(products[findProductIndex(productsInCart[productIndex])].getQuantity() + removedQuantity);

        } else {
            System.out.println("Invalid product");
        }
    }

    private static int findProductIndex(ProductModel productModel) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getName().equals(productModel.getName())) {
                return i;
            }
        }
        return -1;
    }

    private static void buyProducts() {
        System.out.println("Thank you for your purchase! Here is the summary:");
        cart.printCart();
        cart.clearCart();
        System.out.println("Cart has been cleared.");

        removeOutOfStockProducts();
    }

    private static void removeOutOfStockProducts() {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getQuantity() == 0) {
                products = removeProductFromInventory(products, i);
            }
        }
    }

    private static ProductModel[] removeProductFromInventory(ProductModel[] products, int index) {
        ProductModel[] newProducts = new ProductModel[products.length - 1];
        for (int i = 0, j= 0; i < products.length; i++) {
            if(i != index) {
                newProducts[j++] = products[i];
            }
        }
        return newProducts;
    }

}
