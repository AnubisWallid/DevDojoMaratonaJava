package YCollections.dominio;

import java.util.Objects;

public class Smartphone implements Comparable<Smartphone> {
    private String id;
    private String marca;
    private double preco;
    private int quantidade;

    //Reflexivo: x.equals(x) tem que ser TRUE para tudo que for diferente de NULL;
    //Simetrico: Para x e y diferente diferentes de NULL, se x.equals(y) == TRUE logo,
//y.equal(x) == TRUE;
    //Transitividade: Para x,y,z diferentes de NULL, se x.equal(y) == TRUE, logo
// x.equals(z) == TRUE, então y.eauqls(z) == TRUE;
    //Consistente: x.equals(x) sempre retorna TRUE, sendo x != NULL;

    public Smartphone(String id, String marca) {
        Objects.requireNonNull(id, "ID não pode ser NULO");
        Objects.requireNonNull(marca, "Marca não pode ser NULA");
        this.id = id;
        this.marca = marca;
    }
    public Smartphone(String id, String marca, double preco) {
        this(id,marca);
        this.preco = preco;
    }

    public Smartphone() {
    }
    public Smartphone(String id, String marca, double preco,int quantidade) {
        this(id,marca,preco);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    @Override
    public String toString() {

        return "Smartphone{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", preco=" + preco +
                ", Quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;

        Smartphone that = (Smartphone) o;

        return getId() == that.getId();
    }

    //Se x.equals(y) == TRUE, y.hashCode() == x.hashCode();
    //y.hashCode() == x.hashCode(), NÃO necessesariamente x.equals(y) == True;

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getMarca().hashCode();
        return result;
    }

    @Override
    public int compareTo(Smartphone smartphone) {
        //this < Outro -> -1
        //this == Outro -> 0
        //this > Outro -> 1
        if (this.id.compareTo(smartphone.id) == 0){
            return this.marca.compareTo(smartphone.getMarca());
        }
        return this.id.compareTo(smartphone.getId());
    }
}
