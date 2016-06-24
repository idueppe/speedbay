package io.crowdcode.speedbay.product.model;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class Product {

    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product withId(final Long id) {
        this.id = id;
        return this;
    }

    public Product withName(final String name) {
        this.name = name;
        return this;
    }

    public Product withDescription(final String description) {
        this.description = description;
        return this;
    }


}
