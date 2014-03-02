import java.util.Vector;

public class BubbleSort {
  public BubbleSort() {
  }

  public void sort(Vector<Integer> list) {
    boolean swapped;

    do {
      swapped = false;

      for (int index = 0; index < list.size(); index++) {
        if (index + 1 < list.size()) {
          if (list.get(index) > list.get(index + 1)) {
            Integer temp = list.get(index);
            list.set(index, list.get(index + 1));
            list.set(index + 1, temp);

            swapped = true;
          }
        }
      }
    } while (swapped);
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

    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.print(list);
    bubbleSort.sort(list);
    bubbleSort.print(list);
  }
}
