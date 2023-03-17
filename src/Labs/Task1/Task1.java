package Labs.Task1;

import java.util.Scanner;

public class Task1 {

    public void printFigure(int s) {
        if (s >= 2 && s % 2 == 0) {
            // Верхняя часть фигуры
            for (int i = s / 2; i < s; i++) {
                for (int space = 0; space < s / 2; space++) System.out.print(" ");  // Отступ для верхней части фигуры

                if (i == s/ 2 || i + 1== s) {                               //Отрисовка верхней и нижней границы
                    for (int ij = i; ij < s; ij++) System.out.print("*");
                    System.out.println();
                    continue;
                }

                for (int j = i; j < s;j++){                                 //Отрисовка тела фигуры
                    if (j == i || j == s - 1) System.out.print("*");
                    else System.out.print("#");
                }

                System.out.println();
            }
            //Нижняя часть
            for (int i = 0; i < s/2 ;i++){
                for (int space = s/2; space > i +1; space--) System.out.print(" ");

                if (i == s/ 2 -1 || i == 0) {                               //Отрисовка верхней и нижней границы
                    for (int ij = 0; ij <= i; ij++) System.out.print("*");
                    System.out.println();
                    continue;
                }

                for (int j = 0; j <= i;j++) {                                 //Отрисовка тела фигуры
                    if (j == i || j == 0) System.out.print("*");
                    else System.out.print("#");
                }

                System.out.println();
            }

        } else System.out.println("Введены неверные параметры");
    }

    public void printFigure2(int h){
        for (int i = 0; i < h;i++){
            if (i == 0) {System.out.println("*"); continue; }

            for (int j = 0; j <= i;j++){
                if (i == h - 1) {
                    if (j == i || j == 0) System.out.print("*");
                    else System.out.print("_");
                    continue;
                }

                if (j == 0) System.out.print("|");

                if (j == i -1) System.out.print("\\");

                System.out.print(" ");
            }
            System.out.println("");

        }
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();

        task1.printFigure(10);
        task1.printFigure2(10);
    }
}

