package ZZFThreads;

import ZZFThreads.Dominio.Account;

public class C_ThreadAccontTest01 implements Runnable {
    private static final Account account = new Account();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Valor menores que zero !!! " + account.getBalance());
            }
        }
    }

    public static void main(String[] args) {
        C_ThreadAccontTest01 ThreadAccontTest01 = new C_ThreadAccontTest01();
        Thread t1 = new Thread(ThreadAccontTest01, "Joao");
        Thread t2 = new Thread(ThreadAccontTest01, "Maria");
        t1.start();
        t2.start();
    }

    private void withdrawal(int amount) {
        System.out.println(getThreadName() + " ===== FORA do synchronized");
        synchronized (account) {
            System.out.println(getThreadName() + " %%%%% DENTRO do synchronized");
            if (account.getBalance() >= amount) {
                System.out.println(Thread.currentThread().getName() +
                                   " is going to withdraw the money");
                account.whithdrawal(amount);
                System.out.println(getThreadName() +
                                   " completed withdrawal, current value: " +
                                   account.getBalance());
            } else {
                System.out.println("no money for " +
                                   getThreadName() + ", make the withdrawal.");
            }
        }
    }

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

}
