public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
  private E data;
  private Node<E> left;
  private Node<E> right;

  public Node(E data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public E getData() {
    return this.data;
  }

  public int compareTo(Node<E> other) {
    return this.data.compareTo(other.data);
  }

  public Node<E> getLeft() {
    return this.left;
  }

  public void setLeft(Node<E> left) {
    this.left = left;
  }

  public Node<E> getRight() {
    return this.right;
  }

  public void setRight(Node<E> right) {
    this.right = right;
  }
}
