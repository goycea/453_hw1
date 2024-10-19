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

    public void addProduct(ProductModel product) {
        if (totalProducts < products.length) {
            if(product.getQuantity() > 0) {
                // if product is exist in the cart, increase the quantity
                if(product.getQuantity() > 1) {
                    for (int i = 0; i < totalProducts; i++) {
                        if (products[i].getName().equals(product.getName())) {
                            products[i].setQuantity(products[i].getQuantity() + 1);
                            totalCost += products[i].getPrice();
                            return;
                        }
                    }
                }
                products[totalProducts] = product;
                totalCost += product.getPrice();
                totalProducts++;
            } else {
                System.out.println("Invalid quantity");
            }
        } else {
            System.out.println("Cart is full");
        }
    }

    public int removeProduct(ProductModel product, int quantity) {
        int index = findProductIndex(product);
        if (index != -1) {
            if (products[index].getQuantity() <= quantity) {
                products[index].setQuantity(products[index].getQuantity() - quantity);
                totalCost -= products[index].getPrice() * quantity;
                if (products[index].getQuantity() == 0) {
                    for (int i = index; i < totalProducts - 1; i++) {
                        products[i] = products[i + 1];
                    }
                    totalProducts--;
                }
                return quantity;
            } else {
                System.out.println("Invalid quantity");
                return 0;
            }
        } else {
            System.out.println("Product not found");
            return 0;
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
}
