import java.util.Comparator;

public class GenericTree<V> {
	class Node<W>{
		W value;
		Node<W> left;
		Node<W> right;
		Comparator<W> c;
		
		Node(W value, Comparator<W> c){
			this.value = value;
			this.c = c;
		}
		
		boolean contains(W v) {
			 if(c.compare(value, v) == 0) {
				 return true;
			 }
			 else if (c.compare(value, v) < 0) {
				 return left != null && left.contains(v);
			 }
			 else {
				 return right != null && right.contains(v);
			 }
		}
		
		public void add(W v) {
			if(c.compare(value, v) == 0) {
				return;
			}
			else if (c.compare(value, v) < 0 && left != null) {
				left.add(v);
			}
			else if(c.compare(value, v) < 0) {
				left = new Node<W>(v,c);
			}
			else if(c.compare(value, v) > 0 && right != null) {
				right.add(v);
			}
			else {
				right = new Node<W>(v,c);
			}
		}
		
		
		
		
	}
	private Node<V> head;
	private Comparator<V> comparator;
	
	public GenericTree(Comparator<V> c){
		this.comparator = c;
	}
	
	public boolean contains(V v) {
		return head != null && head.contains(v);
	}
	
	public void add(V v) {
		if(head == null) {
			head = new Node<V>(v,comparator);
			return;
		}
		head.add(v);
	}
	
	
}
