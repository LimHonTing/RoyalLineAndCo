package com.example.royallineandco;


public class Vertex<T extends Comparable<T>,N extends Comparable <N>> {
    T vertexInfo;
    int indeg;
    int outdeg;
    Vertex<T,N> nextVertex;
    Edge<T,N> firstEdge;
    boolean visited = false;
    Vertex<T,N> prevVertex;

    public Vertex(){
        vertexInfo = null;
        indeg = 0;
        outdeg = 0;
        nextVertex = null;
        firstEdge = null;
        prevVertex = null;
    }

    public Vertex(T vInfo, Vertex<T,N> next){
        vertexInfo = vInfo;
        indeg =0;
        outdeg = 0;
        nextVertex = next;
        firstEdge = null;
        prevVertex = null;
    }

    public void unVisit(){
        this.visited = false;
    }

}
