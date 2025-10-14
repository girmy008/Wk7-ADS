package mst;

import java.util.ArrayList;
import java.util.List;

/**
 * A node in a graph
 * @author Gun Lee
 *
 */
public class Node
{
	private String name;
	
	private List<Edge> edges = new ArrayList<Edge>();
	
	public Node(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public List<Edge> getEdges()
	{
		return edges;
	}
}
