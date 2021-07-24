package preperationExamples;

class Node {
	public int value;
	public Node left, right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}


	public class BinarySearchTree {
//	public static boolean contains(Node root, int value) {
//
//		Node tempNode = root;
//
//		while (tempNode.value <= value && tempNode!=null) {
//			if (tempNode.value == value) {
//				return true;
//			}
//			if (value > tempNode.value) {
//				tempNode = tempNode.right;
//			} else {
//				tempNode = tempNode.left;
//			}
//
//		}
//
//		return false;
//	}
		
		public static boolean contains(Node root, int value) {
			if(root.value==value) {
				return true;
				
			}
			return contains(root.left, value);
		}
		

	public static void main(String[] args) {
		Node n1 = new Node(1, null, null);
		Node n3 = new Node(3, null, null);
		Node n2 = new Node(2, n1, n3);

		System.out.println(contains(n2, 3));
	}
}