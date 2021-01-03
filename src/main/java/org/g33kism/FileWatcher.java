package org.g33kism;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.g33kism.consumer.Consumer;
import org.g33kism.pojo.Directory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

@Slf4j
public class FileWatcher<T> {
    private List<Directory> directories;
    private List<Consumer<T>> consumers;
    private int queueDepth;
    private BlockingQueue<T> queue;
    private int retryCount;
    @Builder
    FileWatcher(List<Directory> directories,List<Consumer<T>> consumers){
        this.directories=directories;
        this.consumers=consumers;
        queue= new ArrayBlockingQueue<>(queueDepth);
    }
    public void watch(){

    }

    public void perform(){

    }

    private void consume(T o){
        List<Future<Boolean>> returns = new ArrayList<>();
        for(Consumer<T> consumer:consumers){
           returns.add(consumer.consume(o));
        }
        retry(returns);
    }

    private void retry(List<Future<Boolean>> returns) {
        //TODO
    }
}
