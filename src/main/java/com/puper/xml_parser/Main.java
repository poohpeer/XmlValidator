package com.puper.xml_parser;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Puper on 27/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("<tag>Hello</tag>",
                "<tag2>Bye</tag2>",
                "<tag3>Yo!</tag4>");
        final TagParser parser = new TagParser(list);
        final ResultContainer resultContainer = parser.parse();
        final Result result = resultContainer.checkResult();
        if (! result.isOk()){
            System.out.println(result.toString());
        }
    }
}
