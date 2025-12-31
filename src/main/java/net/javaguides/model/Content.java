package net.javaguides.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contents")
public class Content {

    @Id
    private String id;
    private String topic;
    private String explanation;

    public Content() {}

    public Content(String topic, String explanation) {
        this.topic = topic;
        this.explanation = explanation;
    }

    public String getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
