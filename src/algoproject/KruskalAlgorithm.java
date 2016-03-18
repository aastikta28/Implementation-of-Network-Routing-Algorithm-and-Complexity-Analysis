package algoproject;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
 
public class KruskalAlgorithm
{
    private List<Edge> edges;
    private int numberOfVertices;
    public static final int MAX_VALUE = 999;
    private int visited[];
    private int spanning_tree[][];
 
    public KruskalAlgorithm(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        edges = new LinkedList<Edge>();
        visited = new int[this.numberOfVertices];
        spanning_tree = new int[numberOfVertices][numberOfVertices];
    }
  
    public void kruskalAlgorithm(int adjacencyMatrix[][])
    {
        boolean finished = false;
        
        
        
        for (int source = 0; source < numberOfVertices; source++)
        {
            for (int destination = 0; destination < numberOfVertices; destination++)
            {
                if (adjacencyMatrix[source][destination] != MAX_VALUE && source != destination)
                {
                    Edge edge = new Edge();
                    edge.sourcevertex = source;
                    edge.destinationvertex = destination;
                    edge.weight = adjacencyMatrix[source][destination];
                    adjacencyMatrix[destination][source] = MAX_VALUE;
                    edges.add(edge);
                }
            }
        }
         Collections.sort(edges, new EdgeComparator());
        for (Edge edge : edges)
        {
            spanning_tree[edge.sourcevertex][edge.destinationvertex] = edge.weight;
            spanning_tree[edge.destinationvertex][edge.sourcevertex] = edge.weight;
            visited[edge.sourcevertex] = 1;
            visited[edge.destinationvertex] = 1;
            for (int i = 0; i < visited.length; i++)
            {
                if (visited[i] == 0)
                {
                    finished = false;
                    break;
                } else
                {
                    finished = true;
                }
            }
            if (finished)
                break;
        }
        int sum = 0;
       for (int source = 0; source < numberOfVertices; source++)
        {
            for (int destination = 0; destination < numberOfVertices; destination++)
            {
                sum = sum + spanning_tree[source][destination];
            }
            
        }
       }
 
    
}
 
class Edge
{
    int sourcevertex;
    int destinationvertex;
    int weight;
}
 
class EdgeComparator implements Comparator<Edge>
{
    @Override
    public int compare(Edge edge1, Edge edge2)
    {
        if (edge1.weight > edge2.weight)
            return -1;
        if (edge1.weight < edge2.weight)
            return 1;
        return 0;
    }
}
 