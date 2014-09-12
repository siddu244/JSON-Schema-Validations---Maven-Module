package com.flipkart.validate;

import java.util.Locale;



/**
 * Created by siddartha.lk on 23/06/14.
 */
public class TypeValidation extends Validator {
    public Object ob;
    public String type;
    public int c;

    @Override
    public boolean validate(Object st) {
        try {

            switch (c) {
                case 1:
                    if (!(st instanceof Integer)) {
                        throw new InvalidArguementException(st + " is not a int");
                    }
                    break;

                case 2:
                    if (!(st instanceof Float)) {
                        throw new InvalidArguementException(st + " is not a float");
                    }
                    break;

                case 3:
                    if (!(st instanceof Double)) {
                        throw new InvalidArguementException(st + " is not a double");
                    }
                    break;
                case 4:
                    if (!(st instanceof String)) {
                        throw new InvalidArguementException(st + " is not a long");
                    }
                    break;
                case 5:
                    if (!(st instanceof Long)) {
                        throw new InvalidArguementException(st + " is not a long");
                    }
                    break;

            }
        }

        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return  true;
    }

    public void set(String type){
        //this.ob=obj;
        this.type=type;
        if(type.equals("int"))
            c=1;
        else if(type.equals("float"))
            c=2;
        else if(type.equals("double"))
            c=3;
        else if(type.equals("String"))
            c=4;
        else if(type.equals("long"))
            c=5;
    }
}
