public class ItemOrder {
    private Item item;
    private int quantity;
    private double total;

    public ItemOrder(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
        totalCost();
    }
    private void totalCost() {
        double price = item.getPrice();
        int discountminimum = 4; //minimum number of items required to get a discount
        float discountrate = 0.75F;
        if (quantity >= discountminimum) { //if user purchases at least 4 of one item (bulk), that specific item is 25% off
            total = (price * discountrate) * quantity;
        } else {
            total = price * quantity;
        }
    }
    public double getTotal() {
        return total;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
}
