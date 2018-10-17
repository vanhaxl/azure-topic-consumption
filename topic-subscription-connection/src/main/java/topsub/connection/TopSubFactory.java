package topsub.connection;

import com.microsoft.azure.servicebus.ReceiveMode;
import com.microsoft.azure.servicebus.SubscriptionClient;
import com.microsoft.azure.servicebus.TopicClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import topsub.config.TopSubConfig;

import javax.annotation.PostConstruct;

@Component
public class TopSubFactory {

    @Autowired
    private TopSubConfig topSubConfig;

    private TopicClient topicClient;

    private SubscriptionClient subscriptionClient;

    @PostConstruct
    public void init() throws ServiceBusException, InterruptedException {
        topicClient = new TopicClient(new ConnectionStringBuilder(topSubConfig.getConnectionString(), topSubConfig.getTopic()));

        subscriptionClient = new SubscriptionClient(new ConnectionStringBuilder(topSubConfig.getConnectionString(), topSubConfig.getTopic()
                + "/subscriptions/" + topSubConfig.getTopicSubscription()), ReceiveMode.PEEKLOCK);
    }

    @Bean
    public TopicClient getTopicClient() throws ServiceBusException, InterruptedException {
        if (this.topicClient == null) {
            this.init();
        }
        return topicClient;
    }

    @Bean
    public SubscriptionClient getSubscriptionClient() throws ServiceBusException, InterruptedException {
        if (this.subscriptionClient == null) {
            this.init();
        }
        return this.subscriptionClient;
    }
}
