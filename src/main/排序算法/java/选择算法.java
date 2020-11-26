import java.util.Arrays;

/**
 * 在一个长度大于i的数组中选择第i小的元素的算法称为选择算法
 */
public class 选择算法 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,7,1,3,5,6,4};
        for(int i = 0 ; i < 8 ; i ++){
            int select = select(arr, i);
            System.out.println("select["+i+"]="+select);
        }
    }

    public static int select(int[] arr, int i){
        return select(arr,i,0,arr.length);
    }

    private static int select(int[] arr, int i, int left, int right) {
        assert i >= 0 && left + i < right; assert left >= 0; assert right <= arr.length;
        if(left == right - 1){
            assert i == 0;
            return arr[left];
        }
        int p = partition(arr, left, right);
        int range = p - left;
        if(range == i){
            return arr[p];
        }else if(range < i){
            return select(arr,i - range - 1 , p + 1, right);
        }else {
            return select(arr,i,left,p);
        }


    }

    //基于快排partition函数的选择算法
    public static int partition(int[] arr, int start, int end){
        assert start >= 0; assert end <= arr.length;assert end >= start;
        if(end - start <= 1){
            return start;
        }
        int x= arr[end - 1];
        int i = start - 1;
        for(int j = start; j < end - 1 ; j++){
            if(arr[j] < x){
                i ++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,end-1);
        return i;
    }

    public static void swap(int[] arr, int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
