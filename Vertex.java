import java.util.ArrayList;
import java.util.Random;

public class Vertex {
    public class Edge {
        private Vertex connection;
        private int strength;
        
        public Edge(Vertex connection) {
            this.connection = connection;
            strength = 1;
        }
        
        
        public void strengthen() {
            strength++;
        }
    }
    
    private ArrayList<Edge> edges;
    private String id;
    
    public Vertex(String id) {
        this.id = id;
        edges = new ArrayList<Edge>();
    }
    
    public void add(Vertex newVertex) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).connection == newVertex) {
                edges.get(i).strengthen();
                newVertex.strengthen(this);
                return;
            }
        }
        
        edges.add(new Edge(newVertex));
        newVertex.addEdge(this);
    }
    
    public void addEdge(Vertex newVertex) {
        edges.add(new Edge(newVertex));
    }
    
    public void strengthen(Vertex newVertex) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).connection == newVertex) {
                edges.get(i).strengthen();
                return;
            }
        }
    }
    
    public Vertex traverse() {
        ArrayList<Edge> temp = new ArrayList<Edge>();
        int totalStrength = 0;
        for (int i = 0; i < edges.size(); i++) {
            totalStrength += edges.get(i).strength;
            for (int j = 0; j < edges.get(i).strength; j++) temp.add(edges.get(i));
        }
        
        Random rand = new Random();
        Edge selectedEdge = temp.get(rand.nextInt(totalStrength));
        return selectedEdge.connection;
    }
    
    public String getValue() {
        return id;
    }
}
