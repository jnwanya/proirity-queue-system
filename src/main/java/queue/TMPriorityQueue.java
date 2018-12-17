package queue;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Jnwanya on
 * Mon, 17 Dec, 2018.
 */
public class TMPriorityQueue<T extends TMData> {

    private Set<T> elements;

    private LinkedBlockingQueue<T> highPriorityQueue;
    private LinkedBlockingQueue<T> lowPriorityQueue;

    public TMPriorityQueue(int initialCapacity) {
        elements = ConcurrentHashMap.newKeySet(initialCapacity);
        highPriorityQueue = new LinkedBlockingQueue<>();
        lowPriorityQueue = new LinkedBlockingQueue<>();
    }


    public synchronized boolean addElement(T data){
        if(elements.contains(data)){
            return true;
        }
        elements.add(data);
        if(data.getPriority() == TMPriority.HIGH){
            return highPriorityQueue.offer(data);
        }else {
            return lowPriorityQueue.offer(data);
        }
    }

    public synchronized T pollElement(){
        T data = highPriorityQueue.poll();
        if(data != null){
            elements.remove(data);
            return data;
        }
        data = lowPriorityQueue.poll();
        if(data != null){
            elements.remove(data);
        }
        return data;
    }

    @Override
    public String toString() {

        TMData[] array1 = new TMData[highPriorityQueue.size()];
        TMData[] array2 = new TMData[lowPriorityQueue.size()];
        TMData[] combinedArray = ArrayUtils.addAll(highPriorityQueue.toArray(array1), lowPriorityQueue.toArray(array2));
        return Arrays.toString(combinedArray);
    }

    public int size() {
        return highPriorityQueue.size() + lowPriorityQueue.size();
    }
}
