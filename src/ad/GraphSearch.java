package ad;

public class GraphSearch {
	 public void BFS(GraphMatrix graph, int startVertex) {
	        int vertices = graph.getVertices();
	        int[][] adjMatrix = graph.getAdjMatrix();
	        boolean[] visited = new boolean[vertices];
	        QueueBFSearch queue = new QueueBFSearch(vertices);

	        visited[startVertex] = true;
	        queue.enqueue(startVertex);

	        while (!queue.isEmpty()) {
	            int vertex = queue.dequeue();
	            System.out.print(vertex + " ");

	            for (int i = 0; i < vertices; i++) {
	                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
	                    visited[i] = true;
	                    queue.enqueue(i);
	                }
	            }
	        }
	    }

	    // DFS traversal from a given source vertex
	    public void DFS(GraphMatrix graph, int startVertex) {
	        int vertices = graph.getVertices();
	        int[][] adjMatrix = graph.getAdjMatrix();
	        boolean[] visited = new boolean[vertices];
	        DFSUtil(startVertex, visited, adjMatrix);
	    }

	    // Recursive helper function for DFS
	    private void DFSUtil(int vertex, boolean[] visited, int[][] adjMatrix) {
	        visited[vertex] = true;
	        System.out.print(vertex + " ");

	        for (int i = 0; i < adjMatrix.length; i++) {
	            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
	                DFSUtil(i, visited, adjMatrix);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        GraphMatrix graph = new GraphMatrix(5);
	        graph.addEdge(0, 1); 
	        graph.addEdge(0, 2);  
	        graph.addEdge(2, 3);  
	        graph.addEdge(3, 4);  
	        graph.addEdge(2, 1);  
	        graph.addEdge(4, 1);  
	        graph.addEdge(3, 1);  

	        System.out.println("Adjacency Matrix Representation:");
	        graph.printGraph();

	        GraphSearch search = new GraphSearch();

	        System.out.println("\nBreadth-First Search (BFS) starting from vertex 0:");
	        search.BFS(graph, 0);

	        System.out.println("\nDepth-First Search (DFS) starting from vertex 0:");
	        search.DFS(graph, 0);
	    }
	}