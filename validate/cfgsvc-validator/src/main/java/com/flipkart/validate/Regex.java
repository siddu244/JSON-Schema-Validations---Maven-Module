package com.flipkart.validate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
/**
 * Created by siddartha.lk on 24/06/14.
 */
public class Regex extends Validator {


    public String reg;

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;

    }

    @Override
    public void setParams(Map<String, String> params) {
        this.reg=params.get("value");
    }

    @Override
    public boolean validate(Object str) throws InvalidArguementException {
        String st=(String)str;
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(st);
        if(matcher.find()){
            return true;
        }
        else{
            throw new InvalidArguementException("regex did not match");
            //return false;
        }

    }
}
