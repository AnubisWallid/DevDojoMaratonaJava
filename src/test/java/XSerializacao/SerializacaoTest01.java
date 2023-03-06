package XSerializacao;

import XSerializacao.dominio.Aluno;
import XSerializacao.dominio.Turma;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest01 {
    public static void main(String[] args) {
        Turma turma = new Turma("1 ano B");
        Aluno aluno1 = new Aluno(123456, "Wallid Santana", "0123456789",turma);
        salvarSerializar(aluno1);
        deserializar();

    }

    private static void salvarSerializar(Aluno aluno) {
        Path path = Paths.get("Pasta/aluno.ser");
        try (ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectStream.writeObject(aluno);
        } catch (IOException o) {
            o.printStackTrace();
        }
    }

    private static void deserializar() {
        Path path = Paths.get("Pasta/aluno.ser");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            Aluno aluno = (Aluno) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException o) {
            o.printStackTrace();
        }
    }

}
