import java.util.ArrayList;
import java.util.List;

/**
 * charles
 * java learn
 * 2019-04-24
 */
public class BinaryHeap<T extends Comparable<T>> {
    private List<T> mHeap;

    public BinaryHeap() {
        this.mHeap = new ArrayList<T>();
    }

    /**
     * 最大堆向下调整算法
     *
     * @param start
     * @param end
     */
    public void filterdown(int start, int end) {
        int left = 2 * start + 1;//左子树的位置
        T temp = mHeap.get(start);//初始位置的key值
        while (left <= end) {
            int tempSec = mHeap.get(left).compareTo(mHeap.get(left + 1));
            if (left < end && tempSec < 0)//左子树数值小于右子树
                left++;//右子树
            tempSec = temp.compareTo(mHeap.get(left));//起始位置比较 左/右子树
            if (tempSec >= 0) //初始位置值 大于 左右子树 无需调整 break;
                break;
            else { //初始位置值小于左/右子树 set初始值为左/右子树
                mHeap.set(start, mHeap.get(left));
                start = left;
                left = 2 * left + 1;
            }
        }
        mHeap.set(start, temp);
    }

    /**
     * 删除最大堆中的data
     *
     * @param data
     * @return
     */
    public int delete(T data) {
        if (mHeap.isEmpty() == true)
            return -1;
        int index = mHeap.indexOf(data);//获取位置
        if (index == -1)
            return -1;//不存在该值
        int size = mHeap.size();
        mHeap.set(index, mHeap.get(size - 1));//用最末尾的子树代替删除节点值
        mHeap.remove(size - 1);//删除末尾的节点
        if (mHeap.size() > 1)
            filterdown(index, mHeap.size());
        return 0;
    }

    /**
     * 向上调整算法
     *
     * @param end 插入的位置
     */
    public void filterup(int end) {
        //left(左子树) = 2 * start(父节点) +1  start=(left-1)/2
        int parent = (end - 1) / 2;
        T temp = mHeap.get(end);//当前节点的值
        while (end > 0) {
            int tempSec = mHeap.get(parent).compareTo(temp);
            if (tempSec >= 0) //parent > 插入点 无需调整
                break;
            else {
                mHeap.set(end, mHeap.get(parent));
                end = parent;
                parent = (parent - 1) / 2;//开始比较上一层的父节点
            }
        }
        mHeap.set(end, temp);
    }

    /**
     * 插入data
     *
     * @param data
     */
    public void insert(T data) {
        int size = mHeap.size();
        mHeap.add(data);
        filterup(size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mHeap.size(); i++)
            sb.append(mHeap.get(i) + " ");
        return sb.toString();
    }

    public static void main(String[] args) {
        int arr[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        System.out.println("开始添加");
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        System.out.printf("\n== 最 大 堆: %s", heap);
        int insertData = 85;
        heap.insert(insertData);
        System.out.printf("\n== 最 大 堆: %s", heap);
        heap.delete(arr[3]);
        System.out.printf("\n== 最 大 堆: %s", heap);
    }

}
