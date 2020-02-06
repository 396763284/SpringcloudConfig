package learn.structure.BTree;

public class TestClient {
    public static void main(String[] args) {
        // 创建 二叉树
        Node node7=new Node(7,null,null);
        Node node6=new Node(6,null,node7);
        Node node3=new Node(3,null,null);
        Node node2=new Node(2,node3,node6);
        Node node5=new Node(5,null,null);
        Node node4=new Node(4,null,node5);
        Node node1=new Node(1,node4,node2);

        LinkedBinaryTree tree=new LinkedBinaryTree(node1);

        // 判断是否为空
        System.out.println(tree.isEmpty());

        System.out.println(tree.getHeight());

        System.out.println(tree.size());

        System.out.println(tree.findKye(3));
        // 先序递归
        tree.preOrderTraverse();
        // 中序递归
        tree.inOrderTraverse();
        // 后续递归
        tree.postOrderTraverse();



        // 先序遍历 （栈）
        tree.preOrderByStack();
        tree.inOrderByStack();
        // 中序遍历 （栈）
        // 后序遍历 （栈）
        tree.postOrderByStack();

        // 层次遍历 （队列）


    }
}
