package topsubdemo;

import com.microsoft.azure.servicebus.*;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import topsub.connection.TopSubFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication(scanBasePackages = {"topsub.connection", "topsub.config"})
public class TopsubDemoApplication implements CommandLineRunner {

    @Autowired
    TopSubFactory topSubFactory;
    TopicClient topicClient;
    SubscriptionClient subscriptionClient;

    public static void main(String[] args) {
        SpringApplication.run(TopsubDemoApplication.class, args);
    }

    public void init() throws ServiceBusException, InterruptedException {
        this.topicClient = topSubFactory.getTopicClient();
        this.subscriptionClient = topSubFactory.getSubscriptionClient();
    }

    @Override
    public void run(String... args) throws Exception {
        init();
        receiveSubscriptionMessage();
    }

    private void receiveSubscriptionMessage() throws ServiceBusException, InterruptedException {
        subscriptionClient.registerMessageHandler(new MessageHandler(), new MessageHandlerOptions());

    }

    static class MessageHandler implements IMessageHandler {
        public CompletableFuture<Void> onMessageAsync(IMessage message) {
            final String messageString = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println("Received message: " + messageString);
            return CompletableFuture.completedFuture(null);
        }

        public void notifyException(Throwable exception, ExceptionPhase phase) {
            System.out.println(phase + " encountered exception:" + exception.getMessage());
        }
    }
}
