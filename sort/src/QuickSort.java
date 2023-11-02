import java.util.Arrays;

/**
 * @author 发着呆看星
 * @create 2023/11/2
 * 快速排序：不断地将数组分为3部分 ， 大于 等于 小于 ，直到最后排好序
 * 荷兰国旗问题
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, -2, 9, 4, 6, -6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 选取一个 left与right 之间的 随机数 ， Math.random() 【 >= 0  && < 1 】
            int index = left + (int) (Math.random() * (right - left + 1));
            // 与最后一个数做交换
            BubbleSort.swap(arr, right, index);
            // 进行分区
            int[] partition = partition(arr, left, right);
            // 递归，再次分区
            quickSort(arr, left, partition[0]);
            quickSort(arr, partition[1], right);
        }
    }

    // 荷兰国旗问题，分成三块区域
    public static int[] partition(int[] arr, int start, int end) {
        // 左边界
        int left = start - 1;
        // 右边界
        int right = end + 1;
        // 当前元素指针
        int index = start;
        // 划分值
        int value = arr[end];
        while (index < right){
            if (arr[index] < value) {
                BubbleSort.swap(arr, left + 1, index);
                index++;
                left++;
            } else if (arr[index] > value) {
                BubbleSort.swap(arr, right - 1, index);
                right--;
            } else {
                index++;
            }
        }
        return new int[]{left, right};
    }
}
