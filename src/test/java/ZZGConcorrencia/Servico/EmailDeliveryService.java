package ZZGConcorrencia.Servico;

import ZZGConcorrencia.Dominio.Members;

public class EmailDeliveryService implements Runnable{
    private final Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " starting to delivery emails...");
        while(members.isOpen() || members.pendingEmails() > 0){
            try {
                String email = members.retrieveEmail();
                if (email == null) continue;
                System.out.printf("%s sending email to %s...%n", threadName, email);
                Thread.sleep(2000);
                System.out.printf("%s sent successfully to %s%n", threadName, email);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All emails send successfully !");
    }
}
