package ZGenereics.Servico;

import ZGenereics.Dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class RentalService<T> {
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjeto() {
        System.out.println("Buscando...");
        T objeto = objetosDisponiveis.remove(0);
        System.out.println("Alugando : " + objeto);
        System.out.println("Disponiveis: " + objetosDisponiveis);
        return objeto;
    }

    public void retornarObjetoAlugado(T objeto) {
        System.out.println("Devolvendo: " + objeto);
        objetosDisponiveis.add(objeto);
        System.out.println("Disponiveis: " + objetosDisponiveis);
    }
}
