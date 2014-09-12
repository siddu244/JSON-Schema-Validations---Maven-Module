package com.flipkart.validate;


import javax.xml.bind.ValidationEvent;
import java.net.*;
import java.io.*;
import java.util.Map;

public class urlcheck extends Validator {
    public String ul;

    @Override
    public void setParams(Map<String, String> params) {
        this.ul=params.get("url");
    }

    @Override
    public boolean validate(Object ul) throws IOException,InvalidArguementException {
        //User user = (User) object;
        String ull=(String)ul;
        URL url = new URL(ull);

        URLConnection connection = url.openConnection();

        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpURLConnection httpConnection = (HttpURLConnection) connection;

        int code = httpConnection.getResponseCode();
        if(code==200)
            return true;
        else{
            throw new InvalidArguementException("url not valid");

        }
    }

}



