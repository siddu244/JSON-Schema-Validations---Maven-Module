package com.flipkart.validate;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by siddartha.lk on 16/06/14.
 */
public abstract class Validator {

    Map<String,String> params = new HashMap<String, String>();

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public abstract boolean validate(Object str) throws Exception;
}
