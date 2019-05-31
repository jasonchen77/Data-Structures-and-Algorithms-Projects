
/**
 * A class representing a directed unweighted graph using Adjacency list
 */
import java.util.*;
import java.io.*;
/**
 * 
 * @author Jason Chen
 *
 * @param <V> is the generic type for vertices in graph
 */
class UnweightedDirectedGraph<V extends Comparable<? super V>>
{
	//A HashMap of lists for Adjacency list representation. Key is a source vertex and 
	//value is a list of outgoing edges (i.e., destination vertices) for the key
	private HashMap<V,LinkedList<V>> adj;
	
	public UnweightedDirectedGraph()
	{
		adj = new HashMap<V,LinkedList<V>>();
	}
	
	/**
	 * A function to add an edge
	 * @param source : The source of the edge
	 * @param dest: The destination of the edge
	 */
	
	public void addEdge(V source, V dest)
	{
		LinkedList<V> edgeList = adj.get(source);
		if (edgeList==null)
			edgeList = new LinkedList<V>();
		
		edgeList.add(dest);
		adj.put(source, edgeList);
	}
	
	
	
	
	
//Find the in and out degrees
	
/**
 * Computes the in-degree and outDegree for each vertex in the graph
 * @returns a dictionary which maps every vertex to its Degree object containing the in-degree and out-degreeo of the vertex
 */
public Map<V, Degree> findInOutDegrees()
{
	Map<V, Degree> result = new HashMap<V, Degree>();
	HashSet<V> inOnlyVertices = new HashSet<V>();
	
	for (V vertex : adj.keySet() ) {
		int inDegree = 0;
		int outDegree = 0;
		for (V edge : adj.get(vertex)) {
			outDegree++;
		}
		for (V vertex1 : adj.keySet() ) {
			for (V edge1 : adj.get(vertex1)) {
				if (vertex.compareTo(edge1) == 0) {
					inDegree++;
				}
			}
		}
		result.put(vertex, new Degree(inDegree, outDegree));
	}
	for (V vertex : adj.keySet()) {
		for (V edge : adj.get(vertex)) {
			if (!adj.containsKey(edge)) {
				inOnlyVertices.add(edge);
			}
		}
	}
	for (V inVertex : inOnlyVertices) {
		int inDegree = 0;
		for (V vertex1 : adj.keySet() ) {
			for (V edge1 : adj.get(vertex1)) {
				if (inVertex.compareTo(edge1) == 0) {
					inDegree++;
				}
			}
		}
		result.put(inVertex, new Degree(inDegree, 0));
	}
	return result;
	
}
	


}