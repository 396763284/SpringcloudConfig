package learn.structure.BTree;

public class Node {
     Object value;
     Node left;
     Node right;
    public Node(Object value, Node left, Node right){
        super();
        this.value=value;
        this.left=left;
        this.right=right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
