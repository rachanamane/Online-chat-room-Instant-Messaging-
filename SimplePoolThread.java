package InstantMessaging;

import java.util.concurrent.LinkedBlockingDeque;

public class SimplePoolThread implements ISimplePoolThread{

    private LinkedBlockingDeque<ISimpleTask> tasks;

    private SimplePoolThread(LinkedBlockingDeque<ISimpleTask> tasks) {
        this.tasks = tasks;
    }
    public void run(){

        while (true) {
            try {
                tasks.take().run();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
