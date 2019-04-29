import java.util.*;
public class MyHeap {

  private static void pushDown(int[] data, int size, int index) {
    int left = 2*index+1;
    int right = 2*index+2;
    int max;
    if (right < size) {
      if (data[right] > data[left])
        max = right;
      else max = left;
    }
    else max = left;
    while(max < size && data[max] > data[index]) {
      swap(data, index, max);
      index = max;
      left = 2*index+1;
      right = 2*index+2;
      if (right < size) {
        if (data[right] > data[left])
          max = right;
        else max = left;
      }
      else max = left;
    }
  }

  private static void pushUp(int[] data, int index) {
    int parent = (index-1)/2;
    if (index > 0) {
      while (data[index] > data[parent]) {
        swap(data, index, parent);
        index = parent;
        parent = (index-1)/2;
      }
    }
  }

  public static void heapify(int[] data) {
    for (int i = data.length-1; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }

  public static void heapsort(int[] data) {
    heapify(data);
    int size = data.length;
    for (int i = size-1; i >= 0; i--) {
      swap(data, 0, i);
      size--;
      pushDown(data, size, 0);
    }
  }

  public static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  /*
  public static void main(String[] args) {
    int[] data = {9, 4, 7, 5, 8, 1, 2, 3, 6, 0};
    heapify(data);
    HeapPrinter.print(data);
    heapsort(data);
    HeapPrinter.print(data);
    System.out.println(Arrays.toString(data));
    int[] data2 = {100, 4, 60, 238, 88, 13543, 45, 2322, 0};
    heapsort(data2);
    HeapPrinter.print(data2);
    System.out.println(Arrays.toString(data2));
  }
  */

  public static void main(String[]args){
   System.out.println("Size\t\tMax Value\tmerge/builtin ratio ");
   int[]MAX_LIST = {1000000000,500,10};
   for(int MAX : MAX_LIST){
     for(int size = 31250; size < 2000001; size*=2){
       long qtime=0;
       long btime=0;
       //average of 5 sorts.
       for(int trial = 0 ; trial <=5; trial++){
         int []data1 = new int[size];
         int []data2 = new int[size];
         for(int i = 0; i < data1.length; i++){
           data1[i] = (int)(Math.random()*MAX);
           data2[i] = data1[i];
         }
         long t1,t2;
         t1 = System.currentTimeMillis();
         MyHeap.heapsort(data2);
         t2 = System.currentTimeMillis();
         qtime += t2 - t1;
         t1 = System.currentTimeMillis();
         Arrays.sort(data1);
         t2 = System.currentTimeMillis();
         btime+= t2 - t1;
         if(!Arrays.equals(data1,data2)){
           System.out.println("FAIL TO SORT!");
           System.exit(0);
         }
       }
       System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
     }
     System.out.println();
   }
   System.out.println();
   int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
   HeapPrinter.print(arr);
   System.out.println();
}

}
