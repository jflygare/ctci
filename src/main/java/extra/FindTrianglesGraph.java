package extra;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.set.ListOrderedSet;

import base.BigO;

public class FindTrianglesGraph extends ExtraQuestionBase {

	@Override
	public String question() {
		return "Given a undirected graph with corresponding edges, "
				+ "find the number of possible triangles";
	}
	
	// Assumptions:
	// Triangles containing the same 3 vertices in any order are considered equal
	// Vertices are uniquely labeled
	// The construction/modification complexity of the graph does not matter
	// All we want is the count
	// Assume the graph is connected (a path exists from each node to every other node)
	// Can forego bean/getters/setters for simpler code
	
	public static class TriVertex {
		public int data;

		// Associated edges
		// Use Set to enforce uniqueness. Use HashSet for amortized O(1) search
		// This is a bit tightly coupled and can be separated
		// out to be the responsibility of the graph, but putting
		// here for simplicity sake.
		public Set<TriEdge> edges = new HashSet<TriEdge>();
		
		// Override hashCode and equals
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + data;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TriVertex other = (TriVertex) obj;
			if (data != other.data)
				return false;
			return true;
		}
		
	}
	
	public static class TriEdge {
		public TriVertex v1;
		public TriVertex v2;
		
		public TriEdge(TriVertex v1, TriVertex v2) {
			this.v1 = v1;
			this.v2 = v2;
			//TODO: Check nulls
			v1.edges.add(this);
			v2.edges.add(this);
		}
		
		// Override hashCode and equals
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
			result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TriEdge other = (TriEdge) obj;
			if (v1 == null) {
				if (other.v1 != null)
					return false;
			} else if (!v1.equals(other.v1))
				return false;
			if (v2 == null) {
				if (other.v2 != null)
					return false;
			} else if (!v2.equals(other.v2))
				return false;
			return true;
		}
	}
	
	public static class TriGraph {
		// Only care about edges. Algorithm uses DFS of Edges instead of Vertices.
		// Use Set to enforce uniqueness
		public Set<TriEdge> edges = new HashSet<TriEdge>();
		
		public int countTriangles() {
			// Too few edges condition
			if (edges.size() < 3) {
				return 0;
			}
			
			// Pick any edge to start
			TriEdge edge = edges.iterator().next();
			
			// Pass all state into recursive algorithm instead of having
			// to maintain and initialize the state of the graph/edges
			IntWrapper count = new IntWrapper(); // Wrapper keeping count
			
			// Use ListOrderedSet = for 2 reasons. Under the covers it uses:
			// -- ArrayList to keep track of order in which edges are visited (amortized O(1) inserts).
			// -- HashSet to get amortized O(1) searching
			// This can be done in a number of ways with the same performance. Unfortunately this is an older
			// collection that does not support generics.
			ListOrderedSet visited = new ListOrderedSet();
			
			// Start DFS recursion
			findTriangles(edge, visited, count);
			
			return count.num;
		}
		
		// Private recursive DFS algorithm. Takes all the state it needs as input instead of
		// having to initialize and synchronize state in the graph.
		private void findTriangles(TriEdge edge, ListOrderedSet visited, IntWrapper count) {
			// Add edge to visited list
			// Because we assume the graph is connected, we do not
			// have to keep the visited state in the Edge. This frees us
			// from having to initialize the edge state (O(N)) before the search
			// We use the list to refer to the parent/ancestor edges
			visited.add(edge);
			
			// If we have traversed the graph far enough to test for a triangle..
			if (visited.size() > 2) {
				// Get the 2nd to last visited edge
				TriEdge e1 = (TriEdge) visited.get(visited.size() - 3);
				if (e1.v1.equals(edge.v2)) {
					// Triangle found
					count.num++;
				}
			}
			
			// Recurse the unvisited edges
			for (TriEdge nextEdge : edge.v2.edges) {
				if (visited.contains(nextEdge)) {
					continue; // This is where the HashSet comes in handy
				}
				findTriangles(nextEdge, visited, count);
			}
		}
	}
	
	// Wrapper for passing integer by reference
	public static class IntWrapper {
		public int num;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR;
	}

	@Override
	public BigO solutionTimeComplexity() {
		// Data structures amortize to O(1) time per operation
		// So search amortizes to standard DFS time complexity O(n+m)
		return BigO.LINEAR; // Data structures amortize to 
	}

}
