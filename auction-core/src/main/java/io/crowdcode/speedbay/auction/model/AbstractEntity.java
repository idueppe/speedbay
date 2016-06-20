package io.crowdcode.speedbay.auction.model;

import io.crowdcode.speedbay.common.Identifiable;

import java.io.Serializable;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AbstractEntity<T extends AbstractEntity, ID extends Serializable> implements Identifiable<ID> {

    private ID id;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }


    @SuppressWarnings("unchecked")
    public T withId(final ID id) {
        this.id = id;
        return (T) this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity<?, ?> that = (AbstractEntity<?, ?>) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
