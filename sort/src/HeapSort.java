import java.util.Arrays;

/**
 * @author 发着呆看星
 * @create 2023/11/2
 * 堆排序：构建大顶堆，将堆顶元素放置堆末尾，堆长度-- ，重新构建堆 ，循环往复
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, -2, -2, 4, 4, 4, 3, 99, 4, 6, -6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 某个数现在处于数组的index位置 ，对该数进行heapInsert
    public static void heapInsert(int[] arr, int index) {
        // 父节点下标
        int parent = (index - 1) / 2;
        // 如果当前节点值 大于 父节点值
        while (arr[index] > arr[parent]) {
            // 交换 当前节点与父节点
            BubbleSort.swap(arr, index, parent);
            // 重新对变量赋值
            index = parent;
            parent = (parent - 1) / 2;
        }
    }


    // 对一颗树进行堆化
    public static void heapify(int[] arr, int index, int heapSize) {
        // 头节点的左子节点
        int left = index * 2 + 1;
        // 如果有子节点，进行堆化
        while (left < heapSize) {
            int maxSonIndex = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            if (arr[maxSonIndex] < arr[index]) {
                break;
            }
            BubbleSort.swap(arr, index, maxSonIndex);
            index = maxSonIndex;
            left = maxSonIndex * 2 + 1;
        }
    }


    // 将一个数组构建成一个大顶堆
    public static void builderHeap(int[] arr) {
        if (arr.length < 2) {
            return;
        }
//        从顶向下构建 ，更慢一点
//        for (int i = 1; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }

        // 自底向上构建 ，更快一点
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr,i,arr.length);
        }
    }


    // 将堆顶元素返回，并从堆中移除
    public static void popup(int[] arr, int heapSize) {
        int max = arr[0];
        BubbleSort.swap(arr, 0, heapSize - 1);
        heapify(arr, 0, --heapSize);
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        // 构建大顶堆
        builderHeap(arr);
        int heapSize = arr.length;
        // 排序
        for (int i = 0; i < arr.length - 1; i++) {
            popup(arr, heapSize--);
        }
    }


}
