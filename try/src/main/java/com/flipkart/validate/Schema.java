package com.flipkart.validate;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.List;

/**
 * Created by siddartha.lk on 01/07/14.
 */
@JsonDeserialize(using = SchemaDeserializer.class)
public class Schema {

    @JsonProperty
    public String name;

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty

    public List<Attribute> attributes;

    @Override
    public String toString() {
        return "Schema{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
