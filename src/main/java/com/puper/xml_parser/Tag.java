package com.puper.xml_parser;

/**
 * Created by Puper on 27/3/2017.
 */
public class Tag {

    private final TagType tagType;
    private final String tagName;
    private final int lineNum;
    private final String context;

    public Tag(String tagName, TagType tagType, int lineNum, String context){
        this.tagName = tagName;
        this.tagType = tagType;
        this.context = context;
        this.lineNum = lineNum;
    }

    public String getTagName() {
        return tagName;
    }

    public TagType getTagType() {
        return tagType;
    }

    public int getLineNum() {
        return lineNum;
    }

    public String getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "{\nName: \"" + getTagName() + "\"\n" +
                "Type: \"" + getTagType() + "\"\n" +
                "Line: " + getLineNum() + "\n" +
                "Context: \"" + getContext() +  "\"\n}";
    }
}
