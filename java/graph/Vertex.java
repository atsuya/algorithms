import java.util.LinkedList;

public class Vertex implements Comparable<Vertex> {
  private String name;
  private int distance;
  private LinkedList<Edge> edges;

  public Vertex(String name) {
    this.name = name;
    this.distance = Integer.MAX_VALUE;
    this.edges = new LinkedList<Edge>();
  }

  public Vertex(String name, int distance) {
    this.name = name;
    this.distance = distance;
  }

  public String getName() {
    return this.name;
  }

  public int compareTo(Vertex other) {
    return this.distance - other.distance;
  }

  public int getDistance() {
    return this.distance;
  }

  public Object setDistance(int value) {
    this.distance = value;
    return this;
  }

  public LinkedList<Edge> edges() {
    return this.edges;
  }
}
