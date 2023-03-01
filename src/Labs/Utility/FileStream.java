package Labs.Utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileStream {
    public <TData> List<List<TData>> readArray(String path){

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

}
