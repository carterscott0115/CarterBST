public class Node<T extends Comparable<T>> {
    private Node leftChild;
    private Node rightChild;
    private T value;
public Node(Node leftChild, Node rightChild, T value) {
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    this.value = value;
}
public Node(T value) {
    this.value = value;
}
    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
