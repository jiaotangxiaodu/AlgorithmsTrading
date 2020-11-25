/**
 * 对于一个飞空整型数组arr，存在两个数a,b（0 <= a <= b < arr.length), 令s = arr[a] + arr[a+1] + ... + arr[b-1] + arr[b] ， 求s的最大值
 * 输入： int[] arr
 * 输出： int s
 */
public class 最大子数组问题_递归算法 {
    public static void main(String[] args) {
        int[] arr = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println(new 最大子数组问题_递归算法().maxSubArray(arr));
    }

    private int maxSubArray(int[] arr) {
        if(arr.length == 0){
            return 0;
        }

        int end = 2;
        int result = 0;
        int curVal = arr[0];
        int minVal = arr[0];
        // 递归已改成循环形式
        while(end <= arr.length){
            // 找出型如[start,end)的最大子数组
            curVal += arr[end-1];
            if(arr[end-1] < 0){
                if(curVal < minVal){
                    minVal = curVal;
                }
            }else if(arr[end-1]==0){
                //do nothing
            }else {
                int curResult = curVal - minVal;
                if(curResult > result){
                    result = curResult;
                }
            }
            end++;
        }
        return result;
    }
}
