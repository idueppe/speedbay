package io.crowdcode.speedbay.product.model;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class Message {

    private String uuid;
    private String author;
    private String text;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message withAuthor(final String author) {
        this.author = author;
        return this;
    }

    public Message withText(final String text) {
        this.text = text;
        return this;
    }

    public Message withUuid(final String uuid) {
        this.uuid = uuid;
        return this;
    }


}
