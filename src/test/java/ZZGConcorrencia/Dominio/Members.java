package ZZGConcorrencia.Dominio;

import java.text.MessageFormat;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }
    }

    public void addMembersEmails(String email) {
        lock.lock();
        /*synchronized (this.emails)*/
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " add email in list");
            this.emails.add(email);
            condition.signalAll();
            /*this.emails.notifyAll();*/
        } finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() +
                           " checking if thread there are emails");
        /*synchronized (this.emails)*/
        try {
            while (this.emails.size() == 0) {
                if (!open) {
                    return null;
                }
                System.out.printf("%s, No email available in the list, going into standby mode%n",
                        Thread.currentThread().getName());
                condition.await();
                /*this.emails.wait();*/
            }
            return this.emails.poll();
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        lock.lock();
        this.open = false;
        /*synchronized (this.emails)*/
        try {
            System.out.println(MessageFormat.format(
                    "{0}, Notifying all we are no longer picking up emails"
                    , Thread.currentThread().getName()
            ));
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
