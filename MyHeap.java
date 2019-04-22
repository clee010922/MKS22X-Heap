public class MyHeap {

  private static void pushDown(int[] data, int size, int index) {
    int left = 2*index+1;
    int right = 2*index+2;
    int max;
    if (right == size)
      max = left;
    else {
      if (data[right] > data[left])
        max = right;
      else max = left;
    }
    while(max < size && data[max] > data[index]) {
      swap(data, index, max);
      index = max;
      left = 2*index+1;
      right = 2*index+2;
      if (right == size)
        max = left;
      else {
        if (data[right] > data[left])
          max = right;
        else max = left;
      }
    }
  }

  private static void pushUp(int[] data, int index) {

  }

  public static void heapify(int[] data) {
    for (int i = data.length-1; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }

  public static void heapsort(int[] data) {

  }

  public static void swap(int[] data, int a, int b) {
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

}
