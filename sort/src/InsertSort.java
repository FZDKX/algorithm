import java.util.Arrays;

/**
 * @author 发着呆看星
 * @create 2023/10/16
 * 插入排序：从待数组中依次获取元素，从已排序的数组中找到合适的位置，进行插入
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, -2, 9, 4, 4, 6, -6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        if (arr.length <= 2){
            return;
        }
        // 需要进行插入的次数
        for (int i = 1; i < arr.length; i++) {
            // 获取需要插入的元素
            int num = arr[i];
            int index = i;
            // 找合适的位置
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > num){
                    // j元素后移
                    arr[j+1] = arr[j];
                    // 记录后移元素下标
                    index = j;
                }else {
                    // 碰到相等或更小的元素，说明已经找到合适位置
                    break;
                }
            }
            // 插入
            arr[index] = num;
        }
    }


}
