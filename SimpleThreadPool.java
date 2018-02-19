package InstantMessaging;

import java.util.concurrent.LinkedBlockingDeque;

public class SimpleThreadPool implements ISimpleThreadPool {

    private LinkedBlockingDeque<ISimpleTask> tasks = new LinkedBlockingDeque<>();
    Thread thread ;

    public void start(){
        thread = new Thread(new SimplePoolThread(this.tasks));
        thread.start();

    }
    public void stop(){
        thread.interrupt();
    }
    public void addTask(ISimpleTask task){
        try {
            tasks.put(task);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
