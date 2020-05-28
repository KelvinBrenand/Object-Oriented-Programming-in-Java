public class DiscountBill extends GroceryBill {

    private boolean preferred;
    private int discountItem;
    private double discount;

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
        discountItem = 0;
        discount = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (preferred && i.getDiscount() > 0.0) {
            discountItem++;
            discount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        return super.getTotal() - discount;
    }

    public int getDiscountCount() {
        return discountItem;
    }

    public double getDiscountAmount() {
        return discount;
    }

    public double getDiscountPercent() {
        double total = super.getTotal();

        return (discount*100)/total;
    }
}
