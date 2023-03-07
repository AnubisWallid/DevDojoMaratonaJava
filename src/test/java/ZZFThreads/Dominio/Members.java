package ZZFThreads.Dominio;

import java.text.MessageFormat;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        synchronized (this.emails) {
            return emails.size();
        }
    }

    public void addMembersEmails(String email) {
        synchronized (this.emails) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " add email in list");
            this.emails.add(email);
            this.emails.notifyAll();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() +
                           " checking if thread there are emails");
        synchronized (this.emails) {
            while (this.emails.size() == 0) {
                if (!open) {
                    return null;
                }
                System.out.printf("%s, No email available in the list, going into standby mode%n",
                        Thread.currentThread().getName());
                this.emails.wait();
            }
            return this.emails.poll();
        }
    }

    public void close() {
        this.open = false;
        synchronized (this.emails) {
            System.out.println(MessageFormat.format(
                    "{0}, Notifying all we are no longer picking up emails"
                    , Thread.currentThread().getName()
            ));
            this.emails.notifyAll();
        }
    }
}
