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

    @Value("${servicebus.topic1}")
    private String topic1;

    @Value("${servicebus.topic1.subscription1}")
    private String topic1Subscription1;

    @Value("${servicebus.topic1.subscription2}")
    private String topic1Subscription2;

    @Value("${servicebus.topic2}")
    private String topic2;

    @Value("${servicebus.topic2.subscription1}")
    private String topic2Subscription1;

    @Value("${servicebus.topic2.subscription2}")
    private String topic2Subscription2;

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

    public String getTopic1() {
        return topic1;
    }

    public void setTopic1(String topic1) {
        this.topic1 = topic1;
    }

    public String getTopic1Subscription1() {
        return topic1Subscription1;
    }

    public void setTopic1Subscription1(String topic1Subscription1) {
        this.topic1Subscription1 = topic1Subscription1;
    }

    public String getTopic1Subscription2() {
        return topic1Subscription2;
    }

    public void setTopic1Subscription2(String topic1Subscription2) {
        this.topic1Subscription2 = topic1Subscription2;
    }

    public String getTopic2() {
        return topic2;
    }

    public void setTopic2(String topic2) {
        this.topic2 = topic2;
    }

    public String getTopic2Subscription1() {
        return topic2Subscription1;
    }

    public void setTopic2Subscription1(String topic2Subscription1) {
        this.topic2Subscription1 = topic2Subscription1;
    }

    public String getTopic2Subscription2() {
        return topic2Subscription2;
    }

    public void setTopic2Subscription2(String topic2Subscription2) {
        this.topic2Subscription2 = topic2Subscription2;
    }
}
