package com.example.royallineandco;


public class Vertex<T extends Comparable<T>,N extends Comparable <N>> {
    /***
     * To collect the information of this vertex
     */
    T vertexInfo;

    /***
     * store the link to next Vertex
     */
    Vertex<T,N> nextVertex;

    /***
     * store all the information that this vertex is connected to another Vertex
     */
    Edge<T,N> firstEdge;

    /***
     * To check whether this vertex is visited or not
     */
    boolean visited = false;

    /***
     * Store the path information for previous vertex
     */
    Vertex<T,N> prevVertex;

    /***
     * Initiliaze the vertex
     */
    public Vertex(){
        vertexInfo = null;
        nextVertex = null;
        firstEdge = null;
        prevVertex = null;
    }

    /***
     * Initialize vertex with the information and next Vertex to it
     * @param vInfo the information of this vertex
     * @param next the vertex next to this vertex
     */
    public Vertex(T vInfo, Vertex<T,N> next){
        vertexInfo = vInfo;
        nextVertex = next;
        firstEdge = null;
        prevVertex = null;
    }
}
