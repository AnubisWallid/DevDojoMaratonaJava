package ZGenereics;

import ZGenereics.Dominio.Barco;
import ZGenereics.Dominio.Carro;
import ZGenereics.Servico.BarcoRentavelService;
import ZGenereics.Servico.CarroRentavelService;
import ZGenereics.Servico.RentalService;

import java.util.ArrayList;
import java.util.List;

public class E_ClasseGenericaTest02 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"),new Carro("Bugatti")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Canoa"),new Barco("Yate")));
        RentalService<Carro> carroRentalService = new RentalService<>(carrosDisponiveis);
        RentalService<Barco> barcoRentalService = new RentalService<>(barcosDisponiveis);
        Carro carro = carroRentalService.buscarObjeto();
        System.out.println("Usando o carro por um mês...");
        carroRentalService.retornarObjetoAlugado(carro);
        System.out.println("----------------");
        Barco barco = barcoRentalService.buscarObjeto();
        System.out.println("Usando o barco por um mês...");
        barcoRentalService.retornarObjetoAlugado(barco);

    }
}
