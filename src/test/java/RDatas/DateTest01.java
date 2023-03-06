package RDatas;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        Date data = new Date();
        data.setTime(data.getTime());
        System.out.println(data);
    }
}
