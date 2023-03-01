package Labs.Task3;

import java.util.ArrayList;

public class Task {

    public Data findSymitry(int[] arr) {
        Data result = null;

        ArrayList<Data> dataList = new ArrayList<Data>();

        boolean flag = false;

        for (int i = 0; i < arr.length -1;i++){
            for (int j = arr.length -1; j > i;j--){
                if (arr[i]==arr[j]) {
                    for (int k = i,f = j; k <j;k++,f--){
                        if (arr[k] == arr[f]) {
                            flag= true;
                            continue;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        result = new Data(i,j);
                        dataList.add(result);
                    }
                }
            }
        }

        return dataList.get(sortArray(dataList));
    }

    private static int sortArray(ArrayList<Data> arr){
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.size();i++){
            if (arr.get(i).count - arr.get(i).position > max) {
                max = arr.get(i).count - arr.get(i).position;
                index = i;
            }
        }
        return index;
    }

    public static void printArray(Data pos,int[] arr) {
        for (int i = pos.position;i <= pos.count;i++){
            System.out.print(arr[i] + " ");
        }
    }

    record Data(int position,int count){}
        public static void main(String[] args) {

            int[] test = new int[] {5, 1, 3, 1, 3, 5, 1, 5, 3, 7, 8, 8, 9, 8, 8, 5, 1};

            int[] test2 = new int[] {2,1,3,2,3,1,5};

            int[] test3 = new int[] {4, 5, 3, 3, 7, 3, 3, 7, 6, 4, 6, 7, 7, 7, 7, 1};

/*            for (var item : new Task().findSymitry(test)){
                System.out.println(item);
            }*/

            printArray(new Task().findSymitry(test3),test3);

            //System.out.println(new Task().findSymitry(test).get(sortArray(new Task().findSymitry(test))));

        }


}
