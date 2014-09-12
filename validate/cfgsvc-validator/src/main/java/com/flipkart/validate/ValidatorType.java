package com.flipkart.validate;

/**
 * Created by siddartha.lk on 09/07/14.
 */
public enum ValidatorType {

    RangeCheck,
    RegexCheck,
    urlcheck,
    LengthCheck;

    public static Validator getValidator(ValidatorType type) {
        switch (type) {
            case RangeCheck:
                return new RangeCheck();
            case LengthCheck:
                return new LengthCheck();
            case RegexCheck:
                return new Regex();
            case urlcheck:
                return new urlcheck();
        }
        return null;
    }
}
