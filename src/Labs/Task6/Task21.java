package Labs.Task6;

import Labs.Utility.FileStream;

import static Labs.Task6.TableUtil.*;

public class Task21 {

    public static void main(String[] args){

        var result = getTabletList("");

        sortBuyTable(result);

        for (var item : result) System.out.println(item.toString());

        int money = 6800;

        for (var item : result) if (item.getPrice() <= 6800){
            System.out.println("Куплен товар\t" + item.toString());
            break;
        }

    }

}
