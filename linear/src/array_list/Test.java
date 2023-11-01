package array_list;

/**
 * @author 发着呆看星
 * @create 2023/10/25
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.print();
        arrayList.remove(0);
        arrayList.add(0,11);
        arrayList.print();
        arrayList.add(1,22);
        arrayList.print();
        arrayList.add(1,111);
        arrayList.print();
        arrayList.add(1,112);
        arrayList.add(1,113);
        arrayList.add(1,114);
        arrayList.add(1,115);
        arrayList.add(1,116);
        arrayList.add(1,117);
        arrayList.add(1,118);
        arrayList.add(1,119);
        arrayList.print();
    }
}
