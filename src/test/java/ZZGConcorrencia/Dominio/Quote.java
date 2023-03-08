package ZZGConcorrencia.Dominio;

//storeName:price:discountCode
public final class Quote { //quote == Orçamento
    private final String store;
    private final double price;
    private final Discount.Code discountCode;

    private Quote(String store, double price, Discount.Code discountCode) {
        this.store = store;
        this.price = price;
        this.discountCode = discountCode;
    }

    /**
     * Creates new Quote object from the value,
     * following the pattern storeName:price:discountCode
     *
     * @param attributes containing storeName:price:discountCode
     * @return new Quote with values from @param value
     */
    public static Quote setAttributes(String attributes) {
        String[] values = attributes.split(":");
        return new Quote(
                values[0],
                Double.parseDouble(values[1]),
                /*Discount.Code.valueOf(values[2])*/
                Enum.valueOf(Discount.Code.class, values[2])
        );
    }

    public String getStore() {
        return store;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }

    @Override
    public String toString() {
        return "Quote{" +
               "store='" + store + '\'' +
               ", price=" + price +
               ", discountCode=" + discountCode +
               '}';
    }
}
