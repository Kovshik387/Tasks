package Labs.Task5;

import java.util.ArrayList;
import java.util.List;

public class Task22 {

    public static List<Integer> createNewList(ArrayList<Integer> list){
        List<List<Integer>> result = new ArrayList<>();

        int position = -1;
        boolean flag = false;

        for (int i = 0; i < list.size() -1 ;i++){
            if (position == -1) position = i;

            if (list.get(i) <= list.get(i + 1)) {
                if (i == list.size()-2) result.add(list.subList(position, i+2));
                continue;
            }
            else {
                result.add(list.subList(position, i+1));
                position = -1;
            }
        }

        return sort(result);
    }

    private static List<Integer> sort(List<List<Integer>> result) {

        List<Integer> max = new ArrayList<>();

        for (var item : result){
            if (item.size() > max.size()) max = item;
            else if (item.size() == max.size()){
                int sum_item = 0;
                int sum_max  = 0;

                for (int i = 0; i < item.size();i++){
                    sum_item += item.get(i);
                    sum_max += max.get(i);
                }
                if (sum_item > sum_max) return item;
                else return max;
            }
        }

        return max;
    }

    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>() {
            {
                add (1);add(2);add(3);add(4);add(5);add(4);add(5);add(6);add(7);add(9);
            }
        };

        System.out.println(createNewList(list));

    }

}
