package ZZB_Comportamento.Dominio;

public class Car {
    private String name = "Lamborguine";
    private String color;
    private int year;

    public Car(String color, int year) {
        this.color = color;
        this.year = year;
    }


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ']';
    }
}
