package client_provider;

import queue.QueueData;
import queue.TMPriority;
import queue.TMPriorityQueue;

/**
 * Created by Jnwanya on
 * Mon, 17 Dec, 2018.
 */
public class Provider implements Client.OnCompleteListener {

    private TMPriorityQueue<QueueData> priorityQueue;
    public Provider(int capacity){
         priorityQueue = new TMPriorityQueue<>(capacity);
         for(int i = 1; i < capacity; i++){
             int value = (int) (Math.random() * 50 + 1);
              if(value > 30){
                  priorityQueue.addElement(new QueueData(value, TMPriority.HIGH));
              }else {
                  priorityQueue.addElement(new QueueData(value, TMPriority.LOW));
              }
         }
        System.out.println("Queue initialised successfully");
        System.out.println(priorityQueue.toString());
    }

    public QueueData getQueueElement() {
        try {
            return priorityQueue.pollElement();
        } finally {
            System.out.println("NUMBER DEQUEUED, QUEUE CONTENT: " + priorityQueue.toString());
        }
    }

    @Override
    public void onComplete(QueueData data) {
         priorityQueue.addElement(data);
         System.out.println(priorityQueue.toString());
    }
}
