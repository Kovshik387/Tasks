package Labs.Task2;

public class Task2 {
    private double x;
    Task2(int x) {this.x = x;}

    private double calculateSubTask(int n,double e, Ifunction f) {
        double result = 0;
        for (int i = 0; i < n; i++){
            if (Math.abs(f.function(i,x)) > e) result += f.function(i,x);
        }
        return result;
    }

    public static void main(String[] args) {

        var task = new Task2(-1);

        System.out.println("Task 22:");
        System.out.println(task.calculateSubTask(34,0.01,new subTask22()));
        System.out.println(task.calculateSubTask(34,0.001,new subTask22()));
        System.out.println(Math.exp(-task.x));
        System.out.println("|------------------------------------------------|");
        System.out.println("Task 17:");
        System.out.println(task.calculateSubTask(34,0.01,new subTask17()));
        System.out.println(task.calculateSubTask(34,0.001,new subTask17()));
        System.out.println(Math.exp(task.x));
        System.out.println("|------------------------------------------------|");

    }

}

