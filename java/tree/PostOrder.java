public class PostOrder {
  public PostOrder() {
  }

  public void traverse(Node node) {
    if (node == null) {
      return;
    }

    this.traverse(node.getLeft());
    this.traverse(node.getRight());
    this.visit(node);
  }

  public void visit(Node node) {
    System.out.println(node.getData().toString());
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

    PostOrder postOrder = new PostOrder();
    postOrder.traverse(root);
  }
}
