import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 堆排序 {

    public static void main(String[] args) {
        int[] heap = new int[]{16,4,10,14,7,9,3,2,8,1};
        heapSort(heap);
        printHeap(heap);

    }

    public static void heapSort(int[] arr){
        int heapSize = arr.length;
        builMaxdHeap(arr);
        while(heapSize > 0){
            swap(arr,0,heapSize - 1);
            heapSize --;
            maxHeapify(arr,0,heapSize);
        }
    }
    public static void swap(int[] arr, int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 建堆函数
     * 将传入的数组重排成最大堆的形式
     * 2 -> 0
     * 3 -> 0
     * 4 -> 1
     * 5 -> 1
     * 6 -> 2
     * 7 -> 2
     * 8 -> 3
     * 9 -> 3
     * 10 -> 4
     * 11 -> 4
     */
    public static void builMaxdHeap(int[] heap){
        if(heap.length <= 1){
            return;
        }
        for(int i = heap.length / 2 -1 ; i>= 0 ; i--){
            maxHeapify(heap,i,heap.length);
        }
    }

    /**
     * 堆化函数
     * heap为堆，heap[i]为堆上一个节点
     * 我们假设heap[i]的左子树和右子树均为最大堆，
     * 通过让heap[i]下沉， 实现heap[i]为根节点的树满足最大堆的性质
     */
    public static void maxHeapify(int[] heap, int i, int heapSize){

        int leftI = i * 2 + 1;
        int rightI = i * 2;

        int largestI = leftI < heapSize && heap[i] < heap[leftI]? leftI : i;
        largestI = rightI < heapSize && heap[largestI] < heap[rightI] ? rightI : largestI;
        if(largestI == i){
            return;
        }
        int tmp = heap[i]; heap[i] = heap[largestI] ; heap[largestI] = tmp;
        maxHeapify(heap,largestI,heapSize);
    }

    public static void printHeap(int[] heap){
        Set<Integer> magicSet = new HashSet<>(Arrays.asList(0, 2, 2+4,2+4+8,2+4+8+16));
        for (int i = 0 ; i < heap.length ; i ++){
            System.out.print(heap[i] + " ");
            if(magicSet.contains(i)){
                System.out.println();
            }
        }
    }

}
