package array_list;

/**
 * @author 发着呆看星
 * @create 2023/10/25
 * 自定义集合
 */
public class MyArrayList<T> {
    private Object[] array;

    private int index = 0;

    private int length;

    private double LOAD = 0.75;

    // 默认数组长度
    public MyArrayList() {
        this.array = new Object[10];
        this.length = 10;
    }

    // 指定数组长度
    public MyArrayList(int length) {
        this.array = new Object[length];
        this.length = length;
    }


    // 在数组末尾添加元素
    public void add(T t) {
        if (index > length * LOAD) {
            // 扩容
            dilatation();
        }
        // 添加元素
        array[index++] = t;
    }

    // 在指定位置添加元素
    public void add(int index , T t){
        if (index < 0 || index > this.index){
            throw new RuntimeException("索引越界");
        }
        if (this.index > length * LOAD) {
            // 扩容
            dilatation();
        }
        for (int i = this.index-1; i >= index; i--) {
            array[i+1] = array[i];
        }
        array[index] = t;
        this.index++;
    }

    // 移除数组末尾元素
    public void remove() {
        if (index == 0) {
            throw new RuntimeException("索引越界");
        }
        array[index - 1] = null;
        index--;
    }


    // 移除指定位置元素
    public void remove(int index){
        if (index < 0 || index >= this.index){
            throw new RuntimeException("索引越界");
        }
        for (int i = index + 1; i < this.index; i++) {
            array[i-1] = array[i];
        }
        array[this.index-1] = null;
        this.index--;
    }

    // 修改指定位置元素
    public void update(int index, T t) {
        if (index < 0 || index >= this.index){
            throw new RuntimeException("索引越界");
        }
        array[index -1] = t;
    }


    // 查
    public T findByIndex(int index){
        if (index < 0 || index >= this.index){
            throw new RuntimeException("索引越界");
        }
        return (T) array[index];
    }

    // 数组扩容
    public void dilatation() {
        Object[] temp = new Object[length * 2];
        if (index >= 0) System.arraycopy(array, 0, temp, 0, index);
        array = temp;
        this.length *= 2;
    }

    public void print(){
        System.out.println("数组元素如下");
        for (int i = 0; i < index; i++) {
            System.out.println(array[i]);
        }
    }

    public int getIndex() {
        return index;
    }

    public int getLength() {
        return length;
    }
}