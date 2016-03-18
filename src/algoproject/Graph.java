package algoproject;

import java.util.List;
import java.util.Random;
 
public class Graph
{
    int[][] adjecencyMatrix;
    List<Integer> degreeSequence;
 
    private void addEdges(Integer v, Integer e)
    {
        int num, max = degreeSequence.size()-1, min = v+1, count = 0;
        while (e > 0)
        {
        if(max >= min)
        {
            Random r = new Random();
            
             num = r.nextInt(max-min+1)+min;
             int wt = r.nextInt(9)+1;
                if(degreeSequence.get(num) != 0)
                { 
                    if(adjecencyMatrix[v][num] == 0)
                    {
               adjecencyMatrix[v][num] = adjecencyMatrix[num][v] = wt;
                Integer val = degreeSequence.get(num);
                if (val > 0)
                    degreeSequence.set(num, val - 1);
                e--;
                    }
                }
                
        }
       
        count ++;
        if(count == 5000)
            e=0;
        }
    }
 
    public void generateGraph()
    {
        adjecencyMatrix = new int[degreeSequence.size()][degreeSequence.size()];
        for (int i = 0; i < adjecencyMatrix.length; i++)
        {
            for (int j = 0; j < adjecencyMatrix.length; j++)
            {
                adjecencyMatrix[i][j] = 0;
            }
        }
            //addPath(src, dest);
        for (int i = 0; i < degreeSequence.size(); i++)
        {
            Integer e = degreeSequence.get(i);
            degreeSequence.set(i, 0);
            addEdges(i, e);
        }
    }
 
    public void printGraph()
    {
        System.out.println("The matrix form of graph: ");
        for (int i = 0; i < adjecencyMatrix.length; i++)
        {
            for (int j = 0; j < adjecencyMatrix.length; j++)
            {
                System.out.print(adjecencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
 
    public void addPath(int src, int dest) {
     int num;
if(src > dest)
{
    num = src;
    for(num=src;num<dest;num++)
    {
        Random r = new Random();
            int wt = r.nextInt(9)+1;
    
        int var = num+1;
        adjecencyMatrix[num][var] = adjecencyMatrix[var][num] = wt;
        Integer val = degreeSequence.get(num);
                if (val > 0)
                    degreeSequence.set(num, val - 1);
        
    }
    
}
else 
{
    int cmp = src; 
     src = dest;
     dest =cmp;
      
    for(num=src;num<dest;num++)
    {
        Random r = new Random();
            int wt = r.nextInt(9)+1;
    
        int var = num+1;
        adjecencyMatrix[num][var] = adjecencyMatrix[var][num] = wt;
        Integer val = degreeSequence.get(num);
                if (val > 0)
                    degreeSequence.set(num, val - 1);
    }
    
}

}
}
