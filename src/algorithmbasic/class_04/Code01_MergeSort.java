package algorithmbasic.class_04;

public class Code01_MergeSort {

    //递归实现归并排序
    public static void megerSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int l = 0;
        int r = arr.length - 1;
        process(arr, l, r);
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        //创建辅助数组
        int[] help = new int[r - l + 1];
        int i = 0;//辅助数组索引
        int p1 = l;//左边第一个值
        int p2 = mid + 1;//右边第一个值
        //每一个值进行比较，知道达到左边或右边的最大长度
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //如果左边没有走到终点，代表着后续的数字都比右边的大，需要赋值到辅助索引中
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        //右侧同理
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; ) {
            arr[l + i] = arr[i++];
        }
    }


    //非递归实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int step = 1;//设置步长；
        int n = arr.length;
        while (step < n) {
            int l = 0;//左边第一个索引
            while (l < n) {
                if (step >= n - l) break;//如果生的数不足step，可直接返回
                int m = l + step - 1;//左侧最右侧位置的值
                int r = m + Math.min(step, n - m + 1);//右侧边界值
                merge(arr, l, m, r);
                l = r+1;
            }
            //防止溢出
            if (n / 2 < step) {
                break;
            }
            step <<= 1;
        }

    }

}
