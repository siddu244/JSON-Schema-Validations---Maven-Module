package com.flipkart.validate;

import java.util.Map;

/**
 * Created by siddartha.lk on 24/06/14.
 */
public class LengthCheck extends Validator {

    public int min=Integer.MIN_VALUE;
    public int max=Integer.MAX_VALUE;
    public int length;
    public int c;

    @Override
    public void setParams(Map<String, String> params) {
        if(params.get("min")!=null)
            this.min=Integer.parseInt(params.get("min"));
        else if(params.get("max")!=null)
            this.max=Integer.parseInt(params.get("max"));
        //max=(Integer)params.get("max");
    }

    @Override
    public boolean validate(Object obj)throws Exception {
        String str = (String) obj;
        RangeCheck range = new RangeCheck();
        range.set(min, max);
        try {
            if(c==1)
            {
                if(!(length==str.length()))
                    throw new InvalidArguementException("String is out of length");
            }
            else if (!range.validate(str.length())) {
                throw new InvalidArguementException("String length not in range");
            }

        }
        catch(InvalidArguementException e){
            System.err.println(e);
            return false;
        }
        return true;
    }
    public void set(int min,int max){
        this.min=min;
        this.max=max;

    }

    public void setLength(int l){
        c++;
        this.length=l;
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

    public void setMax(int max) {
        this.max = max;
    }

}
