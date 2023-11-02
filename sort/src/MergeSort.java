import java.util.Arrays;

/**
 * @author 发着呆看星
 * @create 2023/11/1
 * 归并排序：分治思想，
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, -2, 9, 4, 6, -6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length-1);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        // 临时数组
        int[] temp = new int[end - start + 1];
        // 左指针
        int left = start;
        // 右指针
        int right = mid + 1;
        // 临时数组指针
        int index = 0;
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        if (left > mid) {
            while (index < temp.length) {
                temp[index++] = arr[right++];
            }
        } else {
            while (index < temp.length) {
                temp[index++] = arr[left++];
            }
        }
        // 将temp数组元素 拷贝到 arr数组
        // temp从0开始 ，arr从start开始 ，拷贝 temp.length个
        System.arraycopy(temp, 0, arr, start, temp.length);
    }
}
