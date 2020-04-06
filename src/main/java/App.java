import logic.HTMLRenderer;
import logic.Reader;
import logic.ReaderFactory;

import java.util.*;

public class App {

    private static final String DEFAULT_OUTPUT = "output.html";

    public static void main(String[] args) {
        String filePath = args[0];
        Reader reader = ReaderFactory.choose(filePath);
        List<Integer> additionalParameters = new ArrayList<>();
        if (args.length > 2) {
            for (int i = 2; i < args.length; i++) {
                additionalParameters.add(Integer.parseInt(args[i]));
            }
        }
        List<String[]> read = reader.read(filePath, additionalParameters);
        Map<String, Object> input = new HashMap<>();
        input.put("result", read);
        HTMLRenderer.renderToFile("template.ftl", args.length > 1 ? args[1] : DEFAULT_OUTPUT, input);
    }
}