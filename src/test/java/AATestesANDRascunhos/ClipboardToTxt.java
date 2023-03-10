package AATestesANDRascunhos;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.FileWriter;

public class ClipboardToTxt {
    public static void main(String[] args) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String data;
        try {
            boolean getDataNotNull = (clipboard.getData(DataFlavor.stringFlavor) == null);
            if (getDataNotNull) {
                System.out.println("O conteúdo da área de transferência está vazia");
                data = null;
            } else {
                data = (String) clipboard.getData(DataFlavor.stringFlavor);
            }
            String fileName;
            fileName = JOptionPane.showInputDialog("Digite no nome do arquivo!");
            assert fileName != null;
            String concat = fileName.concat(".txt");
            FileWriter writer = new FileWriter(concat);
            assert data != null;// if (data == null) throw new AssertionError();
            writer.write(data);
            writer.close();
            System.out.println("O conteúdo da área de transferência foi salvo com sucesso no arquivo "+concat);
        } catch (Exception e) {
            System.out.printf("Ocorreu um erro ao salvar o conteúdo da área de transferência: '%s'",e.getMessage());
        }
    }
}

