package main;

import dataProcessor.DataProcessor;
import exception.InvalidLineException;
import parser.Parser;
import readFromFile.Reader;
import writer.Writer;
import java.util.List;

public class Main {
    static String pathToRead = "seq2.txt";
    static int counter = 1;

    public static void main(String[] args) {
        Reader reader= new Reader();
        Writer writer = new Writer(pathToRead.substring(0, 4) + "_sorted.txt");
        Writer writerDataPro = new Writer(pathToRead.substring(0, 4) + "_dataProgress.txt");
        DataProcessor dataProcessor = new DataProcessor();
        List<String> list = reader.readFromFile(pathToRead);
        //int counter = 1;

        list.forEach(s -> {
            try {
                writer.write(dataProcessor.sort(Parser.pars(s, counter)).toString());
                writerDataPro.write("Line #" + counter + "; " +
                        "SEven: " + dataProcessor.sumEven(Parser.pars(s, counter)) + "; " +
                        "AOdd: " + dataProcessor.avgOdd(Parser.pars(s, counter)) + "; " +
                        "Max: " + dataProcessor.max(Parser.pars(s, counter)) + "; " +
                        "Min: " + dataProcessor.min(Parser.pars(s, counter)));
            } catch (InvalidLineException e) {
                writer.write(e.getMessage());
            }
            counter++;
        });

//        for (String s: list) {
//            try {
//                writer.write(dataProcessor.sort(Parser.pars(s, counter)).toString());
//                writerDataPro.write("Line #" + counter + "; " +
//                        "SEven: " + dataProcessor.sumEven(Parser.pars(s, counter)) + "; " +
//                        "AOdd: " + dataProcessor.avgOdd(Parser.pars(s, counter)) + "; " +
//                        "Max: " + dataProcessor.max(Parser.pars(s, counter)) + "; " +
//                        "Min: " + dataProcessor.min(Parser.pars(s, counter)));
//
//            } catch (InvalidLineException e) {
//                writer.write(e.getMessage());
//            }
//            counter++;
//        }

        writer.close();
        writerDataPro.close();
    }
}