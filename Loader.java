package threads;

public class Loader implements Runnable {

    private String task;

    public Loader(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.print(task);
            for (int i = 0; i < 4; i++) {
                Thread.sleep(350);
                System.out.print(".");
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Loading interrupted!");
        }
    }
}
