package ZGenereics;

import ZGenereics.Dominio.Barco;
import ZGenereics.Dominio.Carro;
import ZGenereics.Servico.BarcoRentavelService;
import ZGenereics.Servico.CarroRentavelService;

public class D_ClasseGenericaTest01 {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Lamborgine");
        CarroRentavelService service = new CarroRentavelService();
        Carro carro2 = service.buscarCarro();
        service.retornarCarroAlugado(carro1);
        service.retornarCarroAlugado(carro2);
        System.out.println("------------------------------------------");
        Barco barco1 = new Barco("Jetsky");
        BarcoRentavelService service2 = new BarcoRentavelService();
        Barco barco2 = service2.buscarBarco();
        service2.retornarBarcoAlugado(barco1);
        service2.retornarBarcoAlugado(barco2);
    }
}
