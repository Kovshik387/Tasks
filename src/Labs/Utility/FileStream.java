package Labs.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileStream {
    public static <TData> List<List<TData>> readArray(String path){

        File file = null;
        Scanner scanner = null;

        try{
            file = new File(path);
            scanner = new Scanner(file);

            List<List<TData>> data = new ArrayList<List<TData>>();
            List<TData> tDataList = new ArrayList<TData>();

            while(scanner.hasNextLine()){
                var line = scanner.nextLine().split(" ");
                for (var item : line) tDataList.add((TData)item);
                data.add(tDataList.stream().collect(Collectors.toList())); tDataList.clear();
            }

            scanner.close();

            return data;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            if (scanner != null) scanner.close();
        }

        return null;
    }

    public static int[][] convertToInt(List<List<String>> arr){
        List<List<Integer>> temp = new ArrayList<>();
        for (var item : arr){
            List<Integer> tempSub = item.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            temp.add(tempSub);
        }

        return temp.stream().map(l -> l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
    public static <TData> void writeArray2D(List<List<TData>> arr,String path) throws FileNotFoundException {

        try {
            File file = new File(path);
            PrintWriter printWriter = new PrintWriter(file);

            for (var item : arr){
                for (var subItem : item){
                    printWriter.print(subItem.toString());
                }
            }
            printWriter.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    public static void writeArray(String arr,String path) throws FileNotFoundException {
        File file = new File(path);
        PrintWriter printWriter = new PrintWriter(file);

        printWriter.print(arr);

        printWriter.close();
    }

    public static List<Integer> convertToList (int[] arr){
        List<Integer> list = new ArrayList<>();
        for (int item : arr) list.add(item);
        return list;
    }


}