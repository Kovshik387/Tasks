package Labs.Task6;

import static Labs.Task6.TableUtil.*;

public class Task22 {
    public static void main(String[] args) throws Exception {

        var tabletList = getTabletList("C:\\Users\\Yrulewet\\IdeaProjects\\TasksJava\\Input\\Task6\\Input1.txt");

        sortTable(tabletList);

        int k = 3; // Количество
        int memory = 2; // Объём памяти
        int rating = 3; // Оценка пользователей

        var result = buyTablets(tabletList,k,memory,rating); // Сортировка

        System.out.println("Ассортимент:");
        for (var item : tabletList) System.out.println(item.toString());
        System.out.println("Куплено:");
        for (var item : result) System.out.println(item.toString());
    }

}
