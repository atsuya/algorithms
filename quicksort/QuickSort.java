import java.util.Vector;

public class QuickSort {
  public QuickSort() {
  }

  public Vector<Integer> sort(Vector<Integer> list) {
    if (list.size() <= 1) {
      return list;
    }

    Integer pivot = list.remove(list.size() - 1);
    Vector<Integer> less = new Vector<Integer>();
    Vector<Integer> greater = new Vector<Integer>();
    for (Integer value : list) {
      if (value.intValue() <= pivot.intValue()) {
        less.add(value);
      } else {
        greater.add(value);
      }
    }

    Vector<Integer> result = new Vector<Integer>();
    result.addAll(this.sort(less));
    result.add(pivot);
    result.addAll(this.sort(greater));

    return result;
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

    QuickSort quickSort = new QuickSort();
    quickSort.print(list);
    Vector<Integer> result = quickSort.sort(list);
    quickSort.print(result);
  }
}
