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

  public static void main(String[] args) {
    int[] data = {9, 4, 7, 5, 8, 1, 2, 3, 6, 0};
    heapify(data);
    HeapPrinter.print(data);
  }

}
