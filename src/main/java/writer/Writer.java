package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private FileWriter writer;
    private BufferedWriter bw;
    public Writer(String path) {
        try {
            writer = new FileWriter(path);
            bw = new BufferedWriter(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String s) {
        try {
            bw.write(s + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(){
        try {
            bw.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
