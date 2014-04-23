package chapter04;

import base.QuestionBase;

public abstract class ChapterQuestionBase extends QuestionBase {

	@Override
	public String answersUrl() {
		return "https://code.google.com/p/ctci/source/browse/trunk/Java/Chapter+4";
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
		    
		    private void printTree(StringBuffer out, boolean isRight, String indent) {
		        if (right != null) {
		            right.printTree(out, true, indent + (isRight ? "        " : " |      "));
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
		            left.printTree(out, false, indent + (isRight ? " |      " : "        "));
		        }
		    }
		    
		    @Override
		    public String toString() {
		    	return "" + datum;
		    }
			
		}
	}

}
