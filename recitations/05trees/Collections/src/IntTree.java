
public class IntTree {
	class IntTreeNode {
		int value;
		IntTreeNode left;
		IntTreeNode right;

		IntTreeNode(int value) {
			this.value = value;
		}

		boolean contains(int v) {
			if(v == value) {
				return true;
			}
			else if (v < value) {
				return left !=null && left.contains(v);
			}
			else {
				return right != null && right.contains(v);
			}
		}

		void add(int v) {
			if (v == value) {
				return;
			} else if (v < value && left != null) {
				left.add(v);
			} else if (v < value) {
				left = new IntTreeNode(v);
			} else if (v > value && right != null) {
				right.add(v);
			} else {
				right = new IntTreeNode(v);
			}
		}

		int size() {
			int size = 1;
			if (left != null) {
				size += left.size();
			}
			if (right != null) {
				size += right.size();
			}
			return size;
		}

	}

	private IntTreeNode head;

	public void add(int v) {
		if (head == null) {
			head = new IntTreeNode(v);
		} else {
			head.add(v);
		}
	}

	public int size() {
		if (head == null) {
			return 0;
		}
		return head.size();
	}

	public boolean contains(int v) {
		return head != null && head.contains(v);
	}

}
