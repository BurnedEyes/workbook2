package logic;

import exception.FileProcessingException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
    Prn format is printer depended.
    This implementation has following assumptions:
    - additional parameters as fixedWidths to determine structure
 */
public class PrnReader implements Reader {

    @Override
    public List<String[]> read(String filePath, Object... additionalParameters) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.ISO_8859_1);
            List<Integer> fixedWidths = (List<Integer>) additionalParameters[0];
            List<String[]> result = new ArrayList<>();
            for (String line : lines) {
                List<String> splittedLine = new ArrayList<>();
                int begin = 0;
                for (int index : fixedWidths) {
                    splittedLine.add(line.substring(begin, index).trim());
                    begin = index;
                }
                splittedLine.add(line.substring(begin).trim());
                result.add(splittedLine.toArray(new String[0]));
            }
            return result;
        } catch (IOException e) {
            throw new FileProcessingException(e);
        }
    }

}
