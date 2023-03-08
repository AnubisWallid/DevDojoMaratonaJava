package ZZGConcorrencia.Dominio;


public class Discount {
    public enum Code{
        NONE(0),
        FIVE(5),
        TEN(10),
        FIFTEEN(15);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }

        public int getPercentage() {
            return percentage;
        }
    }
}
