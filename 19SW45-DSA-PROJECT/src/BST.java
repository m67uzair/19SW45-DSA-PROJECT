public class BST {
	private int height;
	private Entry root = new Entry();;
	private BST left = NIL, right = NIL;
	public static final BST NIL = new BST();

	public BST(String phoneNo, String value) {
		this.root.key = phoneNo;
		this.root.value = value;
		left = right = NIL;
	}

	public BST(Entry root) {
		this.root = root;
		left = right = NIL;
	}

	public BST(Entry root, BST left, BST right) {
		this.root = root;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}

	public BST() {
		left = right = this;
		height = -1;
	}

	class Entry {
		String key;
		Object value;
		String address;

		Entry(String k, Object v) {
			key = k;
			value = v;
		}

		public Entry() {
		}
	}

	public Object getRoot() {
		return root.value;
	}

	public BST getLeft() {
		return left;
	}

	public BST getRight() {
		return right;
	}

	public Object setRoot(Entry root) {

		Object oldroot = this.root;
		this.root = root;
		return oldroot;
	}

	public BST setLeft(BST left) {

		BST oldleft = this.left;
		this.left = left;
		return oldleft;
	}

	public BST setRight(BST right) {

		BST oldright = this.right;
		this.right = right;
		return oldright;
	}

	public String toString() {

		StringBuffer buf = new StringBuffer("");
		if (left != NIL)
			buf.append(left + ",");
		if (root != null)
			buf.append(root.value);
		if (right != NIL)
			buf.append("," + right);
		return buf + "";
	}

	public String preorder() {

		StringBuffer buf = new StringBuffer("");

		if (root != null && root.value != null)
			buf.append("Name: " + root.key + "\nNumber: " +" "+root.value + "\n");
		if (left != NIL)
			buf.append(left.preorder());
		if (right != NIL)
			buf.append(right.preorder());
		return buf + "";
	}

	public String postorder() {

		StringBuffer buf = new StringBuffer("");
		if (left != null)
			buf.append(left.postorder());
		if (right != null)
			buf.append(right.postorder());
		buf.append(root);
		return buf + "";
	}

	public boolean isLeaf() {
		if (left == NIL && right == NIL)
			return true;
		return false;
	}

	/*
	 * public String size() { if (left == null && right == null) return 1; if (left ==
	 * null) return 1 + right.size(); if (right == null) return 1 + left.size();
	 * return 1 + left.size() + right.size(); }
	 */
//	public String size() {
//		if (this == NIL)
//			return 0;
//		return 1 + left.size() + right.size();
//	}

	public boolean contains(Object obj) {
		if (root.value.equals(obj) )
			return true;
		boolean containing = false;
		if (left != NIL) {
			if (left.contains(obj))
				containing = true;
		}
		if (right != NIL) {
			if (right.contains(obj))
				containing = true;
		}
		return containing;
	}

	public boolean contains(String obj) {
		if (root.key.equals(obj) )
			return true;
		boolean containing = false;
		if (left != NIL) {
			if (left.contains(obj))
				containing = true;
		}
		if (right != NIL) {
			if (right.contains(obj))
				containing = true;
		}
		return containing;
	}

	public void insert(String key, String value) {
		// String oldSize = size();
		grow(key, value);
		// return size() > oldSize;
	}

	public BST grow(String key, String value) {
		if (this.equals(NIL) )
			return new BST(key, value);
		if (key.equals(this.root.key) )
			return this; // avoid key duplication
		if (key.compareTo(this.root.key) == 1)
			left = left.grow(key, value);
		else
			right = right.grow(key, value);
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

	public Entry retrieve(BST tree, String key) {
		if (tree.equals(NIL) )
			return null;
		if (key.compareTo(this.root.key) == -1) {
			root.address = (String) root.value;
			return left.retrieve(tree, key);
		}
		if (key.compareTo(this.root.key) == 1) {
			root.address = (String) root.value;
			return right.retrieve(tree, key);
		}
		return root;
	}

	public BST deleteMin(BST st) {

		if (st.left == NIL) {
			BST p = new BST(st.root);
			st.root = st.right.root;
			st.right = st.right.right;
			return p;
		}
		if (st.left.isLeaf()) {
			BST p = new BST(st.left.root);
			st.left = st.left.left;
			return p;
		}

		return deleteMin(st.left);
	}

	public boolean delete(BST t, String key) {
		if (root.value.equals(null))
			return false;

		if (key.compareTo(this.root.key) == -1)
			return delete(t.left, key);

		if (key.compareTo(this.root.key) == 1)
			return delete(t.right, key);

		if (t.isLeaf()) {
			t.root = null;
			return true;
		}
		if (t.right == NIL) {
			t.root = t.left.root;
			t.right = t.left.right;
			t.left = t.left.left;
			return true;
		}
		if (t.left == NIL) {
			t.root = t.right.root;
			t.left = t.right.left;
			t.right = t.right.right;
			return true;
		}
		BST b1 = deleteMin(t.right);

		t.root = b1.root;

		return true;
	}

}