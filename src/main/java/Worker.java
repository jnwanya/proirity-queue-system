import client_provider.Client;
import client_provider.Provider;

/**
 * Created by Jnwanya on
 * Mon, 17 Dec, 2018.
 */
public class Worker {

    public static void main(String... args) {
        Provider provider = new Provider(10);

        new Thread(new Client("Client 1", provider.getQueueElement(), provider)).start();
        new Thread(new Client("Client 2", provider.getQueueElement(), provider)).start();
        new Thread(new Client("Client 3", provider.getQueueElement(), provider)).start();
        new Thread(new Client("Client 4", provider.getQueueElement(), provider)).start();
        new Thread(new Client("Client 5", provider.getQueueElement(), provider)).start();
        new Thread(new Client("Client 6", provider.getQueueElement(), provider)).start();
    }

}
