import java.util.Map;

public class GraphDriver {

	public static void main(String[] args) {
		
		UnweightedDirectedGraph graph = new UnweightedDirectedGraph<String>();
		
		graph.addEdge("A", "H");
		graph.addEdge("A", "C");
		graph.addEdge("B", "H");
		graph.addEdge("D", "H");
		graph.addEdge("A", "G");
		graph.addEdge("A", "F");
		graph.addEdge("H", "A");
		
		Map<String, Degree> res = graph.findInOutDegrees();
		
		for (String vertex : res.keySet()) {
			System.out.println(vertex + " " + res.get(vertex).getIndegree() + " " + res.get(vertex).getOutdegree());
		}
	}

}
