package logic;

import exception.UnsupportedFileExtensionException;

public class ReaderFactory {

    public static Reader choose(String filePath) {
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        Reader reader;
        switch (extension) {
            case "csv":
                reader = new CsvReader();
                break;
            case "prn":
                reader = new PrnReader();
                break;
            default:
                throw new UnsupportedFileExtensionException(extension);
        }
        return reader;
    }
}
