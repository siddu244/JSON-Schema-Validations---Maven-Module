package com.flipkart.validate;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by siddartha.lk on 12/06/14.
 */

public class RangeCheck extends Validator {
    public int min = Integer.MIN_VALUE;
    public int max = Integer.MAX_VALUE;

    public RangeCheck() {
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
    }

    @Override
    public void setParams(Map<String, String> params) {
        if(params.get("min")!=null)
            this.min=Integer.parseInt(params.get("min"));
        else if(params.get("max")!=null)
            this.max=Integer.parseInt(params.get("max"));
        //max=(Integer)params.get("max");
    }

    public boolean validate(Object ob) throws Exception {
        try {
            if (ob instanceof Integer) {
                Integer num = (Integer) ob;
                if (num < min || num  >max) {
                    throw new InvalidArguementException(num+" is not in range");
                }
            } else if (ob instanceof Float) {
                Float num = (Float) ob;
                Float minn=new Float(min);
                Float maxx=new Float(max);

                if (num < minn || num  >maxx) {
                    throw new InvalidArguementException(num+" is not in range");
                }


            } else if (ob instanceof Double) {
                Double num = (Double) ob;
                Double minn=new Double(min);
                Double maxx=new Double(max);

                if (num < minn || num  >maxx) {
                    throw new InvalidArguementException(num+" is not in range");
                }
            }
        }
        catch (Exception e){
            System.err.println(e);
            return false;

        }
        return true;
    }

    public void set(int min, int max){

        this.min=min;
        this.max=max;

    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {

        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public RangeCheck(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setMax(int max) {

        this.max = max;
    }

}
