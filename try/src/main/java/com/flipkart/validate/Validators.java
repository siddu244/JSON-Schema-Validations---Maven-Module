package com.flipkart.validate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by siddartha.lk on 02/07/14.
 */
public class Validators {

    private String type;
    Object min;
    String value;

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object getMax() {
        return max;
    }

    public void setMax(Object max) {
        this.max = max;
    }

    public Object getMin() {
        return min;
    }

    public void setMin(Object min) {
        this.min = min;
    }

    Object max;

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    Map<String, String> params = new HashMap<String, String>();

    @Override
    public String toString() {
        return "Validators{" +
                "type='" + type + '\'' +
                ", min=" + min +
                ", value='" + value + '\'' +
                ", max=" + max +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
