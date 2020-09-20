package behavioral;

import java.util.Arrays;

public class Strategy {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();

        int[] arr0 = {1,2,3,4};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr0);

        int[] arr1 = {1,4,5,8};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr1);

        int[] arr2 = {-10, 1, 2, 6};
        c.setStrategy(new InsertSort());
    }
}

//Context
class StrategyClient {
    Sorting strategy;
    public void setStrategy( Sorting strategy) { this.strategy = strategy; }
    public void executeStrategy(int[] arr) {strategy.sort(arr);}
}

//Strategy
interface Sorting {
    void sort(int[] arr);
}

//Bubble Sort Strategy
class BubbleSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Bubble Sorting");
        System.out.println("before: \t" + Arrays.toString(arr));
        for(int barier = arr.length-1; barier>=0;barier--) {
            for(int i=0; i<barier;i++) {
                if(arr[i]>arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        System.out.println("after: \t" + Arrays.toString(arr));
    }
}

//Selection Sort Strategy
class SelectionSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Selection Sorting");
        System.out.println("before: \t" + Arrays.toString(arr));
        for (int barier = arr.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier + 1;i++) {
                if (arr[i] < arr[barier]) {
                    int tmp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }
        System.out.println("after: \t" + Arrays.toString(arr));
    }
}

//Insert Sort Strategy
class InsertSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Insert Sorting");
        System.out.println("before: \t" + Arrays.toString(arr));
        for (int barier = 1; barier < arr.length; barier++) {
            for (int i = 0; i < barier + 1; i++) {
                int index = barier;
                while (index - 1 >= 0 && arr[index] < arr[index]) {
                    int tmp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = tmp;
                    index--;
                }
            }
            System.out.println("after: \t" + Arrays.toString(arr));
        }
    }
}