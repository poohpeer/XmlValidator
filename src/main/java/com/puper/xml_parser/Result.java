package com.puper.xml_parser;

import java.util.List;

/**
 * Created by Puper on 28/3/2017.
 */
public class Result {
    private List<Tag> missingOpeningTags;
    private List<Tag> missingClosingTags;

    public Result(List<Tag> missingOpeningTags, List<Tag> missingClosingTags){
        this.missingOpeningTags = missingOpeningTags;
        this.missingClosingTags = missingClosingTags;
    }

    public List<Tag> getMissingClosingTags() {
        return missingClosingTags;
    }

    public List<Tag> getMissingOpeningTags() {
        return missingOpeningTags;
    }

    public boolean isOk(){
        return !(missingClosingTags.size() > 0 || missingOpeningTags.size() > 0);
    }

    public String toString(){
        String missingOpeningTags = "\nMissing opening tags:\n";
        for (Tag tag : this.missingOpeningTags){
            missingOpeningTags += tag.toString();
        }
        String missingClosingTags = "\nMissing closing tags:\n";
        for (Tag tag : this.missingClosingTags){
            missingClosingTags += tag.toString();
        }
        return missingOpeningTags + "\n" + missingClosingTags;
    }
}
