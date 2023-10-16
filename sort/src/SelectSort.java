import java.util.Arrays;

/**
 * @author 发着呆看星
 * @create 2023/10/16
 * 选择排序：遍历数组，选择出最小的数，与数组第一个数进行交换，循环往复
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, -2, 9, 4, 6, -6};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 选择
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            // 交换
            BubbleSort.swap(arr, i, index);
        }
    }

}
