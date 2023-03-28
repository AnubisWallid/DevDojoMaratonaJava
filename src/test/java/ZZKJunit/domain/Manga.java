package ZZKJunit.domain;

import java.util.Objects;

public record Manga(String name, int episodes) {
    /*Não pode criar atributos de instância*/
    private static final String podeStaticos = "Pode tambem blocos de inicialização estaticos";
    static {
        System.out.println(podeStaticos);
    }

    public Manga {
        Objects.requireNonNull(name);
    }
}
