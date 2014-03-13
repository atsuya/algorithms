import java.util.Vector;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Dijkstra {
  private PriorityQueue<Vertex> notVisited;

  public Dijkstra() {
    Comparator<Comparable> least = new Comparator<Comparable>() {
      public int compare(Comparable object1, Comparable object2) {
        return object1.compareTo(object2);
      }
    };
    this.notVisited = new PriorityQueue<Vertex>(100, least);
  }

  public void find(
      Vector<Vertex> vertices,
      Hashtable<String, Edge> previouses) {
    Vertex source = vertices.get(0);

    for (Vertex vertex : vertices) {
      if (vertex.getName() == source.getName()) {
        vertex.setDistance(0);
      } else {
        vertex.setDistance(Integer.MAX_VALUE);
      }
      this.notVisited.add(vertex);
    }

    while (this.notVisited.size() > 0) {
      Vertex current = this.notVisited.poll();

      for (Edge edge : current.edges()) {
        int newDistance = current.getDistance() + edge.getWeight();
        Vertex to = edge.getTo();

        if (newDistance < to.getDistance()) {
          to.setDistance(newDistance);
          previouses.put(to.getName(), edge);

          this.notVisited.remove(to);
          this.notVisited.add(to);
        }
      }
    }
  }

  public static void main(String[] args) {
    Vector<Vertex> vertices = new Vector<Vertex>();
    Vertex a = new Vertex("A");
    vertices.add(a);
    Vertex b = new Vertex("B");
    vertices.add(b);
    Vertex c = new Vertex("C");
    vertices.add(c);
    Vertex d = new Vertex("D");
    vertices.add(d);
    Vertex e = new Vertex("E");
    vertices.add(e);
    Vertex f = new Vertex("F");
    vertices.add(f);

    Edge edgeAB = new Edge(a, b, 4);
    a.edges().add(edgeAB);
    Edge edgeAC = new Edge(a, c, 2);
    a.edges().add(edgeAC);
    Edge edgeBC = new Edge(b, c, 5);
    b.edges().add(edgeBC);
    Edge edgeBD = new Edge(b, d, 1);
    b.edges().add(edgeBD);
    Edge edgeCE = new Edge(c, e, 3);
    c.edges().add(edgeCE);
    Edge edgeED = new Edge(e, d, 4);
    e.edges().add(edgeED);
    Edge edgeDF = new Edge(d, f, 11);
    d.edges().add(edgeDF);

    Hashtable<String, Edge> previouses = new Hashtable<String, Edge>();

    Dijkstra dijkstra = new Dijkstra();
    dijkstra.find(vertices, previouses);

    for (Vertex vertex : vertices) {
      System.out.printf("%s: %d\n", vertex.getName(), vertex.getDistance());
    }

    Edge previous = previouses.get("F");
    while (previous != null) {
      Vertex from = previous.getFrom();
      System.out.println(from.getName());
      previous = previouses.get(from.getName());
    }
  }
}
