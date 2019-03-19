package it.sevenbits.practice7.core.Repository;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    private final String id;
    private final String text;

    @JsonCreator
    public Item(@JsonProperty("id") String newId, @JsonProperty("text") String newText) {
        this.text = newText;
        this.id = newId;
    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }
}
