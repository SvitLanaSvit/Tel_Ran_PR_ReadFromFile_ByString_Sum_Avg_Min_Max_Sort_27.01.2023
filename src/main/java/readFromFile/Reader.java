package readFromFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<String> readFromFile(String path){
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = reader.readLine()) != null){
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException("IOException");
        }
        return list;
    }
}
