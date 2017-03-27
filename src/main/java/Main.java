import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Puper on 27/3/2017.
 */
public class Main {
    public static void main(String[] args) {
        List list = Arrays.asList("<tag>Hello</tag>",
                "<tag2>Bye</tag2>",
                "<tag3>Yo!</tag3>");
        final TagParser parser = new TagParser(list);
        final ResultContainer resultContainer = parser.parse();
        resultContainer.getTags().stream().forEach(System.out::println);
//        System.out.println(resultContainer.toString());
    }
}
