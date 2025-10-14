package mst;

import java.util.ArrayList;
import java.util.List;


/**
 * An undirected graph (i.e. all the edges are bidirectional)
 * @author Gun Lee
 *
 */
public class Graph 
{
	private List<Node> nodes = new ArrayList<Node>();
	private List<Edge> edges = new ArrayList<Edge>();
	
	public Graph() 
	{
	}
	
	
	/**
	 * Create and return a node with the given name.
	 * If a node already exists with the given name, return that node.
	 * @param name
	 * @return a node with the given name.
	 */
	public Node createNode(String name)
	{
		Node node = findNode(name);
		if(node == null)
		{
			node = new Node(name);
			nodes.add(node);
		}
		
		return node;
	}
	
	
	/**
	 * Add the given node to the graph if not already exists.
	 * @param node
	 */
	public void addNode(Node node)
	{
		if(!nodes.contains(node))
			nodes.add(node);
	}
	
	/**
	 * Find a node with a given name.
	 * @param name
	 * @return the node found, or null if not found.
	 */
	public Node findNode(String name)
	{
		for(Node n: nodes)
			if(n.getName().equals(name))
				return n;
		
		return null;
	}
	
	/**
	 * Connect the two nodes with given weight and return the edge.
	 * @param a
	 * @param b
	 * @param weight
	 * @return edge that connects a and b.
	 */
	public Edge connectNodes(Node a, Node b, double weight)
	{
		Edge edge = new Edge(a, b, weight);
		edges.add(edge);
		a.getEdges().add(edge);
		b.getEdges().add(edge);
		
		return edge;
	}
	
	/**
	 * Find and return the edge between two nodes.
	 * @param a
	 * @param b
	 * @return found edge, or null if not connected.
	 */
	public Edge edgeBetween(Node a, Node b)
	{
		Edge retval = null;
		
		for(Edge e: a.getEdges()) 
			if(e.nodeA == b || e.nodeB == b)
				retval = e;
		
		return retval;
	}
	
	
	/**
	 * check if node a and b are connected using breadth-first search
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isConnected(Node a, Node b)
	{	
		List<Node> queue = new ArrayList<Node>();
		List<Node> visited = new ArrayList<Node>();
		
		// starting from node a
		queue.add(a);
		
		while(!queue.isEmpty()) 
		{
			// dequeue a node
			Node node = queue.get(0);
			queue.remove(0);
			
			// add to the visited node list
			visited.add(node);
			
			// check each edges of the current node
			for(Edge e: node.getEdges())
			{
				if(e.nodeA == b || e.nodeB == b)
					return true;
				
				if(!queue.contains(e.nodeA) && !visited.contains(e.nodeA))
					queue.add(e.nodeA);
				
				if(!queue.contains(e.nodeB) && !visited.contains(e.nodeB))
					queue.add(e.nodeB);
			}
		}
		
		return false;
	}
	
	public List<Node> getNodes()
	{
		return this.nodes;
	}
	
	public List<Edge> getEdges()
	{
		return this.edges;
	}
	
	/**
	 * Print the graph.
	 */
	public void print() 
	{
		for (int i = 0; i < nodes.size(); i++)
		{
			Node n = nodes.get(i);
			System.out.print(n.getName());
			System.out.print(" has edges to: ");
			
			List<Edge> node_edges = n.getEdges();
			for (int j = 0; j < node_edges.size(); j++)
			{
				Edge e = node_edges.get(j);
				Node dst = e.nodeB;
				if(dst == n)
					dst = e.nodeA;
				
				System.out.print(dst.getName());
				System.out.print("(");
				System.out.print(e.weight);
				System.out.print(")");
				
				if (j != node_edges.size() - 1)
					System.out.print(", ");
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
}
