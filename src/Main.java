import Labs.Utility.FileStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<List<String>> arr_two = new FileStream().readArray("C:\\Users\\Yrulewet\\IdeaProjects\\TasksJava\\Input\\Input.txt");

        //convertToInt // Двумерный




/*      List<Integer> one = new FileStream().<String>readArray("Input//Task3//Input1.txt").get(0).stream().map(Integer::parseInt).collect(Collectors.toList());
        int[] arr = one.stream().mapToInt(Integer::intValue).toArray();*/ // Одномерный массив чисел



    }
}