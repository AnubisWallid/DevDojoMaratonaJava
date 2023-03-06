package ZZFThreads;

import ZZFThreads.Dominio.Members;
import ZZFThreads.Servico.EmailDeliveryService;

import javax.swing.*;

public class G_EmailDeliveryTest01 {
    public static void main(String[] args) {
        Members members = new Members();
        Thread t1_wallid = new Thread(new EmailDeliveryService(members), "Wallid Santana T1");
        Thread t2_santana = new Thread(new EmailDeliveryService(members), "Santana Wallid T2");
        t1_wallid.start();
        t2_santana.start();
        while (true){
                    String seuEmail = JOptionPane.showInputDialog(
                    Thread.currentThread().getName() + "Entre com seu email");
                    System.out.println("valor de entrada: " + seuEmail+".");
                    System.out.println(seuEmail.isEmpty());
                    System.out.println(seuEmail.isBlank());
            if (seuEmail == null || seuEmail.isEmpty() || seuEmail.equals("")){
                members.close();
                break;
            }
            members.addMembersEmails(seuEmail);
        }
    }
}
