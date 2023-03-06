package YCollections.dominio;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class Consumidor implements Comparable<Consumidor> {
    private long id;
    private String nome;

    public Consumidor(String nome){
        this.id = ThreadLocalRandom.current().nextLong(0,1000);
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Consumidor o) {
        return Long.compare(id,o.getId());
    }

    @Override
    public String toString() {
        return "Consumidor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
