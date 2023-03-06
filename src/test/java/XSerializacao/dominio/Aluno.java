package XSerializacao.dominio;

import java.io.*;

public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1853795787381624991L;
    private long id;
    private String nome;
    private transient String password;
    private Turma turma;

    public Aluno(long id, String nome, String password) {
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    private void writeObject(ObjectOutputStream outputStream){
        try {
            outputStream.defaultWriteObject();
            outputStream.writeUTF(turma.getNome());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Serial
    private void readObject(ObjectInputStream inputStream){
        try {
            inputStream.defaultReadObject();
            String nomeTurma = inputStream.readUTF();
            turma = new Turma(nomeTurma);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno(int i, String nome, String password, Turma turma) {
        super();
        this.turma = turma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", Turma='" + turma.getNome() + '\'' +
                '}';
    }
}
