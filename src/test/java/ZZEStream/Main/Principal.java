package ZZEStream.Main;

import ZZEStream.Dominio.Jogador;
import ZZEStream.Negocio.JogadorImpl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Principal p = new Principal();
        JogadorImpl jogImpl = new JogadorImpl();
        String enderecoDir = "D:\\ProjetosDev\\DevDojoMaratonaJava\\src\\test\\java\\ZZEStream\\Arquivos";
        String nomeArquivo = "jogadores.txt";
        List<Jogador> listaDeJogadores = null;
        try {
            listaDeJogadores = jogImpl.getListaDeJogadores(Paths.get(enderecoDir + "\\" + nomeArquivo));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!jogImpl.verificarArquivoExiste(Paths.get(enderecoDir))) {
            System.out.println("Arquivo não encontrado");
        } else {
            jogImpl.imprimirJogadores(listaDeJogadores);
            jogImpl.imprimirJogadorArtilheiro(listaDeJogadores);
            jogImpl.imprimirJogadorMaisVelho(listaDeJogadores);
            jogImpl.imprimirJogadorMaisNovo(listaDeJogadores);
        }
    }
}