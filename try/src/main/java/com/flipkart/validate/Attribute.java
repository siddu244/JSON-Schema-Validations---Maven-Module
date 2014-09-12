package com.flipkart.validate;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by siddartha.lk on 01/07/14.
 */

public class Attribute {

    @JsonProperty
    public boolean required;

    @JsonProperty
    private boolean repeated;


    @JsonProperty
    private String type;

    @JsonProperty
    public String name;

    Validators validator = new Validators();


    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isRepeated() {
        return repeated;
    }

    public void setRepeated(boolean repeated) {
        this.repeated = repeated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Validators getValidator() {
        return validator;
    }

    public void setValidator(Validators validator) {
        this.validator = validator;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "required=" + required +
                ", repeated=" + repeated +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", validator=" + validator +
                '}';
    }
//    public String toString() {
//        return "Attributes{" +
//                "required=" + required +
//                ", name='" + name + '\'' +
//                ", validators=" + validators +
//                ", server=" + server +
//                ", worker_threads=" + worker_threads +
//                ", listen_port=" + listen_port +
//                ", channel_idletime_milis=" + channel_idletime_milis +
//                ", threads=" + threads +
//                ", uds=" + uds +
//                ", socketName=" + socketName +
//                ", socketDir=" + socketDir +
//                '}';
//    }
}

