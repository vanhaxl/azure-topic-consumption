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
import java.util.ArrayList;
import java.util.List;

@Component
public class TopSubFactory {

    @Autowired
    private TopSubConfig topSubConfig;

    private TopicClient topicClient1; //movie
    private TopicClient topicClient2; //music

    private SubscriptionClient subscriptionClient1;
    private SubscriptionClient subscriptionClient2;
    private SubscriptionClient subscriptionClient3;
    private SubscriptionClient subscriptionClient4;

    @PostConstruct
    public void init() throws ServiceBusException, InterruptedException {
        topicClient1 = new TopicClient(new ConnectionStringBuilder(topSubConfig.getConnectionString(), topSubConfig.getTopic1()));
        topicClient2 = new TopicClient(new ConnectionStringBuilder(topSubConfig.getConnectionString(), topSubConfig.getTopic2()));

        subscriptionClient1 = new SubscriptionClient(new ConnectionStringBuilder(topSubConfig.getConnectionString(), topSubConfig.getTopic1()
                + "/subscriptions/" + topSubConfig.getTopic1Subscription1()), ReceiveMode.PEEKLOCK);

        subscriptionClient2 = new SubscriptionClient(new ConnectionStringBuilder(topSubConfig.getConnectionString(), topSubConfig.getTopic1()
                + "/subscriptions/" + topSubConfig.getTopic1Subscription2()), ReceiveMode.PEEKLOCK);

        subscriptionClient3 = new SubscriptionClient(new ConnectionStringBuilder(topSubConfig.getConnectionString(), topSubConfig.getTopic2()
                + "/subscriptions/" + topSubConfig.getTopic2Subscription1()), ReceiveMode.PEEKLOCK);

        subscriptionClient4 = new SubscriptionClient(new ConnectionStringBuilder(topSubConfig.getConnectionString(), topSubConfig.getTopic2()
                + "/subscriptions/" + topSubConfig.getTopic2Subscription1()), ReceiveMode.PEEKLOCK);
    }

    @Bean
    public TopicClient getTopicMovie() throws ServiceBusException, InterruptedException {
        if (this.topicClient1 == null) {
            this.init();
        }
        return topicClient1;
    }

    @Bean
    public TopicClient getTopicMusic() throws ServiceBusException, InterruptedException {
        if (this.topicClient2 == null) {
            this.init();
        }
        return topicClient2;
    }

    @Bean
    public List<SubscriptionClient> getSubscriptionsOfTopicMovie() throws ServiceBusException, InterruptedException {
        if (this.subscriptionClient1 == null || this.subscriptionClient2 == null) {
            this.init();
        }
        List<SubscriptionClient> result = new ArrayList<>();
        result.add(this.subscriptionClient1);
        result.add(this.subscriptionClient2);
        return result;
    }

    @Bean
    public List<SubscriptionClient> getSubscriptionsOfTopicMusic() throws ServiceBusException, InterruptedException {
        if (this.subscriptionClient3 == null || this.subscriptionClient4 == null) {
            this.init();
        }
        List<SubscriptionClient> result = new ArrayList<>();
        result.add(this.subscriptionClient3);
        result.add(this.subscriptionClient4);
        return result;
    }
}
