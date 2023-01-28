package dataProcessor;

import java.util.List;

public class DataProcessor {
    public List<Integer> sort(List<Integer> list){
        return list.stream().sorted((e1, e2) -> e2 -e1).toList();
    }

    public int sumEven(List<Integer> list){
        return list.stream().reduce((a, b) -> a + b).get();
    }

    public int avgOdd(List<Integer> list){
        return list.stream().filter(e -> e % 2 == 0).reduce((a, b) -> a + b).get()
                / (int) list.stream().filter(e -> e % 2 == 0).count();
    }

    public int min(List<Integer> list){
        return list.stream().min(Integer::compareTo).get();
    }

    public int max(List<Integer> list){
        return list.stream().max(Integer::compareTo).get();
    }
}