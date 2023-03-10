package AATestesANDRascunhos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TesteClipboardToTxt {
    private Clipboard clipboard;
    private JOptionPane optionPane;
    private String testString = "Teste de String para o";

    @Before
    public void setUp() throws UnsupportedFlavorException, IOException {
        // Define a área de transferência do sistema com um string para testar
        clipboard = mock(Clipboard.class);
        when(clipboard.getData(DataFlavor.stringFlavor)).thenReturn(testString);

//         Define uma caixa de diálogo de entrada de nome do arquivo com um nome de arquivo de teste
       /* optionPane = mock(JOptionPane.class);
        when(JOptionPane.showInputDialog("Digite no nome do arquivo!")).thenReturn("test");*/
    }

    @After
    public void tearDown() {
        // Deleta o arquivo de teste, se ele existir
        File file = new File("test.txt");
        if (file.exists()) {
            file.delete();
        }
    }

//    @Test
//    public void testClipboardToTxt() throws IOException, UnsupportedFlavorException {
//        // Executa o método para testar
//        ClipboardToTxt.main(null);
//
//        // Verifica se o arquivo foi criado corretamente
//        File file = new File("test.txt");
//        assertEquals(true, file.exists());
//
//        // Verifica se o conteúdo do arquivo é o esperado
//        String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
//        assertEquals(testString, content.trim());
//    }

    @Test
    public void testClipboardToTxtWithEmptyClipboard() throws IOException, UnsupportedFlavorException {
        // Define a área de transferência do sistema como nula
        clipboard = mock(Clipboard.class);
        when(clipboard.getData(DataFlavor.stringFlavor)).thenReturn(null);

        // Executa o método para testar
        ClipboardToTxt.main(null);

        // Verifica se o arquivo não foi criado
        File file = new File("test.txt");
        assertEquals(false, file.exists());
    }

    @Test
    public void testClipboardToTxtWithNullFileName() throws IOException, UnsupportedFlavorException {
        // Define uma caixa de diálogo de entrada de nome do arquivo como nula
//        optionPane = mock(JOptionPane.class);
//        when(optionPane.showInputDialog("Digite no nome do arquivo!")).thenReturn(null);

        // Executa o método para testar
        ClipboardToTxt.main(null);

        // Verifica se o arquivo não foi criado
        File file = new File("test.txt");
        assertEquals(false, file.exists());
    }
}

