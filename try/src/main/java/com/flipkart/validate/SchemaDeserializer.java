package com.flipkart.validate;

import com.flipkart.validate.Validator;
import com.flipkart.validate.ValidatorType;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.*;

/**
 * Created by siddartha.lk on 02/07/14.
 */

public class SchemaDeserializer extends JsonDeserializer<Schema> {

    @Override
    public Schema deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // {"type": "SomeName", "params": {"param1": "value1", "param2":"value2"}
        Schema schema = new Schema();
        JsonNode node = jp.getCodec().readTree(jp);
        schema.setName(node.get("name").getTextValue());
        JsonNode at = node.get("attributes");
        Iterator<String> attributes = at.getFieldNames();
        List<Attribute> n = new ArrayList<Attribute>();

        while (attributes.hasNext()) {
            Attribute att = new Attribute();
            Validators val = new Validators();
            String st = attributes.next();
            JsonNode temp = at.get(st);
            att.setName(st);
            //System.out.println(temp);
            att.setType(temp.get("type").getTextValue());

            if (temp.get("validator") != null) {
//                ArrayNode nod= (ArrayNode) (temp.get("validator"));
                Iterator<JsonNode> nod = temp.get("validator").getElements();
                JsonNode no = nod.next();
                System.out.println(no.get("type").getTextValue());
                Iterator<String> iter = null;
                if (no.get("param") != null) {
                    iter = no.get("param").getFieldNames();

                }
                Iterator<JsonNode> iter1 = null;
                if (no.get("param") != null) {
                    iter1 = no.get("param").getElements();

                }
                val.setType((no.get("type").getTextValue()));
                ValidatorType type = ValidatorType.valueOf(no.get("type").getTextValue());
                Validator validator = ValidatorType.getValidator(type);
                Map<String, String> params = new HashMap<String, String>();
                if (iter != null) {
                    while (iter.hasNext()) {
                        String s = iter.next();
                        String v = iter1.next().getValueAsText();
                        System.out.println(v);
                        //System.out.println(iter1.next().getTextValue());
                        //JsonNode jn=no.get(s);
                        System.out.println(s);
                        params.put(s, v);
                    }
                    validator.setParams(params);
                    val.setParams(params);
                }
                att.setValidator(val);
                n.add(att);
            }
        }
        schema.setAttributes(n);
        return schema;
    }
}

//                    JsonNode j= jn.get("param");
//                    Iterator<String> t =j.getFieldNames();
//                    Map<String, String> params = new HashMap<String, String>();
//                    while (t.hasNext()) {
////                        String a = t.next();
////                        JsonNode ta = nod.get(a);
//                        String p=t.next();
//                        JsonNode ap=j.get(p);
//                        String pa = ap.getTextValue();
//                        System.out.println("<"+pa);
//
//                        Iterator<String> pl = ap.getFieldNames();
//                        while (pl.hasNext()) {
//                            String lt = pl.next();
//                            JsonNode nl = ap.get(lt);
//                            params.put(lt, (nl.getTextValue()));
//                            System.out.println(nl.getTextValue());
//
//                        }
//                    }
//                    validator.setParams(params);




               // System.out.println("g"+iter.get("type").getTextValue());


                    //System.out.println(nodeIterator.next());
                    //System.out.println(tp.get("type").getTextValue());
                    // add code to populate params map






//                    if(tp.get("type").getTextValue().equals("RangeCheck")){
//                        val.setType(tp.get("type").getTextValue());
//                        JsonNode vn=tp.get("param");
//                        val.params.set((vn.get("min").getIntValue());
//                        val.setMax(vn.get("max").getIntValue());
//                    }
//                    else if((tp.get("type").getTextValue()).equals("RegexCheck")){
//                        val.setType(tp.get("type").getTextValue());
//                        val.setValue(tp.get("value").getTextValue());
//                    }
//                    else if((tp.get("type").getTextValue()).equals("urlcheck")){
//                        val.setType(tp.get("type").getTextValue());
//                    }
