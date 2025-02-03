
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(25);
        bst.insert(5);
        bst.insert(40);
        bst.insert(100);
        bst.insert(125);
        bst.insert(120);
        bst.insert(130);
        System.out.println();
        System.out.println(bst.getMin());
        System.out.println(bst.isValidBST());
        System.out.println(bst.getHeight());
    }

}