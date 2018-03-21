import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private Vertex cursor;
    
    public Graph(String originalValue) {
        vertices = new ArrayList<Vertex>();
        vertices.add(new Vertex(originalValue));
        reset();
    }
    
    public void add(String source, String newValue) {
        //System.out.println("mapping " + source + " to " + newValue);
        int sourceIndex = -1;
        
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getValue().equals(source)) {
                sourceIndex = i;
                break;
            }
        }
        
        if (sourceIndex == -1) return;
        Vertex newVertex = new Vertex(newValue);
        vertices.add(newVertex);
        vertices.get(sourceIndex).add(newVertex);
    }
    
    public void reset() {
        cursor = vertices.get(0);
    }
    
    public void recurse() {
        do {
            try {
                cursor = cursor.traverse();
                System.out.print(cursor.getValue() + " ");
            } catch (Exception e) {
                break;
            }
        } while (!cursor.getValue().equals(vertices.get(0).getValue()));
    }
}
