public class MyHeap {

  private static void pushDown(int[] data, int size, int index) {
    int left = 2*index+1;
    int right = 2*index+2;
    int max;
    if (right == size) {
      if (data[index] < data[left]) {
        swap(data, index, left);
        index = left;
      }
    }
    else if (right < size) {
      if (data[right] > data[left])
        max = right;
      else max = left;
      if (data[index] < data[max]) {
        swap(data, index, max);
        index = max;
      } 
    }
  }

  private static void pushUp(int[] data, int index) {

  }

  public static void heapify(int[] data) {

  }

  public static void heapsort(int[] data) {

  }

  public static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

}
