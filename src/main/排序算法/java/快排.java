import java.util.Arrays;

public class 快排 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,7,1,3,5,6,4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end - 1){
            return;
        }
        int p = partition(arr,start,end);
        quickSort(arr,start,p);
        quickSort(arr,p + 1 , end);
    }

    public static int partition(int[] arr, int start, int end){
        if(end - start <= 1){
            return start;
        }
        int x = arr[end - 1];//主元
        int i = start - 1;//数组中下标小于等于i的数均小于等于x
        for(int j = start; j < end - 1; j ++){
            //数组中， 下标大于i而小于j的数均等于x
            if(arr[j] < x){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr, i,end - 1);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
