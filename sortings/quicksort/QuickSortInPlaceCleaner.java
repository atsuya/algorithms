import java.util.Vector;

public class QuickSortInPlaceCleaner {
  public QuickSortInPlaceCleaner() {
  }

  public void sort(Vector<Integer> list) {
    this.sort(list, 0, (list.size() - 1));
  }
  
  private void sort(Vector<Integer> list, int left, int right) {
    if (left < right) {
      int pivotIndex = left + ((right - left) / 2);
      int nextPivotIndex = this.partition(list, left, right, pivotIndex);
      this.sort(list, left, (nextPivotIndex - 1));
      this.sort(list, (nextPivotIndex + 1), right);
    }
  }

  private int partition(Vector<Integer> list, int left, int right, int pivotIndex) {
    System.out.printf("left: %d, right: %d, pivot: %d\n", left, right, pivotIndex);

    int pivot = list.get(pivotIndex).intValue();

    list.set(pivotIndex, list.get(right));
    list.set(right, new Integer(pivot));

    int storeIndex = left;
    for (int index = left; index < right; index++) {
      if (list.get(index) < pivot) {
        Integer temp = list.get(index);
        list.set(index, list.get(storeIndex));
        list.set(storeIndex, temp);

        storeIndex += 1;
      }
    }

    Integer temp = list.get(right);
    list.set(right, list.get(storeIndex));
    list.set(storeIndex, temp);

    return storeIndex;
  }

  public void print(Vector<Integer> list) {
    for (Integer value : list) {
      System.out.printf("%d ", value.intValue());
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Vector<Integer> list = new Vector<Integer>();
    list.add(new Integer(8));
    list.add(new Integer(22));
    list.add(new Integer(2));
    list.add(new Integer(40));
    list.add(new Integer(9));
    list.add(new Integer(11));
    list.add(new Integer(2));
    list.add(new Integer(15));
    list.add(new Integer(4));

    QuickSortInPlaceCleaner quickSortInPlaceCleaner = new QuickSortInPlaceCleaner();
    quickSortInPlaceCleaner.print(list);
    quickSortInPlaceCleaner.sort(list);
    quickSortInPlaceCleaner.print(list);
  }
}
