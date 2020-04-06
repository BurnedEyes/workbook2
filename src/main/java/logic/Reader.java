package logic;

import java.util.List;

public interface Reader {

    List<String[]> read(String filePath, Object ...additionalParameters);

}
