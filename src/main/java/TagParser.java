import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Puper on 27/3/2017.
 */
public class TagParser {

    private Tag tag = null;
    private List<String> list = null;
    private final ResultContainer resultContainer = new ResultContainer();
    private Pattern openingTag = Pattern.compile("<(\\w+/?)[>\\s]");
    private Pattern closingTag = Pattern.compile(".*?(</(\\w+)>)");

    public TagParser(List<String> list){
        this.list = list;
    }

    public ResultContainer parse(){
        for (int i = 0; i < list.size(); i++){
            String context = list.get(i);
            tagParser(openingTag, i, context);
            tagParser(closingTag, i, context);
        }
        return this.resultContainer;
    }

    private void tagParser(Pattern regexPattern, int lineNum, String context) {
        final Matcher matcher = regexPattern.matcher(context);
        if (matcher.find()) {
            String tagName = matcher.group(1);
            TagType type = null;
            if (tagName.startsWith("</")) {
                type = TagType.CLOSING;
            } else {
                type = TagType.OPENING;
            }
            final Tag tag = new Tag(tagName, type, lineNum, context);
            this.resultContainer.addTag(tag);
        }
    }

//    public boolean check(List <String> openningTags, List <String> closingTags){
//        for (String tag: openningTags){
//            if (closingTags.contains(tag)){
//
//            }
//        }
//    }
}
