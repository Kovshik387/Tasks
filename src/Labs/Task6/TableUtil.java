package Labs.Task6;

import Labs.Utility.FileStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TableUtil {

    public static void sortTable(List<Tablet> tabletList){
        Collections.sort(tabletList, new Comparator<Tablet>() {
            @Override
            public int compare(Tablet o1, Tablet o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }

    public static void sortBuyTable(List<Tablet> tabletList){
        Collections.sort(tabletList, new Comparator<Tablet>() {
            @Override
            public int compare(Tablet o1, Tablet o2) {
                return o2.getMemory() - o1.getMemory() + o2.getRating() - o1.getRating();
            }
        });
    }

    public static List<Tablet> buyTablets(List<Tablet> tabletList,int k,int m, int r) {

        List<Tablet> tablets = new ArrayList<Tablet>();

        try {
            if (k > tabletList.size()) throw new Exception("Отсутсвие товара");

            for (int i = 0; i < k;i++) if (tabletList.get(i).isGood(m,r)) tablets.add(tabletList.get(i));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return tablets;
    }

    public static List<Tablet> getTabletList(String path){
        List<Tablet> tabletList = new ArrayList<Tablet>();

        var temp = new FileStream().<String>readArray(path);

        try {
            for (var item : temp) {
                tabletList.add(new Tablet(item.get(0),Integer.parseInt(item.get(1)),Integer.parseInt(item.get(2)),Integer.parseInt(item.get(3))));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return tabletList;
    }

}
