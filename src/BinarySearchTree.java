import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node searchTree;
    /**
     * Insert a new value into the BST
     * @param value The value to insert
     */
    public void insert(T value) {
        if(value == null) {
            return;
        }
        if(searchTree == null) {
            searchTree = new Node(value);
            return;
        }
        Node currentNode = searchTree;

        while(true) {
                if (currentNode.getLeftChild() == null && currentNode.getValue().compareTo(value) > 0) {
                    currentNode.setLeftChild(new Node(value));
                    return;
                }
            if(currentNode.getRightChild() == null && currentNode.getValue().compareTo(value) < 0) {
                currentNode.setRightChild(new Node(value));
                return;
            }
            else if(currentNode.getValue().compareTo(value) < 0) {
                currentNode = currentNode.getRightChild();
            }
            else if(currentNode.getValue().compareTo(value) > 0) {
                currentNode = currentNode.getLeftChild();
            }
            }
        }
        // TODO: Implement insertion logic


    /**
     * Remove a value from the BST
     * @param value The value to remove
     * @return true if value was found and removed, false otherwise
     */
    public boolean remove(T value) {
        if(value == null) {
            return false;
        }
        if(value.equals(searchTree.getValue())) {
            return true;
        }
        Node currentNode = searchTree;
        while(currentNode.getRightChild() != null || currentNode.getLeftChild() != null) {

            if(currentNode.getRightChild().getValue().equals(value)) {

                currentNode.setRightChild(null);
                return true;
            }

            if(currentNode.getLeftChild().getValue().equals(value)) {
                currentNode.setLeftChild(null);
                return true;
            }

          if(currentNode.getValue().compareTo(value) < 0 && currentNode.getRightChild() != null) {
                currentNode = currentNode.getRightChild();
              System.out.println("right child");
            }

             if(currentNode.getValue().compareTo(value) > 0 && currentNode.getLeftChild() != null) {
                currentNode = currentNode.getLeftChild();
                 System.out.println("left child");
            }
        }
        return false;
    }

    /**
     * Search for a value in the BST
     * @param value The value to search for
     * @return true if value exists in the tree, false otherwise
     */
    public boolean contains(T value) {
        // TODO: Implement search logic
            if(value == null) {
                return false;
            }
            if(value.equals(searchTree.getValue())) {
                return true;
            }
            Node currentNode = searchTree;
            while(currentNode.getRightChild() != null || currentNode.getLeftChild() != null) {

                if(currentNode.getRightChild().getValue().equals(value)) {
                    return true;
                }

                if(currentNode.getLeftChild().getValue().equals(value)) {
                    return true;
                }

                if(currentNode.getValue().compareTo(value) < 0 &&  currentNode.getRightChild() != null) {
                    currentNode = currentNode.getRightChild();
                }

                if(currentNode.getValue().compareTo(value) > 0 &&  currentNode.getLeftChild() != null) {
                    currentNode = currentNode.getLeftChild();
                }
            }
            return false;
        }


    /**
     * Get the minimum value in the BST
     * @return The minimum value, or null if tree is empty
     */
    public T getMin() {
        Node currentNode = searchTree;
        while(currentNode.getLeftChild() != null) {
            currentNode = currentNode.getLeftChild();
        }
        return (T) currentNode.getValue();
    }

    /**
     * Get the maximum value in the BST
     * @return The maximum value, or null if tree is empty
     */
    public T getMax() {
        // TODO: Implement getMax logic
        Node currentNode = searchTree;
        while(currentNode.getRightChild() != null) {
            currentNode = currentNode.getRightChild();
        }
        return (T) currentNode.getValue();
    }


    /**
     * Perform an inorder traversal of the BST
     * @return A list containing the values in inorder
     */
    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        return inorderHelper(searchTree, result);
    }

    private List<T> inorderHelper(Node node, List<T> result) {
        if (node == null) {
            return null;
        }
        inorderHelper(node.getLeftChild(), result);
        result.add((T) node.getValue());
        inorderHelper(node.getRightChild(), result);
        return result;
    }


    /**
     * Perform a preorder traversal of the BST
     * @return A list containing the values in preorder
     */
    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<>();
        return preorderHelper(searchTree, result);
    }

    private List<T> preorderHelper(Node node, List<T> result) {
        if (node == null) {
            return null;
        }
        result.add((T) node.getValue());
        preorderHelper(node.getLeftChild(), result);
        preorderHelper(node.getRightChild(), result);
        return result;
    }

    /**
     * Perform a postorder traversal of the BST
     * @return A list containing the values in postorder
     */
    public List<T> postorderTraversal() {
        List<T> result = new ArrayList<>();
        return postorderHelper(searchTree, result);
    }

    private List<T> postorderHelper(Node node, List<T> result) {
        if (node == null) {
            return null;
        };
        postorderHelper(node.getLeftChild(), result);
        postorderHelper(node.getRightChild(), result);
        result.add((T) node.getValue());
        return result;
    }

    /**
     * Get the height of the BST
     * @return The height of the tree (-1 for empty tree)
     */
    public int getHeight() {
        // TODO: Implement height calculation
        int counter = 0;
        Node currentNode = searchTree;
        return sinkII(currentNode, counter);

    }

    public int sinkII(Node n, int count) {
        if(n.getLeftChild() != null) {
            n = n.getLeftChild();
            count++;
            sinkII(n, count);
            System.out.println("count increased left side!");
        }
        if(n.getRightChild() != null) {
            n = n.getLeftChild();
            count++;
            sinkII(n, count);
            System.out.println("count increased right side!");
        }
        return count;
    }
    /**
     * Get the size (number of nodes) in the BST
     * @return The total number of nodes
     */
    public int getSize() {
        // TODO: Implement size calculation
        int counter = 0;
        Node currentNode = searchTree;
        return sink(currentNode, counter);
    }

    public int sink(Node n, int count) {
        count++;
        int counter;
        if(n.getLeftChild() != null) {
            n = n.getLeftChild();
            counter = sink(n, count);
            return counter;
        }
        if(n.getRightChild() != null) {
            n = n.getRightChild();
            counter = sink(n, count);
            return counter;
        }
            return count;
    }

    /**
     * Check if the BST is empty
     * @return true if the tree has no nodes, false otherwise
     */
    public boolean isEmpty() {
      if(searchTree == null) {
          return true;
      }
      else {
          return false;
      }
    }

    /**
     * Clear all nodes from the BST
     */
    public void clear() {
        searchTree = null;
    }

    //Should return true if adheres to BST rules, false if otherwise
    public boolean isValidBST() {
        Node node = searchTree;
        return valid(node);

    }
    public boolean valid(Node node) {
        if(node.getLeftChild() != null) {
            node = node.getLeftChild();
            valid(node);
            if(node.getLeftChild() != null && node.getLeftChild().getValue().compareTo(node.getValue()) > 0) {
                return false;
            }
        }
        if(node.getRightChild() != null) {
            node = node.getRightChild();
            valid(node);
            if(node.getLeftChild() != null && node.getLeftChild().getValue().compareTo(node.getValue()) < 0) {
                return false;
            }
        }
        return true;
    }
}
