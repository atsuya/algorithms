import java.util.LinkedList;
import java.util.HashSet;

public class BreadthFirst {
  public BreadthFirst() {
  }

  public void traverse(Node root) {
    LinkedList<Node> queue = new LinkedList<Node>();
    HashSet<Node> visited = new HashSet<Node>();

    queue.push(root);
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (!visited.contains(node)) {
        visited.add(node);
        System.out.println(node.getData().toString());

        Node left = node.getLeft();
        Node right = node.getRight();
        if (left != null) {
          queue.add(left);
        }
        if (right != null) {
          queue.add(right);
        }
      }
    }
  }

  public void print(LinkedList<Node> node) {
    for (Node element : node) {
      System.out.printf("%s ", element.getData().toString());
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node root = new Node("F");

    Node b = new Node("B");
    Node g = new Node("G");
    root.setLeft(b);
    root.setRight(g);

    Node a = new Node("A");
    Node d = new Node("D");
    b.setLeft(a);
    b.setRight(d);

    Node i = new Node("I");
    g.setRight(i);

    Node c = new Node("C");
    Node e = new Node("E");
    d.setLeft(c);
    d.setRight(e);

    Node h = new Node("H");
    i.setLeft(h);

    BreadthFirst breadthFirst = new BreadthFirst();
    breadthFirst.traverse(root);
  }
}
