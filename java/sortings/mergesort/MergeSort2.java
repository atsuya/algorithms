import java.util.LinkedList;

public class MergeSort2 {
  public MergeSort2() {
  }

  public LinkedList<Integer> sort(LinkedList<Integer> list) {
    if (list.size() <= 1) {
      return list;
    }

    int middle = list.size() / 2;
    LinkedList<Integer> left = new LinkedList<Integer>();
    LinkedList<Integer> right = new LinkedList<Integer>();
    for (int index = 0; index < list.size(); index++) {
      if (index < middle) {
        left.add(list.get(index));
      } else {
        right.add(list.get(index));
      }
    }

    left = this.sort(left);
    right = this.sort(right);

    return this.merge(left, right);
  }

  private LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
    LinkedList<Integer> result = new LinkedList<Integer>();

    while (left.size() > 0 || right.size() > 0) {
      if (left.size() > 0 && right.size() > 0) {
        Integer leftValue = left.get(0);
        Integer rightValue = right.get(0);
        if (leftValue.intValue() < rightValue.intValue()) {
          result.add(left.remove(0));
        } else {
          result.add(right.remove(0));
        }
      } else if (left.size() > 0) {
        result.add(left.remove(0));
      } else {
        result.add(right.remove(0));
      }
    }

    return result;
  }

  public void print(LinkedList<Integer> list) {
    for (Integer value : list) {
      System.out.printf("%d ", value.intValue());
    }
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(new Integer(8));
    list.add(new Integer(22));
    list.add(new Integer(2));
    list.add(new Integer(40));
    list.add(new Integer(9));
    list.add(new Integer(11));
    list.add(new Integer(2));
    list.add(new Integer(15));
    list.add(new Integer(4));

    MergeSort2 mergeSort2 = new MergeSort2();
    mergeSort2.print(list);
    LinkedList<Integer> result = mergeSort2.sort(list);
    mergeSort2.print(result);
  }
}
