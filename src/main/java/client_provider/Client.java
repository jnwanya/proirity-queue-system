package client_provider;


import queue.QueueData;

/**
 * Created by Jnwanya on
 * Mon, 17 Dec, 2018.
 */
public class Client implements Runnable {

    private String name;
    private QueueData work;
    private OnCompleteListener completeListener;

    public Client(String name, QueueData work, OnCompleteListener completeListener) {
        this.name = name;
        this.work = work;
        this.completeListener = completeListener;
    }

    @Override
    public void run() {
       doWork();
    }

    public void doWork() {

        try {
            int delay = (int) (Math.random() * 3000 + 8000);
            System.out.println(name + "  is Doing work on " + work.toString());
            Thread.sleep(delay);
            System.out.println(name + "  work done! returning " + work.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        completeListener.onComplete(work);
    }

    public interface OnCompleteListener {
        void onComplete(QueueData data);
    }
}
