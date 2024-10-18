public class ProductModel extends Item {
    private final int id;
    private final String name;
    private final int price;
    private int quantity;
    private final String unit;
    private static int idCounter = 0;

    public ProductModel(String name, int price, int quantity, String unit) {
        // Each product has a unique id starting from 0 and incrementing by 1
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }
    public String getUnit() {
        return unit;}
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
}
