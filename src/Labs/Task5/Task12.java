package Labs.Task5;

import java.util.ArrayList;
import java.util.List;

public class Task12 {

    public List<Integer> createNewList(List<Integer> list, int n){

        List<Integer> newList = new ArrayList<>();

        boolean flag = true;

        for (int i = 0; i < list.size();i++){
            if (countOfValue(list,list.get(i)) >= n){
                if (newList.isEmpty()) {
                    newList.add(list.get(i));
                    continue;
                }
                for (int count = 0; count < newList.size();count++){
                    if (newList.get(count) == list.get(i)){
                        flag = false;
                        break;
                    }
                }
                if (flag) newList.add(list.get(i));
                flag = true;

            }
        }

        return newList;
    }

    private Integer countOfValue(List<Integer> list,int value){

        int count = 0;

        for (int i = 0; i < list.size();i++){
            if (value == list.get(i)) count++;
        }

        return count;
    }

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(3);list.add(3);list.add(3);list.add(3);
        list.add(2);list.add(2);list.add(2); list.add(1);list.add(1);



        System.out.println(new Task12().createNewList(list,3));

    }

}
