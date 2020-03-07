import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class MySort {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //升序排序
    /*
       插入排序：
       时间复杂度： 最坏情况： O(n^2) ---> 逆序序列    最好情况：O(n)  ---> 顺序序列
       稳定性：稳定
       空间复杂度：  常数空间  ---> O(1)
     */
    public static void insertSort(int[] arr){
        //开始可以认为第0个位置是排好序
        for(int i = 0; i < arr.length - 1; ++i){
            int key = arr[i + 1];
            //i: 表示已排序数据的最后一个位置
            int end = i;
            while(end >= 0 && arr[end] > key){
                //把大的元素向后移动
                arr[end + 1] = arr[end];
                //继续向前搜索
                --end;
            }
            // end : -1  或者  <= key的一个位置
            arr[end + 1] = key;
        }
    }

    public static void insertSort2(int[] arr){
        //开始可以认为第0个位置是排好序
        for(int i = 1; i < arr.length; ++i){
            //i: 下一个待排序元素的位置
            int key = arr[i];
            // end: 表示已排序数据的最后一个位置
            int end = i - 1;
            while(end >= 0 && arr[end] > key){
                arr[end + 1] = arr[end];
                --end;
            }
            arr[end + 1] = key;
        }
    }
    /*
          希尔排序：改进的插入排序，数据越有序，优化的空间就越小
          时间复杂度： O(n) ~ O(n^2)  -----> O(n^1.3)
          稳定性：不稳定
          空间复杂度：  常数空间  ---> O(1)
    */
    public static void shellSort(int[] arr){
        //对数据进行分组
        //每组数据进行插入排序: 逻辑分组
        // 同一组数据， 他们之间的间隔不一定为1
        int gap = arr.length;
        while(gap > 1){
            gap = gap / 3 + 1;
            //i: 表示已排序数据的最后一个位置
            for(int i = 0; i < arr.length - gap; ++i){
                int end = i;
                int key = arr[end + gap];

                while(end >= 0 &&arr[end] > key){
                    arr[end + gap] = arr[end];
                    end -= gap;
                }
                arr[end + gap] = key;
            }
        }
    }
    /*
              选择排序：
              时间复杂度： O(n^2)
              稳定性：可以让它稳定/不稳定
              空间复杂度：  常数空间  ---> O(1)
    */
    public static void selectSort(int[] arr){
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end){

            int minIdx = begin;
            int maxIdx = begin;
            for(int i = begin; i <= end; ++i){
                //最小值选前面
                if(arr[i] < arr[minIdx])
                    minIdx = i;
                //最大值选后面
                if(arr[i] >= arr[maxIdx])
                    maxIdx = i;
            }
            swap(arr, begin, minIdx);
            //如果最大值在起始位置，则经过上面的交换之后，最大值被移动到minIdx指向的位置
            if(maxIdx == begin)
                maxIdx = minIdx;

            swap(arr, end, maxIdx);
            ++begin;
            --end;
        }
    }

    public static void selectSort2(int[] arr){
        //i: 未排序的最大位置
        for(int i = arr.length - 1; i > 0; --i)
        {
            int end = i;
            int maxIdx = i;
            //从所有未排序的数据中找最大值的索引
            for(int j = end - 1; j >=0; --j){
                if(arr[j] >arr[maxIdx])
                    maxIdx = j;
            }
            swap(arr, maxIdx, end);
        }
    }

    public static void shiftDownBig(int[] arr, int parent, int sz){
        int child = 2 * parent + 1;
        while(child < sz){
            //两个孩子节点中选择一个最小的
            if(child + 1 < sz && arr[child + 1] > arr[child])
                ++child;
            //比较父节点和孩子节点
            if(arr[child] > arr[parent]){
                swap(arr, child, parent);
                parent = child;
                child = 2 * parent + 1;
            }
            else
                break;
        }
    }

    /*
             堆排序：
             时间复杂度： 建堆： O(n)   log(n) +log(n - 1) + log(n - 2) + ... + 1   ---> n * log(n)
             稳定性： 不稳定  ---> 向下调整可能会破坏相对位置
             空间复杂度：  常数空间  ---> O(1)
   */
    public static void heapSort(int[] arr){
        int len = arr.length;
        //建堆， 最后一个非叶子节点开始向下调整
        for(int i = (len - 2) / 2; i >= 0; --i){
            shiftDownBig(arr, i, len);
        }
        //交换 《---》向下调整
        // 未排序的元素个数
        int end = len - 1;
        while(end > 0){
            swap(arr, 0, end);
            shiftDownBig(arr, 0, end);
            --end;
        }
    }

    /*
             冒泡排序：
             时间复杂度：O(n) ~ O(n^2)  最好：顺序 + 标记  最坏： 逆序
             稳定性： 稳定
             空间复杂度：  常数空间  ---> O(1)
   */
    public static void bubbleSort(int[] arr){
        // len: 未排序的元素个数
        int len = arr.length;
        while(len > 0){
            //flag: true ---->已经有序
            boolean flag = true;
            //一轮冒泡排序， 排好一个元素的位置
            for(int i = 0; i < len - 1; ++i){
                if(arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                    flag = false;
                }
            }
            if(flag)
                break;
            --len;
        }
    }

    //三数取中法： 为了让数据分组更加均衡
    public static int getMid(int[] arr, int left, int right){
        // 从 arr[left], arr[mid], arr[right],中选一个中间值
        int mid = (left + right) / 2;
        if(arr[mid] > arr[left]){
            if(arr[mid] < arr[right])
                return mid;
            else{
                // mid  > left, >= right
                if(arr[left] > arr[right])
                    return left;
                else
                    return right;
            }
        }
        else{
            // mid <= left
            if(arr[mid] > arr[right])
                return mid;
            else{
                // mid <= left, <= right
                if(arr[left] < arr[right])
                    return left;
                else
                    return right;
            }
        }
    }
    public static int partion1(int[] arr, int left, int right){
        //基准值
        int key = arr[left];
        int start = left;
        while(left < right){
            //一定要先从后向前找第一个小于key的数据位置， 否则数据的位置会产生错误
            while(left < right && arr[right] >= key)
                --right;
            //从前向后找第一个大于key的数据位置
            while(left < right &&arr[left] <= key)
                ++left;
            //交换
            swap(arr, left, right);
        }
        //把基准值和相遇的位置的数据进行交换
        //错误： arr[left] = key; 相遇位置的数据被覆盖
        swap(arr, left, start);
        return left;
    }

    public static int partion2(int[] arr, int left, int right){
        //获取基准值
        int key = arr[left];
        //挖坑填坑
        while(left < right){
            //从右边找第一个小于key的数据，填左边的坑
            while(left < right && arr[right] >= key)
                --right;
            //填坑
            arr[left] = arr[right];
            //从左边找第一个大于key的数据，填右边的坑
            while(left < right && arr[left] <= key)
                ++left;
            //填坑
            arr[right] = arr[left];
        }

        //填基准值到中间相遇的位置
        arr[left] = key;
        return left;
    }

    public static int partion3(int[] arr, int left, int right){
        //三数取中
        int mid = getMid(arr, left, right);
        swap(arr, left, mid);

        int key = arr[left];
        int prev = left; //最后一个小于key的位置
        int cur = left + 1; //下一个小于key的位置
        while(cur <= right){
            //如果cur找到下一个小于key的位置，并且prev 和 cur之间有大于key的值，则交换prev, cur的值
            if(arr[cur] < key && ++prev != cur)
                swap(arr, prev, cur);
            ++cur;
        }
        swap(arr, left, prev);
        return prev;
    }

    /*
        快排递归：
        时间复杂度：O(nlogn)    最坏时间复杂度： 没有优化之前 O(n^2)
        稳定性：不稳定  基准值的位置进行交换的时候有可能改变相同元素的相对位置
        空间复杂度：logn
     */
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            //int mid = partion1(arr, left, right);
            //int mid = partion2(arr, left, right);
            int mid = partion3(arr, left, right);

            //进行分组
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }
    /*
    非递归： 模拟递归过程
    1. 选基准值
    2. 根据基准值分组
    3. 给划分的小组数据进行重复1,2的过程
    */
    public static void quickSortNoR(int[] arr)
    {
        int left = 0;
        int right = arr.length - 1;
        //栈用来记录区间
        Stack<Integer> st = new Stack<>();
        if(left < right){
            st.push(left);
            st.push(right);
        }
        while(!st.isEmpty()){
            //取出栈顶的一对区间值
            int right1 = st.pop();
            int left1 = st.pop();
            //分组
            int mid = partion3(arr, left1, right1);
            // 新的分组继续压栈
            if(mid - 1 > left1){
                st.push(left1);
                st.push(mid - 1);
            }
            if(mid + 1 < right1){
                st.push(mid + 1);
                st.push(right1);
            }
        }
    }

    public static void mergeInternal(int[] arr, int left, int mid, int right, int[] tmp){
        int begin1 = left, end1 = mid;
        int begin2 = mid + 1, end2 = right;
        int idx = left;
        while(begin1 <= end1 && begin2 <= end2){
            // < : 不稳定
            // <=: 稳定
            if(arr[begin1] <= arr[begin2]){
                //能否原地合并
                tmp[idx++] = arr[begin1++];
            }
            else{
                tmp[idx++] = arr[begin2++];
            }
        }
        //判断是否还有剩余元素
        while(begin1 <= end1)
            tmp[idx++] = arr[begin1++];
        while(begin2 <= end2)
            tmp[idx++] = arr[begin2++];
        //拷贝
        for(int i = left; i <= right; ++i)
            arr[i] = tmp[i];
    }

        /*
            归并递归：
            时间复杂度：O(nlogn)
            稳定性：稳定
            空间复杂度：O(n)  需要辅助空间对元素进行归并，不能原地归并
         */
    public static void mergeSort(int[] arr, int left, int right, int[] tmp){
        if(left >= right)
            return;
        // 分组 /分解
        int mid = (left + right) / 2;
        // 首先给 [left, mid]   和  [mid + 1, right]小组数据进行排序
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid +1, right, tmp);
        //归并： 前提条件----> 小组数据已经有序
        mergeInternal(arr, left, mid, right, tmp);
    }

    public static void merge(int[] arr){
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
    }

    public static void mergeNoR(int[] arr){
        int[] tmp = new int[arr.length];
        //i: 每次归并的元素个数
        for(int i = 1; i < arr.length; i *= 2){
            // j: 下一次归并的起始位置
            for(int j = 0; j < arr.length; j += 2 * i) {
                //mergeInternal(arr, j, j + i - 1, j + 2 * i - 1, tmp);  区间可能越界
                int left = j;
                int mid = j + i - 1;
                //右半部分没有数据，不用进行归并
                if(mid >= arr.length - 1)
                    continue;
                int right = j + 2 * i - 1;
                //判断右边的区间是否越界
                if(right >= arr.length){
                    right = arr.length - 1;
                }
                mergeInternal(arr, left, mid, right, tmp);
            }
        }
    }


    public static void test1()
    {
        Random rdm = new Random(2020229111);
        int number = 25;
        int[] arr = new int[number];
        for(int i = 0; i <number; ++i){
            arr[i] = rdm.nextInt(10000) % 150;
        }
        int[]  copy = arr.clone();
        int[]  copy2 = arr.clone();
        int[]  copy3 = arr.clone();
        int[]  copy4 = arr.clone();
        int[]  copy5 = arr.clone();
        int[]  copy6 = arr.clone();
        int[]  copy7 = arr.clone();
        int[]  copy8 = arr.clone();
        int[]  copy9 = arr.clone();


        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("insertSort\t: " + Arrays.toString(arr));
        Arrays.sort(copy);
        System.out.println("Arrays.sort\t: " + Arrays.toString(copy));
        shellSort(copy2);
        System.out.println("shellSort\t: " + Arrays.toString(copy2));
        selectSort(copy3);
        System.out.println("selectSort\t: " + Arrays.toString(copy3));
        heapSort(copy4);
        System.out.println("heapSort\t: " + Arrays.toString(copy4));
        bubbleSort(copy5);
        System.out.println("bubbleSort\t: " + Arrays.toString(copy5));
        quickSort(copy6, 0, copy6.length - 1);
        System.out.println("quickSort\t: " + Arrays.toString(copy6));
        quickSortNoR(copy7);
        System.out.println("quickSortNoR\t: " + Arrays.toString(copy7));
        merge(copy8);
        System.out.println("mergeSort\t: " + Arrays.toString(copy8));
        mergeNoR(copy9);
        System.out.println("mergeSortNoR\t: " + Arrays.toString(copy9));


    }

    public static void test2(){
        Random rdm = new Random(2020229111);
        int number = 100000;
        int[] arr = new int[number];
        for(int i = 0; i <number; ++i){
            arr[i] = rdm.nextInt();
        }
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();
        int[] arr6 = arr.clone();
        int[] arr7 = arr.clone();
        int[] arr8 = arr.clone();


        long begin = System.nanoTime();
        insertSort(arr);
        long end = System.nanoTime();
        System.out.printf("insertSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        shellSort(arr2);
        end = System.nanoTime();
        System.out.printf("shellSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        selectSort(arr3);
        end = System.nanoTime();
        System.out.printf("selectSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        heapSort(arr4);
        end = System.nanoTime();
        System.out.printf("heapSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        bubbleSort(arr5);
        end = System.nanoTime();
        System.out.printf("bubbleSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        quickSort(arr6, 0, arr6.length - 1);
        end = System.nanoTime();
        System.out.printf("quickSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        quickSortNoR(arr7);
        end = System.nanoTime();
        System.out.printf("quickSortNoR time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        merge(arr8);
        end = System.nanoTime();
        System.out.printf("mergeSort time\t:  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);


        System.out.println("数据已经有序： ");
        begin = System.nanoTime();
        insertSort(arr);
        end = System.nanoTime();
        System.out.printf("insertSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        shellSort(arr2);
        end = System.nanoTime();
        System.out.printf("shellSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        selectSort(arr3);
        end = System.nanoTime();
        System.out.printf("selectSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        heapSort(arr4);
        end = System.nanoTime();
        System.out.printf("heapSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        bubbleSort(arr5);
        end = System.nanoTime();
        System.out.printf("bubbleSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        quickSort(arr6, 0, arr6.length - 1);
        end = System.nanoTime();
        System.out.printf("quickSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        quickSortNoR(arr7);
        end = System.nanoTime();
        System.out.printf("quickSortNoR time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);

        begin = System.nanoTime();
        merge(arr8);
        end = System.nanoTime();
        System.out.printf("mergeSort time :  %.4fms\n", (end - begin) * 1.0 / 1000 / 1000);
    }


    public static void main(String[] args) {
        test1();

        //test2();
    }
}
