/**
 * 对于一个飞空整型数组arr，存在两个数a,b（0 <= a <= b < arr.length), 令s = arr[a] + arr[a+1] + ... + arr[b-1] + arr[b] ， 求s的最大值
 * 输入： int[] arr
 * 输出： int s
 */
public class 最大子数组问题_分治策略 {

    public static void main(String[] args) {
        int[] arr = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println(new 最大子数组问题_分治策略().maxSubArray(arr));
    }

    public int maxSubArray(int[] arr){
        int[] arr2 = new int[arr.length];
        arr2[0] = arr[0];
        for(int i = 1; i < arr.length; i ++){
            arr2[i] = arr2[i-1] + arr[i];
        }
        return maxSubArray(arr2,0,arr2.length);
    }

    private int maxSubArray(int[] arr, int start, int end) {
        if(start == end - 1){
            return arr[start] - arr[end-1];
        }
        int left = maxSubArray(arr,start,(end + start) / 2);
        int right = maxSubArray(arr,(end + start) / 2 , end);
        int cross = crossMaxSubArray(arr,start,end);
        return Math.max(Math.max(left,right),cross);
    }

    private int crossMaxSubArray(int[] arr, int start, int end) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = start; i <= (start + end) / 2; i++){
            int val = arr[i];
            if(val < min){
                min = val;
            }
        }
        for(int i = (start + end) /2 ;i < end; i ++){
            int val = arr[i];
            if(val > max){
                max = val;
            }
        }
        return max - min;
    }


}
