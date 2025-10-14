package mst;


/**
 * An undirected (i.e. bidirectional) edge
 * @author Gun Lee
 *
 */
public class Edge
{
	public Node nodeA;
	public Node nodeB;
	public double weight;
	
	public Edge(Node a, Node b, double weight)
	{
		this.nodeA = a;
		this.nodeB = b;
		this.weight = weight;
	}
}
