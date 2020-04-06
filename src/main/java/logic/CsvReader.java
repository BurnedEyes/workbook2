package logic;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import exception.FileProcessingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvReader implements Reader {

    @Override
    public List<String[]> read(String filePath, Object ...additionalParameters) {
        try {
            CSVReader reader = new CSVReader(
                    new InputStreamReader(new FileInputStream(filePath), StandardCharsets.ISO_8859_1));
            return reader.readAll();
        } catch (CsvException | IOException e) {
            throw new FileProcessingException(e);
        }
    }
}
