package chapter04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import base.QuestionBase;

public abstract class ChapterQuestionBase extends QuestionBase {

	@Override
	public String answersUrl() {
		return "https://code.google.com/p/ctci/source/browse/trunk/Java/Chapter+4";
	}

	public static class UndirectionlGraph<T> {

		private Map<T, UndirectionalVertex<T>> vertexMap = new HashMap<T, UndirectionalVertex<T>>();

		protected UndirectionalVertex<T> getVertex(T datum) {
			return vertexMap.get(datum);
		}
		
		public void add(T datum)
		{
			if (vertexMap.containsKey(datum)) {
				// Easier than re-linking edges to replacement vertex
				throw new IllegalArgumentException("Graph already contains: " + datum);
			}
			
			vertexMap.put(datum, new UndirectionalVertex<T>(datum));
		}
		
		public void connect(T datum1, T datum2) {
			UndirectionalVertex<T> vertex1 = null;
			if (vertexMap.containsKey(datum1)) {
				vertex1 = vertexMap.get(datum1);
			} else {
				vertex1 = new UndirectionalVertex<T>(datum1);
				vertexMap.put(datum1, vertex1);
			}
			
			UndirectionalVertex<T> vertex2 = null;
			if (vertexMap.containsKey(datum2)) {
				vertex2 = vertexMap.get(datum2);
			} else {
				vertex2 = new UndirectionalVertex<T>(datum2);
				vertexMap.put(datum2, vertex2);
			}
			
			UndirectionalEdge<T> edge = new UndirectionalEdge<T>(vertex1, vertex2);
			vertex1.addEdge(edge);
			vertex2.addEdge(edge);
		}

		public static class UndirectionalVertex<T> {
			private T datum;
			private Set<UndirectionalEdge<T>> edgeSet = new HashSet<UndirectionalEdge<T>>();

			public UndirectionalVertex(T datum) {
				this.datum = datum;
			}

			public T getDatum() {
				return datum;
			}

			public void setDatum(T datum) {
				this.datum = datum;
			}

			public Set<UndirectionalEdge<T>> getEdgeSet() {
				return edgeSet;
			}

			public void setEdgeSet(Set<UndirectionalEdge<T>> edgeSet) {
				this.edgeSet = edgeSet;
			}

			public void addEdge(UndirectionalEdge<T> edge) {
				edgeSet.add(edge);
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result
						+ ((datum == null) ? 0 : datum.hashCode());
				return result;
			}

			@SuppressWarnings("unchecked")
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				UndirectionalVertex<T> other = (UndirectionalVertex<T>) obj;
				if (datum == null) {
					if (other.datum != null)
						return false;
				} else if (!datum.equals(other.datum))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "Vertex [" + datum + "]";
			}

		}

		public static class UndirectionalEdge<T> {
			private UndirectionalVertex<T> vertex1;
			private UndirectionalVertex<T> vertex2;

			public UndirectionalEdge(UndirectionalVertex<T> vertex1,
					UndirectionalVertex<T> vertex2) {
				this.vertex1 = vertex1;
				this.vertex2 = vertex2;
			}

			public UndirectionalVertex<T> getVertex1() {
				return vertex1;
			}

			public void setVertex1(UndirectionalVertex<T> vertex1) {
				this.vertex1 = vertex1;
			}

			public UndirectionalVertex<T> getVertex2() {
				return vertex2;
			}

			public void setVertex2(UndirectionalVertex<T> vertex2) {
				this.vertex2 = vertex2;
			}

			public UndirectionalVertex<T> getAdjacent(UndirectionalVertex<T> vertex) {
				if (vertex.equals(vertex1)) {
					return vertex2;
				}
				if (vertex.equals(vertex2)) {
					return vertex1;
				}
				// else not connected
				throw new IllegalArgumentException("Vertex: " + vertex
						+ " does not belong to edge: " + this);
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result
						+ ((vertex1 == null) ? 0 : vertex1.hashCode());
				result = prime * result
						+ ((vertex2 == null) ? 0 : vertex2.hashCode());
				return result;
			}

			@SuppressWarnings("unchecked")
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				UndirectionalEdge<T> other = (UndirectionalEdge<T>) obj;
				if (vertex1.equals(other.vertex1)) {
					return vertex2.equals(other.vertex2);
				} else if (vertex1.equals(other.vertex2)) {
					return vertex2.equals(other.vertex1);
				} else {
					return false; // No match
				}
			}

			@Override
			public String toString() {
				return "Edge: " + vertex1 + " <--> "
						+ vertex2;
			}

		}
	}

	public static class BinaryTree<T> {

		protected BinaryTreeNode<T> root;

		public BinaryTreeNode<T> getRoot() {
			return root;
		}

		public void setRoot(BinaryTreeNode<T> root) {
			this.root = root;
		}

		public boolean isEmpty() {
			return (root == null);
		}

		public String print() {
			if (isEmpty()) {
				return "<NULL>";
			}
			return root.printTree();
		}

		public static class BinaryTreeNode<T> {
			private T datum;
			private BinaryTreeNode<T> left;
			private BinaryTreeNode<T> right;

			public BinaryTreeNode() {
			}

			public BinaryTreeNode(T datum) {
				this.datum = datum;
			}

			public T getDatum() {
				return datum;
			}

			public void setDatum(T datum) {
				this.datum = datum;
			}

			public BinaryTreeNode<T> getLeft() {
				return left;
			}

			public void setLeft(BinaryTreeNode<T> left) {
				this.left = left;
			}

			public BinaryTreeNode<T> getRight() {
				return right;
			}

			public void setRight(BinaryTreeNode<T> right) {
				this.right = right;
			}

			public boolean isLeaf() {
				return (left == null & right == null);
			}

			public String printTree() {
				StringBuffer sb = new StringBuffer();
				if (right != null) {
					right.printTree(sb, true, "");
				}
				printNodeValue(sb);
				if (left != null) {
					left.printTree(sb, false, "");
				}
				return sb.toString();
			}

			private void printNodeValue(StringBuffer out) {
				if (datum == null) {
					out.append("<null>");
				} else {
					out.append(datum.toString());
				}
				out.append('\n');
			}

			private void printTree(StringBuffer out, boolean isRight,
					String indent) {
				if (right != null) {
					right.printTree(out, true, indent
							+ (isRight ? "        " : " |      "));
				}
				out.append(indent);
				if (isRight) {
					out.append(" /");
				} else {
					out.append(" \\");
				}
				out.append("----- ");
				printNodeValue(out);
				if (left != null) {
					left.printTree(out, false, indent
							+ (isRight ? " |      " : "        "));
				}
			}

			@Override
			public String toString() {
				return "" + datum;
			}

		}
	}

}
