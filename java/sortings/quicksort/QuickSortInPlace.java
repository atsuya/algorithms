import java.util.Vector;
import java.util.Collections;

public class QuickSortInPlace {
  public QuickSortInPlace() {
  }

  public void sort(Vector<Integer> list) {
    this.sort(list, 0, (list.size() - 1));
  }

  private void sort(Vector<Integer> list, int left, int right) {
    if (left < right) {
      // sort the section to get median value
      Vector<Integer> sorted = new Vector<Integer>();
      for (int index = left; index < right; index++) {
        sorted.add(list.get(index));
      }
      Collections.sort(sorted);
      this.print(sorted);

      int pivotIndex = sorted.size() / 2;
      int pivot = sorted.get(pivotIndex).intValue();

      // loop through to swap
      int currentLeft = left;
      int currentRight = right;
      int lastLeft = left;
      int lastRight = right;
      while (true) {
        while (currentLeft < list.size()) {
          if (list.get(currentLeft).intValue() >= pivot) {
            lastLeft = currentLeft;
            break;
          }
          currentLeft += 1;
        }

        while (currentRight >= 0) {
          if (list.get(currentRight).intValue() < pivot) {
            lastRight = currentRight;
            break;
          }
          currentRight -= 1;
        }

        if (currentLeft < currentRight) {
          Integer temp = list.get(currentLeft);
          list.set(currentLeft, list.get(currentRight));
          list.set(currentRight, temp);

          this.print(list);
        } else {
          break;
        }
      }

      // recursively sort the list
      this.sort(list, left, (lastLeft - 1));
      this.sort(list, (lastLeft + 1), right);
    }
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

    QuickSortInPlace quickSortInPlace = new QuickSortInPlace();
    quickSortInPlace.print(list);
    quickSortInPlace.sort(list);
    quickSortInPlace.print(list);
  }
}
