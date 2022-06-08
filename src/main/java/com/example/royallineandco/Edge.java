package com.example.royallineandco;

public class Edge<T extends Comparable<T>,N extends Comparable <N>> {
    /***
     * Vertex information
     */
    Vertex<T,N> toVertex;

    /***
     * Edge that is connect to next Vertex
     */
    Edge<T,N> nextEdge;

    /***
     * Initialise the edge
     */
    public Edge(){
        toVertex = null;
        nextEdge = null;
    }

    /***
     * Initialize the edge with the next vertex and next edge
     * @param destination next Vertex
     * @param a next edge
     */
    public Edge(Vertex<T,N> destination, Edge<T,N> a){
        toVertex = destination;
        nextEdge = a;
    }
}
