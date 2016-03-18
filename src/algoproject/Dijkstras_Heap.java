package algoproject;
 
public class Dijkstras_Heap
{
    
    
    
    private static MaxHeap heap = new MaxHeap(10000);
    private static int[][] adjacencyMatrix;

    public Dijkstras_Heap(int adjacency_matrix[][], int n) {
        adjacencyMatrix = new int[n + 1][n + 1];
         for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
    }

     public int solve(int numOfNodes, int source, int dest) {
        heap.push(source, 0);
        while (!heap.isEmpty()) {
            int u = heap.pop();
            if (u == dest)
                return heap.cost[dest];
            for (int i = 0; i < numOfNodes; i++) {
                if (adjacencyMatrix[u][i] > 0)
                    heap.push(i, heap.cost[u] + adjacencyMatrix[u][i]);
            }
        }
        return -1;
    }
  
}