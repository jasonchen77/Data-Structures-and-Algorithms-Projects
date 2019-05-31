
/**
 * The class to store the number of incoming edges (indegree) to a vertex and the number of outgoign edges (outdegree) from a vertex
 * 
 *
 * @param <V>
 */
public class Degree {
	
	
	//Number off incoming edges to a vertex
	int indegree;
	
	//number of outgoing edges from a vertex
	int outdegree;
	
	//Constructor
	public Degree ( int indegree, int outdegree){
		
		this.indegree= indegree;
		this.outdegree= outdegree;
	}

	
	//Getter and Setter MNethods

	public int getIndegree() {
		return indegree;
	}

	public void setIndegree(int indegree) {
		this.indegree = indegree;
	}

	public int getOutdegree() {
		return outdegree;
	}

	public void setOutdegree(int outdegree) {
		this.outdegree = outdegree;
	}
	
	
}
