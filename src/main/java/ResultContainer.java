import java.util.ArrayList;
import java.util.List;

/**
 * Created by Puper on 27/3/2017.
 */
public class ResultContainer {
    private List<Tag> tags = new ArrayList<Tag>();

    public ResultContainer(){
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public List<Tag> getTags() {
        return tags;
    }
}
