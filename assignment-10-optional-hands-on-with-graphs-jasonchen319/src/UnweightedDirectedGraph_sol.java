package solution;
/**
 * A class representing a directed unweighted graph using Adjacency list
 */
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
/**
 * 
 * 
 *
 * @param <V> is the generic type for vertices in graph
 */
class UnweightedDirectedGraph_sol<V>
{
	//A HashMap of lists for Adjacency list representation. Key is a source vertex and 
	//value is a list of edges (i.e., destination vertices) for the key
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
	
	
	
	
	
	/**
	 * A method for doing BFS traversal of the graph
	 * @param origin: The vertex from which we start the traversal
	 * @return: A list of vertices in the order visited in the traversal
	 */
	public List<V> bfsTraversal(V origin)
	{
		//validating parameters
		if (adj.isEmpty() || !adj.containsKey(origin) )
			return null;
		//Use a queue to store the nodes that are visited and remove them in a FIFO order 
		Queue<V> queue = new LinkedList<V>();
		
		//Store the visited vertices in a hashset for efficient retrieval
		Set<V> visited = new HashSet<V>();
		
		//Store the result in a list
		List<V> result = new LinkedList<V>();
		
		//Add the origin to the queue and the visited set
		queue.add(origin);
		visited.add(origin);
		
		while (!queue.isEmpty())
		{
			//remove a vertex from the front of the queue
			V frontVertex = queue.poll();
			
			//Add the front vertex to the result
			result.add(frontVertex);
			
			//If frontVertex has no neighbor skip the rest of the statements in the loop
			if (adj.get(frontVertex)== null)
				continue;
			//Get all the neighbors of the front vertex and add the ones that are unvisited to the queue and visited set

			for(V neighbor: adj.get(frontVertex))
			{
				//If a neighbor is not already visited add it to the queue and the visited set
				if(!visited.contains(neighbor))
				{
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
						
		}
		return result;
	}
/**
 * 
 * @param origin : The vertex from which we start the traversal
 * @return: A list containing the result of the traversal. The nodes are stored in the order they are visited
 */
	public List<V> dfsTraversal(V origin)
	{
		//validating parameters
		if (adj.isEmpty() || !adj.containsKey(origin) )
			return null;
		//Use a stack to keep track of the vertices that are visited and to remove them in a LIFO order
		Stack<V> stack = new Stack<V>();
		
		//Store the vertices that are visited in a hashset for efficient retrieval
		Set<V> visited = new HashSet<V>();
		
		//Store the result of traversal in a list
		List<V> result = new LinkedList<V>();
		
		//Add the origin to result, stack, and visited.
		result.add(origin);
		stack.push(origin);
		visited.add(origin);

		while (!stack.isEmpty())
		{
			//Peek the vertex at the top of the stack and store it in the frontVertex
			V frontVertex = stack.peek();
			Boolean foundUnvisitedNeighbor=false;
			
			//If frontVertex has no neighbor pop the frontVertex from the stack and skip the rest of the statements in the loop
			if (adj.get(frontVertex)== null)
			{
				stack.pop();
				continue;
			
			}	
			Iterator<V> itr = adj.get(frontVertex).iterator();
			//Go through the neighbors of the frontVertex until you find an unvisited neighbor
			while (itr.hasNext() && !foundUnvisitedNeighbor)
			{
				V neighbor = itr.next();
				
				//If you find an unvisited neighbor push it to the stack and add it to the result list and visited set.
				if(!visited.contains(neighbor))
				{
					foundUnvisitedNeighbor=true;
					stack.push(neighbor);
					result.add(neighbor);
					visited.add(neighbor);
				}
				
			}
			//If the frontVertex has no unvisited neighbor backtrack and pop the frontVertex from the stack
			if (!foundUnvisitedNeighbor)
				stack.pop();
				
		}
		return result;
	}
	
	
	/**
	 * 
	 * @param src : The origin vertex
	 * @param dest: The destination vertex
	 * @return the shortest path from origin to vertex stored in a list.
	 */
	public List<V> getShortestPath(V src, V dest){
		
		if (adj.isEmpty() || !adj.containsKey(src) || !adj.containsKey(dest) || src.equals(dest))
			return null;
			
		Queue<V> queue= new LinkedList<V>();
		
		//A hashmap which stores the visited vertices. Key is a vertex and value is the predecessor of this vertex
		Map<V, V> visited = new HashMap<V,V>();
		
		//A stack to store the shortest path.The destination is at the bottom and source is at the top of the stack.
		Stack<V> path= new Stack<V>();
		
		//A queue to do breadth first search
		queue.add(src);
		
		//Put the pair src in to the visited map. The predecessor of src is null.
		visited.put(src,null);
		List<V> result=null;
		
		//Start the breadth first search
		while (!queue.isEmpty())
		{
			 V frontVertex= queue.poll();
			
			 //If frontVertex has no neighbor skip the rest of the statements in the loop
				if (adj.get(frontVertex)== null)
					continue;
			 		 
			 for(V neighbor: adj.get(frontVertex))
				{
					if(!visited.containsKey(neighbor) )
					{
						queue.add(neighbor);
						visited.put(neighbor,frontVertex);
					}
					
					//If destination is found return the path by following the destinations predecessors
					 if (neighbor.equals(dest))
					 {
						 //Push the destination into the path stack
						 path.push(neighbor);
						 
						 //Follow the predecessors until you get to the src node (where predecessor is null)
						 V predecessor = visited.get(neighbor);
						
						 while (predecessor!=null)
						{
							 path.push(predecessor);
							 predecessor = visited.get(predecessor);
						}
						 //Copy the path from stack to the result and return the result.
						result = new LinkedList<V>();
						while (!path.isEmpty())
							result.add(path.pop());
						return result;
					 }
				}
				 
		}
		return result;

	}
	
/**
 * This method is of O(|E|)	because it only goes through each edge only once.
 * @return
 */
	public Map<V, Degree> findInOutDegrees()
	{
		Map<V, Degree> degrees = new HashMap<V, Degree>();
		
		//Go through each vertex in the adjacency list		
		for (V vertex : adj.keySet())
		{
			//If the vertex already exists in the degrees map, just update its outdegree
			if (degrees.containsKey(vertex))
			{
				Degree d = degrees.get(vertex);
				d.setOutdegree(adj.get(vertex).size());
				degrees.put(vertex, d);
			}
			//If the vertex does not exists in the degrees map, create a new entry for it and set its indegree to zero and outdegree ot the size of neighbors of vertex
			else
				degrees.put(vertex, new Degree(0,adj.get(vertex).size()));
			
			//Go through each neighbor of the vertex
			for (V neighbor:adj.get(vertex))
			{	
				//If the neighbor already exists in the degrees map, increment its indegree
				if (degrees.containsKey(neighbor))
				{
					Degree d = degrees.get(neighbor);
					d.setIndegree(d.indegree+1);
					degrees.put(neighbor, d);
				}
				//If the neighbor does not exist in the degrees map create a new entry for it and set is indegree to one and outdegree to zero
				else 
					degrees.put(neighbor, new Degree(1,0));
				
				
			}
		}
		
		return degrees;
	}
	public String toString()
	{
		String out="";
		for(V vertex : adj.keySet())
		{
			LinkedList<V> edgeList = adj.get(vertex);
			if (edgeList == null)
				continue;
			for (V neighbor: edgeList)
				out+= vertex.toString() +"->"+neighbor.toString()+" ";
			out+="\n";
		}
		return out;
	}
	
	
}
