import java.util.Arrays;

public class MySortDemo {
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
     public static void insertSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int key=arr[i+1];
            int end=i;
            while(end>=0&&arr[end]>key){
                arr[end+1]=arr[end];
                end--;
            }
            arr[end+1]=key;
        }
     }
     public static void shellSort(int arr[]){
        int gap=arr.length;
        while(gap>1){
            gap=gap/3+1;
        }
        for(int i=0;i<arr.length-gap;i++){
            int end=i;
            int key=arr[end+gap];
            while(end>=0&&arr[end]>key){
                arr[end+gap]=arr[end];
                  end-=gap;
            }
            arr[end+gap]=key;
        }
     }
     public static void selectSort(int arr[]){
         for(int i=0;i<arr.length-1;i++){
             int end=i;
             int min=i;
             for(int j=end+1;j<arr.length;j++){
                 if(arr[j]<arr[min]){
                     min=j;
                 }
             }
             swap(arr,min,end);
         }
     }
     public static void selectSort2(int arr[]){
        int begin=0;
        int end=arr.length-1;
        while(begin<end){
            int min=begin;
            int max=begin;
            for(int i=begin;i<end;i++){
            if (arr[i]<min)
                min=i;
            if(arr[i]>max)
                max=i;
        }
            swap(arr,begin,min);
            if(begin==max)
                max=min;
            swap(arr,end,max);
            begin++;
            end--;
        }
     }
    public static void test1()
    {
        int[]  arr = {120,9,3,2,10,35,89,0,7,12};
        int[]  copy = arr.clone();
        int[]  copy2 = arr.clone();
        int[]  copy3 = arr.clone();

        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
        shellSort(copy2);
        System.out.println(Arrays.toString(copy2));
        selectSort(copy3);
        System.out.println(Arrays.toString(copy3));

    }
    public static void main(String[] args) {
         test1();

    }

}
