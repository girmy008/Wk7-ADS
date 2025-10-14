package mst;

import java.util.ArrayList;
import java.util.List;

public class Main
{

	public static void main(String[] args)
	{
		Graph australia = new Graph();
		
		Node adelaide = new Node("Adelaide");
		australia.addNode(adelaide);
		Node brisbane = new Node("Brisbane");
		australia.addNode(brisbane);
		Node darwin = new Node("Darwin");
		australia.addNode(darwin);
		Node melbourne = new Node("Melbourne");
		australia.addNode(melbourne);
		Node perth = new Node("Perth");
		australia.addNode(perth);
		Node sydney = new Node("Sydney");
		australia.addNode(sydney);
		
		// Weights are in kilometers
		australia.connectNodes(adelaide, brisbane, 2017.9);
		australia.connectNodes(adelaide, darwin, 3029.7);
		australia.connectNodes(adelaide, melbourne, 726.8);
		australia.connectNodes(adelaide, perth, 2695.1);
		australia.connectNodes(adelaide, sydney, 1374.6);
		australia.connectNodes(brisbane, darwin, 3425.6);
		australia.connectNodes(brisbane, sydney, 909.2);
		australia.connectNodes(darwin, sydney, 3934.8);
		australia.connectNodes(darwin, perth, 3719.6);
		australia.connectNodes(melbourne, sydney, 878.6);
		
		System.out.println("[Graph]");
		australia.print();
		
		System.out.println("[Minimum Spanning Tree]");
		Graph mst = KruskalMST(australia);
		mst.print();		
	}
	
	
	// Function that returns a minimum spanning tree of the original graph
	// using Kruskal's algorithm.
	private static Graph KruskalMST(Graph graph)
	{
		// a new graph to store a minimum spanning tree
		Graph mst = new Graph();
		for(Node n: graph.getNodes())
			mst.createNode(n.getName());
		
		// 
		// CONTINUOUS ASSESSMENT TASK - Implement This Function (Worth 2 marks)
		// PUT YOUR UNISA USERID HERE:
		//
		
		// Here's an outline:
		// setup a list of the nodes needed to be connected		
		// setup a list of edges from the original graph to consider adding to mst		
		// while there are still nodes to connect and edges to consider:
			// find the edge with minimum weight from the list of edges to consider
			// find the nodes in mst that correspond to the nodes of the found edge
			// if they are not connected yet in mst:
				// connect the nodes in mst
				// remove the nodes from the list of nodes needed to be connected
			// remove the edge from the list to consider
		
		return mst;
	}
	
	
}

