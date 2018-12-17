package queue;

import java.io.Serializable;

/**
 * Created by Jnwanya on
 * Mon, 17 Dec, 2018.
 */
public class TMData<T> implements Serializable {

    private T data;

    private TMPriority priority;

    public TMData(T data){
        initializeData(data, TMPriority.HIGH);
    }

    public TMData(T data, TMPriority priority){
        initializeData(data, priority);
    }
    private void initializeData(T data, TMPriority priority) {
        if(data == null || priority == null){
            throw new RuntimeException("Data cannot be null");
        }
        this.priority = priority;
        this.data = data;
    }

    public TMPriority getPriority() {
        return priority;
    }

    public T getData() {
        return data;
    }
}
