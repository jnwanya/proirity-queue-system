package queue;

/**
 * Created by Jnwanya on
 * Sun, 16 Dec, 2018.
 */
public class QueueData extends TMData<Integer> {

    private int amount;

    private int proirity;

    public QueueData(int amount) {
        super(amount);
        this.amount = amount;
        proirity = super.getPriority().getValue();
    }

    public QueueData(int amount, TMPriority priority) {
        super(amount, priority);
        this.amount = amount;
        this.proirity = priority.getValue();
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        QueueData queueData = (QueueData) obj;
        return amount == queueData.amount;
    }

    @Override
    public int hashCode() {
        return amount * proirity;
    }

    @Override
    public String toString(){
        return "[amt: "+amount+"; proirity: "+proirity+"]";
    }
}
