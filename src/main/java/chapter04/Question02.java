package chapter04;

import java.util.HashSet;
import java.util.Set;

import base.BigO;

public class Question02 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Given a directed graph, design an algorithm to find out whether "
				+ "there is a route between two nodes";
	}

	/*
	 * An incidence matrix graph representation would provide O(1) lookup time.
	 * But the point of the exercise is to determine a traversal algorithm.
	 */

	public static class IncidenceGraph<T> extends UndirectionlGraph<T> {
		public boolean isConnected(T value1, T value2) {
			System.out.println("looking for path between " + value1 + " and "
					+ value2);
			UndirectionalVertex<T> vertex1 = getVertex(value1);
			UndirectionalVertex<T> vertex2 = getVertex(value2);

			// Breadth first search seems the best for finding related nodes
			// quickly. This assumes the node adjacency is closer than further.
			// For simplicity sake, first implementing Depth First Search
			return isConnected(vertex1, vertex2,
					new HashSet<UndirectionalEdge<T>>());

		}

		protected boolean isConnected(UndirectionalVertex<T> vertex1,
				UndirectionalVertex<T> vertex2,
				Set<UndirectionalEdge<T>> visitedEdgeSet) {
			if (vertex1.equals(vertex2)) {
				System.out.println("Connection found at: " + vertex1);
				return true; // Same node
			}
			for (UndirectionalEdge<T> edge : vertex1.getEdgeSet()) {
				if (visitedEdgeSet.contains(edge)) {
					continue; // Already checked
				}
				UndirectionalVertex<T> adjacent = edge.getAdjacent(vertex1);
				visitedEdgeSet.add(edge);
				System.out.println("Visited: " + edge);
				if (isConnected(adjacent, vertex2, visitedEdgeSet)) {
					return true;
				}
			}
			System.out.println("Connection not found between: " + vertex1
					+ " and " + vertex2);
			return false; // Traversed as far as can without finding
		}
	}

	/*
	 * The book solution is conceptually similar to mine, but the visited state
	 * is a property of the node. Not really sure I like that solution due to
	 * thread safety and separation of responsibility. Perhaps if it implemented
	 * the visitor pattern more explicitly....
	 */

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; // Using set to track visited vertices
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR; // Vertices are not revisited. But all may be
							// visited once.
	}

}
