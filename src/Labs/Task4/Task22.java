package Labs.Task4;

public class Task22 {

    public int[][] findSaddle(int[][] arr){

        int[][] result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length;i++){
            for (int j = 0; j < arr[i].length;j++){
                if (checkRow(arr,i,j) || chekColl(arr,i,j)) result[i][j] = 1;
                else result[i][j] = 0;
            }
        }

        for (var item : arr) {
            for (var item1 : item) {
                System.out.print(item1+" ");
            }
            System.out.println();
        }

        System.out.println("///////////////////////////////");

        return result;
    }

    private boolean checkRow(int[][] arr, int i, int j){
        boolean ruleRow = false;
        boolean ruleCol = false;

        for (int ik = 0;ik < arr.length ;ik++){             //Вертикаль
            if (arr[i][j] <= arr[ik][j]) ruleCol = true;
            else {
                ruleCol = false;
                break;
            }
        }

        for (int jk =0;jk < arr[i].length;jk++){           // Горизонталь
            if (arr[i][j] >= arr[i][jk]) ruleRow = true;
            else {
                ruleRow = false;
                break;
            }
        }

        return ruleRow == true && ruleCol == true;
    }

    private boolean chekColl(int[][] arr,int i, int j){
        boolean ruleRow = false;
        boolean ruleCol = false;

        for (int ik = 0;ik < arr.length ;ik++){             //Вертикаль
            if (arr[i][j] >= arr[ik][j]) ruleCol = true;
            else {
                ruleCol = false;
                break;
            }
        }

        for (int jk =0;jk < arr[i].length;jk++){           // Горизонталь
            if (arr[i][j] <= arr[i][jk]) ruleRow = true;
            else {
                ruleRow = false;
                break;
            }
        }

        if (ruleRow == true && ruleCol == true) return true;
        else return false;
    }
    //Первак
    private boolean checkCells(int[][] arr, int i, int j){

        boolean ruleRow = false;
        boolean ruleCol = false;

        for (int ik = 0;ik < arr.length ;ik++){             //Вертикаль
            if (arr[i][j] < arr[ik][j]) ruleCol = true;
            else ruleCol = false;
        }

        for (int jk =0;jk < arr[i].length;jk++){           // Горизонталь
            ruleRow = arr[i][j] > arr[i][jk];
        }

        return ruleRow == true && ruleCol == true;
    }


    public static void main(String[] arg){

        var test = new int[][] {
                { 3, -31, -100,4,1,100},
                {322,-5,-89, 4,2,102},
                {220,-2,-770,1,-1,405}
        };

        Task22 task22 = new Task22();

        var result = task22.findSaddle(test);

        for (var item : result) {
            for (var item1 : item) {
                System.out.print(item1+" ");
            }
            System.out.println();
        }

    }

}
