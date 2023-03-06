package ZGenereics.Servico;

import ZGenereics.Dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Canoa"),new Barco("Yate")));
    public Barco buscarBarco(){
        System.out.println("Buscando barco...");
        Barco barco = barcosDisponiveis.remove(0);
        System.out.println("Alugando barco: "+ barco);
        System.out.println("Barcos disponiveis: "+barcosDisponiveis);
        return barco;
    }
    public void retornarBarcoAlugado(Barco barco){
        System.out.println("Devolvendo barco: "+ barco);
        barcosDisponiveis.add(barco);
        System.out.println("Barcos disponiveis: "+barcosDisponiveis);
    }
}
