package Labs.Task4;

import Labs.Utility.FileStream;


public class Task31 {

    public void sortArray(int[][] arr){
        for (int i = 0; i < arr.length;i++)
            selectionSort(arr,i);
    }

    private void selectionSort(int[][] arr,int position){
        for (int i = 0; i < arr.length - 1;i++){
            int min = i;
            for (int j = i+1;j< arr.length;j++){
                if (arr[j][position] < arr[min][position]){
                    min = j;
                }
            }
            if (min !=i){
                int temp = arr[i][position];
                arr[i][position] = arr[min][position];
                arr[min][position] = temp;
            }
        }
    }


    public static void main(String[] args){

        var test = new int[][] {
                { 3, -31, -100,4,1,100},
                {322,-5,-89, 4,2,102},
                {220,-2,-770,1,-1,405}
        };

        Task31 task31 = new Task31();

        FileStream fileStream;

        int[][] two = new FileStream().<Integer>readArray("C:\\Users\\Yrulewet\\IdeaProjects\\TasksJava\\Input\\Input.txt")
                .stream().map(e -> e.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

        task31.sortArray(two);

        for (var item : test) {
            for (var item1 : item) {
                System.out.print(item1+" ");
            }
            System.out.println();
        }


    }

}
