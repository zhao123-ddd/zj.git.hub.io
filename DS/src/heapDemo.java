public class heapDemo {
    //大堆向下调整
    public static void shifDownBig(int arr[],int size,int parent) {
        int child = parent * 2 + 1;
     while (child<size){
        if (child + 1 < size && arr[child + 1] > arr[child]) {
            child++;
        }
        if (arr[child] > arr[parent]) {
            swap(arr, child, parent);
            parent = child;
            child = parent*2 + 1;
        }
        else {
            break;
        }
    }
    }
    //小堆向下调整
    public static void shifDownSmall(int arr[],int size,int parent) {
        int child = parent * 2 + 1;
        while (child<size){
            if (child + 1 < size && arr[child + 1] < arr[child]) {
                child++;
            }
            if (arr[child] < arr[parent]) {
                swap(arr, child, parent);
                parent = child;
                child = 2*parent + 1;
            }
            else {
                break;
            }
        }
    }
    //建大堆
    public static void creatHeapBig(int arr[]){
        for (int i=(arr.length)/2;i>=0;i--){
            shifDownBig(arr,arr.length,i);
        }
    }
    //建小堆
    public static void creatHeapSmall(int arr[]){
        for (int i=(arr.length)/2;i>=0;i--){
            shifDownSmall(arr,arr.length,i);
        }
    }
    //向上调整大堆
    public static void shifUpBig(int arr[],int size,int child){
        int parent=(child-1)/2;
        while(child>0){
            if(arr[child]>arr[parent]){
                swap(arr,child,parent);
                child=parent;
                parent=(child-1)/2;
            }
            else {
                break;
            }
        }
    }
    //向上调整小堆
    public static  void shifUpSmall(int arr[],int size,int child){
        int parent=(child-1)/2;
        while(child>0){
            if(arr[child]<arr[parent]){
                swap(arr,child,parent);
                child=parent;
                parent=(child-1)/2;
            }
            else {
                break;
            }
        }
    }
    public static  void swap(int[] arr, int child, int parent){
        int temp=arr[parent];
        arr[parent]=arr[child];
        arr[child]=temp;
    }
}
