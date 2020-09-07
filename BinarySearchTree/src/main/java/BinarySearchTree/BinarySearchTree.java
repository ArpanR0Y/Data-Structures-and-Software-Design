package BinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> {

  public class Node {

    public E value;
    Node leftChild = null;
    Node rightChild = null;

    public Node(E value) {
      this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
      if ((obj instanceof BinarySearchTree.Node) == false) {
        return false;
      }
      @SuppressWarnings("unchecked")
      Node other = (BinarySearchTree<E>.Node) obj;
      return other.value.compareTo(value) == 0 &&
          other.leftChild == leftChild && other.rightChild == rightChild;
    }
  }

  protected Node root = null;

  protected void visit(Node n) {
    System.out.println(n.value);
  }

  public boolean contains(E val) {
    return contains(root, val);
  }

  protected boolean contains(Node n, E val) {
    if (n == null) {
      return false;
    }

    if (n.value.equals(val)) {
      return true;
    } else if (n.value.compareTo(val) > 0) {
      return contains(n.leftChild, val);
    } else {
      return contains(n.rightChild, val);
    }
  }

  public boolean add(E val) {
    if (root == null) {
      root = new Node(val);
      return true;
    }
    return add(root, val);
  }

  protected boolean add(Node n, E val) {
    if (n == null) {
      return false;
    }
    int cmp = val.compareTo(n.value);
    if (cmp == 0) {
      return false; // this ensures that the same value does not appear more than once
    } else if (cmp < 0) {
      if (n.leftChild == null) {
        n.leftChild = new Node(val);
        return true;
      } else {
        return add(n.leftChild, val);
      }
    } else {
      if (n.rightChild == null) {
        n.rightChild = new Node(val);
        return true;
      } else {
        return add(n.rightChild, val);
      }
    }
  }

  public boolean remove(E val) {
    return remove(root, null, val);
  }

  protected boolean remove(Node n, Node parent, E val) {
    if (n == null) {
      return false;
    }

    if (val.compareTo(n.value) == -1) {
      return remove(n.leftChild, n, val);
    } else if (val.compareTo(n.value) == 1) {
      return remove(n.rightChild, n, val);
    } else {
      if (n.leftChild != null && n.rightChild != null) {
        n.value = maxValue(n.leftChild);
        remove(n.leftChild, n, n.value);
      } else if (parent == null) {
        root = n.leftChild != null ? n.leftChild : n.rightChild;
      } else if (parent.leftChild == n) {
        parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
      } else {
        parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
      }
      return true;
    }
  }

  protected E maxValue(Node n) {
    if (n.rightChild == null) {
      return n.value;
    } else {
      return maxValue(n.rightChild);
    }
  }


  /**
   * Method #1.
   * <p>
   * Given a value that is stored in the BST, it returns the corresponding Node that holds it. If
   * the value does not exist in this BST, this method should return null.
   */
  public Node findNode(E val) {
    if (val != null && this.contains(val)) {
      return findNode(this.root, val);
    } else {
      return null;
    }
  }

  protected Node findNode(Node n, E val) {
    if (n.value.equals(val)) {
      return n;
    } else if (n.value.compareTo(val) > 0) {
      return findNode(n.leftChild, val);
    } else {
      return findNode(n.rightChild, val);
    }
  }

  /**
   * Method #2.
   * <p>
   * Given a value, this method should return the “depth” of its Node, which is the number of
   * ancestors between that node and the root, including the root but not the node itself.
   * <p>
   * The depth of the root is defined to be 0; the depth of its two children (if any) is defined to
   * be 1; the depth of the root’s grandchildren (if any) is defined to be 2; and so on.
   * <p>
   * If the value is null or does not exist in this BST, this method should return -1.
   */
  public int depth(E val) {
    if (val != null && this.contains(val)) {
      return depth(this.root, val, 0);
    } else {
      return -1;
    }
  }

  protected int depth(Node n, E val, int depth) {
    if (n.value.equals(val)) {
      return depth;
    } else if (n.value.compareTo(val) > 0) {
      depth++;
      return depth(n.leftChild, val, depth);
    } else {
      depth++;
      return depth(n.rightChild, val, depth);
    }
  }

  /**
   * Method #3.
   * <p>
   * Given a value, this method should return the “height” of its Node, which is the greatest number
   * of nodes between that node and any descendant node that is a leaf, including the leaf but not
   * the node itself.
   * <p>
   * The height of a leaf node (i.e., one which has no children) is defined to be 0.
   * <p>
   * If the input value is null or does not exist in this BST, this method should return -1.
   */
  public int height(E val) {
    if (val != null && this.contains(val)) {
      return maxDepth(this.findNode(val)) - 1;
    } else {
      return -1;
    }
  }

  protected int maxDepth(Node n) {
    if (n == null) {
      return (0);
    } else {
      int lDepth = maxDepth(n.leftChild);
      int rDepth = maxDepth(n.rightChild);

      // use the larger + 1
      return (Math.max(lDepth, rDepth) + 1);
    }
  }


  /**
   * Method #4.
   * <p>
   * Given a Node, return true if the absolute value of the difference in heights of its left and
   * right children is 0 or 1, and return false otherwise.
   * <p>
   * If the Node is null or does not exist in this BST, this method should return false.
   */
  public boolean isBalanced(Node n) {
    if (n != null && this.contains(n.value)) {
      return this.heightDiff(n) == 0 || this.heightDiff(n) == 1;
    }

    return false;
  }

  protected int heightDiff(Node n) {
    int lDepth = maxDepth(n.leftChild);
    int rDepth = maxDepth(n.rightChild);

    return Math.abs(lDepth - rDepth);
  }

  /**
   * Method #5.
   * <p>
   * returns true if isBalanced(Node) returns true for all Nodes in the tree.
   * <p>
   * a tree with root n is balanced if:
   * n is balanced &&
   * left subtree of n is balanced &&
   * right subtree of n is balanced
   * <p>
   * This method then allows the user of the BST to determine whether the BST is balanced. Note that
   * the root being balanced does not imply that the entire tree is balanced
   */
  public boolean isBalanced() {
    return this.areAllBalanced(root);
  }

  protected boolean areAllBalanced(Node n) {
    if (n == null) {
      return false;
    }

    boolean result = isBalanced(n);

    if (n.leftChild != null) {
      result = result && areAllBalanced(n.leftChild);
    }

    if (n.rightChild != null) {
      result = result && areAllBalanced(n.rightChild);
    }

    return result;
  }
}
