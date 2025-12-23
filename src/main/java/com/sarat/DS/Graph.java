package com.sarat.DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
	Graph() {
	}

	private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

	public void printGraph() {
		System.out.println(adjList);
	}

	public boolean addVertex(String vertex) {
		if (adjList.get(vertex) == null) {
			adjList.put(vertex, new ArrayList<String>());
			return true;
		}
		return false;
	}

	public boolean addEdge(String vertex1, String vertex2) {
		if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
			adjList.get(vertex1).add(vertex2);
			adjList.get(vertex2).add(vertex1);
			return true;
		}
		return false;
	}

	public boolean removeEdge(String vertex1, String vertex2) {
		if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
			adjList.get(vertex1).remove(vertex2);
			adjList.get(vertex2).remove(vertex1);
			return true;
		}
		return false;
	}

	public boolean removeVertex(String vertex) {
		if (adjList.get(vertex) == null)
			return false;
		for (String otherVertex : adjList.get(vertex)) {
			adjList.get(otherVertex).remove(vertex);
		}
		adjList.remove(vertex);
		return true;
	}

	public static void main(String[] args) {

		Graph myGraph = new Graph();

		myGraph.addVertex("A");
		myGraph.addVertex("B");
		myGraph.addVertex("C");
		myGraph.addVertex("D");
		myGraph.printGraph();
		myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("C", "D");

		System.out.println("\nGraph after addEdge():");
		myGraph.printGraph();
		System.out.println("\nGraph before removeEdge():");
		myGraph.printGraph();
		myGraph.removeEdge("A", "B");
		System.out.println("\nGraph after removeEdge():");
		myGraph.printGraph();
		System.out.println("\nGraph before removeVertex():");
		myGraph.printGraph();

		myGraph.removeVertex("D");

		System.out.println("\nGraph after removeVertex():");
		myGraph.printGraph();
		/*
		 * EXPECTED OUTPUT: ---------------- Graph: {A=[], B=[]}
		 * 
		 */

	}

}
