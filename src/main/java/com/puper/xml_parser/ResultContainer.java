package com.puper.xml_parser;

import java.util.*;

/**
 * Created by Puper on 27/3/2017.
 */
public class ResultContainer {
    private List<Tag> openingTags = new ArrayList<>();
    private List<Tag> closingTags = new ArrayList<>();

    public ResultContainer(){
    }

    public void addTag(Tag tag){
        if (tag.getTagType() == TagType.OPENING){
            openingTags.add(tag);
        } else {
            closingTags.add(tag);
        }
    }

    public List<Tag> getOpeningTags() {
        return openingTags;
    }

    public List<Tag> getClosingTags() {
        return closingTags;
    }

    public boolean isContains(Tag tag){
        final List<Tag> findIn;
        if (tag.getTagType() == TagType.OPENING){
            findIn = getClosingTags();
        } else {
            findIn = getOpeningTags();
        }

        for (Tag iterTag : findIn) {
//            String iterTagName;
//            if (iterTag.getTagType() == com.puper.xml_parser.TagType.CLOSING){
//                iterTagName = tag.getTagName().replace("/", "");
//            } else {
//                iterTagName = tag.getTagName();
//            }
            if (iterTag.getTagName().contains(tag.getTagName().replace("/",""))) {
                return true;
            }
        }
        return false;
    }

    public Result checkResult(){
        List<Tag> missingOpeningTags = new ArrayList<>();
        List<Tag> missingClosingTags = new ArrayList<>();
        for (Tag openTag : getOpeningTags()) {
            if (! isContains(openTag)){
                missingOpeningTags.add(openTag);
            }
        }
        for (Tag closeTag : getClosingTags()) {
            if (! isContains(closeTag)){
                missingClosingTags.add(closeTag);
            }
        }
        return new Result(missingOpeningTags, missingClosingTags);
    }
}
