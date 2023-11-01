/**
 * @author 发着呆看星
 * @create 2023/11/1
 * 希尔排序：先分组，再排序，再分组，再排序
 */
public class ShellSort {
    public void sort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        // 分组
        for (int i = arr.length / 2; i > 0; i /= 2) {
            // 对每一组进行插入排序
            for (int j = 1; j < arr.length; j++) {
                int index = j;
                int value = arr[j];
                while (index - i >= 0 && value < arr[index - i]){
                    arr[index] = arr[index - i];
                    index -= i;
                }
                if (index != j){
                    arr[index] = value;
                }
            }
        }
    }
}
