package ZZEStream.Dominio;

public class LightNovel {
    private String title;
    private double price;
    private Category category;

    public LightNovel(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public LightNovel(String title, double price, Category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[title:'%s',price:'%.2f',category:'%s']%n",
                this.title,this.price,this.category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LightNovel)) return false;

        LightNovel that = (LightNovel) o;

        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getTitle() != null ? getTitle().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
