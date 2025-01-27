
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(25);
        bst.insert(26);
        bst.insert(75);
        bst.insert(1);
        bst.insert(5);
        System.out.println(bst.remove(51));
        System.out.println(bst.contains(75));
        System.out.println(bst.getMin());
        System.out.println();
    }

}