package QString;

public class StringBulderTest01 {
    public static void main(String[] args) {
    String nome = "Wallid Santana";
    nome.concat(" DevDojo");
        System.out.println(nome);
    nome.substring(0,3);
        System.out.println(nome);
    StringBuilder stringBuilder = new StringBuilder(16);// capacidade padrão 16 bits
    stringBuilder.append("Wallid Anubis");
    stringBuilder.append(" DevDojo").append(" Academy");// Substituir por ' + ', eliminar a quantidade de append
    stringBuilder.reverse();
        System.out.println(stringBuilder);
    }
}
