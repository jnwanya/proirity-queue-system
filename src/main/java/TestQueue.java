import queue.QueueData;
import queue.TMPriority;
import queue.TMPriorityQueue;

/**
 * Created by Jnwanya on
 * Mon, 17 Dec, 2018.
 */
public class TestQueue {

    public static void main(String[] args) {
        int capacity = 10;
       /* TMQueue<queue.QueueData> dataTMQueue = new TMQueue<>(capacity);
       // dataTMQueue.add(new queue.QueueData(1, 3));
        for(int i = 1; i <= 10; i++){
            if(i <= 5){
                dataTMQueue.offer(new queue.QueueData(i, 2));
            }else {
                dataTMQueue.offer(new queue.QueueData(i, 3));
            }
        }
       // dataTMQueue.add(new queue.QueueData(8, 2));
        System.out.println("Size: "+dataTMQueue.size());
        System.out.println(dataTMQueue.toString());
        queue.QueueData polledData = dataTMQueue.poll();
        System.out.println("Polled: "+polledData.toString());
        System.out.println(dataTMQueue.toString());
        queue.QueueData polledData2 = dataTMQueue.poll();
        System.out.println("Polled 2: "+polledData2.toString());
        System.out.println(dataTMQueue.toString());
        queue.QueueData polledData3 = dataTMQueue.poll();
        System.out.println("Polled 3: "+polledData3.toString());
        System.out.println(dataTMQueue.toString());
        dataTMQueue.offer(polledData);
        System.out.println("Added: "+polledData.toString());
        System.out.println("Size: "+dataTMQueue.size());
        System.out.println(dataTMQueue.toString()); */


        TMPriorityQueue<QueueData> priorityQueue = new TMPriorityQueue<>(10);
        priorityQueue.addElement(new QueueData(1, TMPriority.LOW));
        priorityQueue.addElement(new QueueData(5, TMPriority.HIGH));
        for(int i = 6; i >= 1; i--){
            if(i <= 4){
                priorityQueue.addElement(new QueueData(i, TMPriority.LOW));
            }else {
                priorityQueue.addElement(new QueueData(i, TMPriority.HIGH));
            }
        }
        System.out.println(priorityQueue.toString());
        System.out.println(priorityQueue.size());

        QueueData queueData1 = priorityQueue.pollElement();
        System.out.println("Polled: "+queueData1.toString());
        System.out.println(priorityQueue.toString());
        QueueData queueData = priorityQueue.pollElement();
        System.out.println("Polled: "+queueData.toString());
        System.out.println(priorityQueue.toString());
        queueData = priorityQueue.pollElement();
        System.out.println("Polled: "+queueData.toString());
        System.out.println(priorityQueue.toString());
        priorityQueue.addElement(queueData1);
        System.out.println("Added: "+queueData1.toString());
        System.out.println(priorityQueue.toString());

    }
}
