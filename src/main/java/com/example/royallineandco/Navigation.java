package com.example.royallineandco;

import java.util.Scanner;

public class Navigation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of test cases: ");
        int num = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.print("Number of connections: ");
            int numberOfConnections = Integer.valueOf(scanner.nextLine());
            Graph graph = new Graph();
            for (int j = 0; j < numberOfConnections; j++) {
                String input = scanner.nextLine();
                String[] stations = input.split(" => ");
                graph.addVertex(stations[0]);
                graph.addVertex(stations[1]);
                graph.addEdge(stations[0], stations[1]);
                graph.addEdge(stations[1], stations[0]);
            }
            int queries = Integer.valueOf(scanner.nextLine());
            for (int z = 0; z < queries; z++) {
                String input = scanner.nextLine();
                String[] query = input.split(" -> ");
                String from = query[0];
                String to = query[1];
                graph.bfs(from, to);
            }
        }
    }
}