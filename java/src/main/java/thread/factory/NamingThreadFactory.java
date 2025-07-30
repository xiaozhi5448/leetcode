package thread.factory;

import lombok.Getter;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Getter

public class NamingThreadFactory implements ThreadFactory {

    private AtomicInteger threadIndex = new AtomicInteger(0);

    private String name;

    public NamingThreadFactory(String name){
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("naming-thread#" + name + "#id:" + threadIndex.incrementAndGet());
        return thread;
    }
}
