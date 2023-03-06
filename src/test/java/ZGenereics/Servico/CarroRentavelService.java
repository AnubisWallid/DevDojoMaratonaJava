package ZGenereics.Servico;

import ZGenereics.Dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRentavelService {
    private List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"),new Carro("Bugatti")));
    public Carro buscarCarro(){
        System.out.println("Buscando carro...");
        Carro carro = carrosDisponiveis.remove(0);
        System.out.println("Alugando carro: "+ carro);
        System.out.println("Carros disponiveis: "+carrosDisponiveis);
        return carro;
    }
    public void retornarCarroAlugado(Carro carro){
        System.out.println("Devolvendo carro: "+ carro);
        carrosDisponiveis.add(carro);
        System.out.println("Carros disponiveis: "+carrosDisponiveis);
    }
}
