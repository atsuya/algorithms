import java.util.Vector;

public class MergeSort {
  public MergeSort() {
  }

  public Vector<Integer> sort(Vector<Integer> list) {
    if (list.size() <= 1) {
      return list;
    }

    int middle = list.size() / 2;
    Vector<Integer> left = new Vector<Integer>();
    Vector<Integer> right = new Vector<Integer>();
    for (int index = 0; index < list.size(); index++) {
      if (index < middle) {
        left.add(new Integer(list.get(index)));
      } else {
        right.add(new Integer(list.get(index)));
      }
    }

    left = this.sort(left);
    right = this.sort(right);

    return this.merge(left, right);
  }

  public Vector<Integer> merge(Vector<Integer> left, Vector<Integer> right) {
    Vector<Integer> result = new Vector<Integer>();

    while (left.size() > 0 || right.size() > 0) {
      if (left.size() > 0 && right.size() > 0) {
        if (left.firstElement().intValue() < right.firstElement().intValue()) {
          Integer leftFirst = left.remove(0);
          result.add(new Integer(leftFirst.intValue()));
        } else {
          Integer rightFirst = right.remove(0);
          result.add(new Integer(rightFirst.intValue()));
        }
      } else if (left.size() > 0 && right.size() <= 0) {
        Integer leftFirst = left.remove(0);
        result.add(new Integer(leftFirst.intValue()));
      } else if (left.size() <= 0 && right.size() > 0) {
        Integer rightFirst = right.remove(0);
        result.add(new Integer(rightFirst.intValue()));
      }
    }

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

    MergeSort mergeSort = new MergeSort();
    mergeSort.print(list);
    Vector<Integer> result = mergeSort.sort(list);
    mergeSort.print(result);
  }
}
