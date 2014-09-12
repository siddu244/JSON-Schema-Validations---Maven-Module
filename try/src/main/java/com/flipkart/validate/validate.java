package com.flipkart.validate;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by siddartha.lk on 12/06/14.
 */

public class validate {

    public static void main(String args[]) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        //Schema schema = mapper.readValue(new File("/Users/siddartha.lk/Desktop/internship/schem.json"), Schema.class);

        File file = new File(new String("/Users/siddartha.lk/Desktop/internship/schem.json"));
        Schema schema = mapper.readValue(file, Schema.class);
        File file1 = new File(new String("/Users/siddartha.lk/Desktop/internship/data.json"));
        //Dataa data = mapper.readValue(file1, Dataa.class);
        System.out.println(schema);
        String str = FileUtils.readFileToString(file1);
        System.out.println(str);
        HashMap<String, Object> result = new ObjectMapper().readValue(str, HashMap.class);
//        // display to console
        //System.out.println(dataa);
        Iterator it = result.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            System.out.println(pairs.getKey() + " = " + pairs.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        if (check(schema, result))
            System.out.println("Json Data is valid according to given schema");
        else
            System.out.println("Invalid json data according to given schema");
    }

    public static boolean check(Schema s, HashMap<String, Object> res) throws Exception {
        Iterator it = res.entrySet().iterator();
        int i = 0;
        while (i != 3 && it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            //Validators v = s.attributes.get(i).getValidator();
            while (it.hasNext()) {
                Map.Entry pairsa = (Map.Entry)it.next();
                System.out.println(pairsa.getKey() + " = " + pairsa.getValue());
                it.remove(); // avoids a ConcurrentModificationException
            }
            System.out.println("<"+pairs.getKey() + pairs.getValue());
            if (s.attributes.get(i).getValidator().getParams() != null) {
                String g = s.attributes.get(i).getValidator().getType();
                System.out.println(g);
                ValidatorType type = ValidatorType.valueOf(g);
                Validator validator = ValidatorType.getValidator(type);
                validator.setParams(s.attributes.get(i).getValidator().getParams());
                if (!(validator.validate(pairs.getValue())))
                    return false;
            }
            i++;
            it.remove();
        }
        return true;
    }
}

//                if(g.equals("RangeCheck")){
//                    RangeCheck rc=new RangeCheck();
//                    rc.setMin((Integer) v.getMin());
//                    rc.setMax((Integer) v.getMax());
//                    switch(i){
//                        case 0:if(!(rc.validate(d.attributes.get(0).getServer())))
//                                    return false;
//                            break;
//
//                        case 1:if(!(rc.validate(d.attributes.get(0).getWorker_threads())))
//                                    return false;
//                            break;
//
//                        case 2:if(!(rc.validate(d.attributes.get(0).getUrl())))
//                                    return false;
//                            break;
//
//                        case 3:if(!(rc.validate(d.attributes.get(0).getChannel_idletime_milis())))
//                                    return false;
//                            break;
//
//                    }
//                }
//                else if(g.equals("RegexCheck")){
//                    Regex reg=new Regex();
//                    reg.setReg((String) v.getValue());
//                    //System.out.println(reg.getReg());
//                    switch(i){
//                        case 0:if(!(reg.validate(d.attributes.get(0).getServer())))
//                                    return false;
//                                break;
//                        case 1:if(!(reg.validate(d.attributes.get(0).getWorker_threads())))
//                                     return false;
//                                break;
//
//                        case 2:if(!(reg.validate(d.attributes.get(0).getUrl())))
//                                    return false;
//                                break;
//
//                        case 3:if(!(reg.validate(d.attributes.get(0).getChannel_idletime_milis())))
//                                    return false;
//                                break;
//                    }
//                }
//                else if(g.equals("urlcheck")){
//                    //System.out.println("fd");
//                    urlcheck url=new urlcheck();
//                    switch(i){
//                        case 0:if(!(url.validate(d.attributes.get(0).getServer())))
//                            return false;
//                            break;
//
//                        case 1:if(!(url.validate(d.attributes.get(0).getWorker_threads())))
//                            return false;
//                            break;
//
//                        case 2:if(!(url.validate(d.attributes.get(0).getUrl())))
//                            return false;
//                            break;
//
//                        case 3:if(!(url.validate(d.attributes.get(0).getChannel_idletime_milis())))
//                            return false;
//                            break;
//                    }
//                }
//            }



