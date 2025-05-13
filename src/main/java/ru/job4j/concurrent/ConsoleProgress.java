package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {

    private static char[] sequence = new char[] {'-', '\\', '|', '/'};

    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\rLoad " + sequence[count++]);
            count = count == 4 ? 0 : count;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ConsoleProgress());
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
            thread.interrupt();
    }
}
