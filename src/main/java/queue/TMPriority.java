package queue;

/**
 * Created by Jnwanya on
 * Mon, 17 Dec, 2018.
 */
public enum TMPriority {
    LOW(1), HIGH(2);

    private final int value;

    TMPriority(int value){
       this.value = value;
    }

    public int getValue() {
        return value;
    }
}
