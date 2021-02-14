public class Lotto {
    private final int price;

    public Lotto(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "price=" + price +
                '}';
    }
}
