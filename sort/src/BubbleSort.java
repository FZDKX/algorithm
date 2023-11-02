import java.util.Arrays;

/**
 * @author 发着呆看星
 * @create 2023/10/16
 * 冒泡排序：不断的交换，选出最大的数，放在最后，循环进行
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1 ,0 ,2 ,-2 ,9 ,4 ,6 ,-6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        if (arr.length <= 2){
            return;
        }
        // 循环冒泡
        for (int i = 0; i < arr.length - 1; i++) {
            // 冒泡
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 不断交换，将最大的数交换到最后
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr , int i , int j){
        if (i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}