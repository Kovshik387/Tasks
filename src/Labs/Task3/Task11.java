package Labs.Task3;

public class Task11 {

    public int findArray(int[] arr){
        int result = 0;
        int sub_result = 0;
        int number = 0;

        for (int i = 0; i < arr.length - 1;i ++){
            if (arr[i] == arr[i+1]) {
                sub_result+=arr[i];
                number = arr[i];
            }
            else if (result < sub_result + number) {
                result = sub_result + number;
                sub_result = 0;
                number = 0;
            }
            else sub_result = 0;
        }

        if (result < sub_result + number) {
            result = sub_result + number;
            sub_result = 0;
            number = 0;
        }

        return result;
    }


    public static void main(String[] args) {

        var test = new int[] {2,2,2,2,2,2,2,2,2,2,2,54,54,54,54,54,54,54,54,4,4,4,4,5,5,5,5,45};
        System.out.println(new Task11().findArray(test));
    }

}


