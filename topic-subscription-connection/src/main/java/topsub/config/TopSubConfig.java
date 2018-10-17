package topsub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:bus-topsub.properties"})
public class TopSubConfig {

    @Value("${servicebus.connection-string}")
    private String connectionString;

    @Value("${servicebus.subscription-receive-mode}")
    private String subscriptionReceiveMode;

    @Value("${servicebus.topic}")
    private String topic;

    @Value("${servicebus.topic.subscription}")
    private String topicSubscription;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getSubscriptionReceiveMode() {
        return subscriptionReceiveMode;
    }

    public void setSubscriptionReceiveMode(String subscriptionReceiveMode) {
        this.subscriptionReceiveMode = subscriptionReceiveMode;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicSubscription() {
        return topicSubscription;
    }

    public void setTopicSubscription(String topicSubscription) {
        this.topicSubscription = topicSubscription;
    }
    
}
