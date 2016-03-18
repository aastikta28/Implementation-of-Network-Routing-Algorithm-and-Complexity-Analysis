package algoproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class AlgoProject {

    public static void main(String[] args) throws IOException 
    {
        System.out.println("The Sample Min Heap for 15 vertices is ");
        MinHeap H_vert = new MinHeap(15);
        for (int i=1; i<=15;i++)
        H_vert.insert(i);
        H_vert.minHeap();
        H_vert.print();
        System.out.println("The Min val is " + H_vert.remove());
        
        Integer n = 5000;
        Random r = new Random();
        
                Graph gds = new Graph();
        Graph gds1 = new Graph();
        gds.degreeSequence = new ArrayList<Integer>();
        gds1.degreeSequence = new ArrayList<Integer>();
        int var = n;
        while (var > 0)
        {
            gds.degreeSequence.add(6);
            gds1.degreeSequence.add(1000);
            var--;
        }
        for(int a=1; a<=5 ; a++)
        {
        System.out.println("Random Graph pair "+a);
        gds.generateGraph();
        gds1.generateGraph();
       
         
       int number_of_vertices;
        int source = 0;
        try
        {
            for(int count=0;count<5;count++)
        {
            int src = r.nextInt(n-1)+0;
            int dest =  r.nextInt(n-1)+0;
            System.out.println("Random source-destination pair "+(count+1)+" : "+src+"-"+dest);
            gds.addPath(src, dest);
            gds1.addPath(src, dest);
            number_of_vertices = n;
            source = src;
            long startTime = System.nanoTime();
            Dijkstras_Array d = new Dijkstras_Array(number_of_vertices);
            d.dijkstra_algorithm(gds.adjecencyMatrix, source);
            long duration = System.nanoTime() - startTime;
            System.out.println("The Duration(in nanoseconds) is as follows:");
            System.out.println("For G1:");
            System.out.println("For Dijkstra Using Array : " + duration);
            
            startTime = System.nanoTime();
            Dijkstras_Heap dij = new Dijkstras_Heap(gds.adjecencyMatrix,number_of_vertices);
            duration = System.nanoTime() - startTime;
            System.out.println("For Dijkstra Using Heap : " + duration);
            
            startTime = System.nanoTime();
            KruskalAlgorithm ka = new KruskalAlgorithm(number_of_vertices);
            ka.kruskalAlgorithm(gds.adjecencyMatrix);
            duration = System.nanoTime() - startTime;
            System.out.println("For Kruskal : " + duration);
            
            System.out.println("For G2:");
            startTime = System.nanoTime();
            d.dijkstra_algorithm(gds1.adjecencyMatrix, source);
            duration = System.nanoTime() - startTime;
            System.out.println("For Dijkstra Using Array : " + duration);
            
            startTime = System.nanoTime();
            dij = new Dijkstras_Heap(gds1.adjecencyMatrix,number_of_vertices);
            duration = System.nanoTime() - startTime;
            System.out.println("For Dijkstra Using Heap : " + duration);
            
            startTime = System.nanoTime();
            ka = new KruskalAlgorithm(number_of_vertices);
            ka.kruskalAlgorithm(gds1.adjecencyMatrix);
            duration = System.nanoTime() - startTime;
            System.out.println("For Kruskal : " + duration);
            
        }
        }catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        }
}
}

  
