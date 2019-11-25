package learn.structure.BTree;

public class LinkedBinaryTree implements BinaryTree {

    private Node node;

    public LinkedBinaryTree(Node node){
        this.node=node;
    }

    @Override
    public boolean isEmpty() {
        return node.value==null?true:false;
    }

    @Override
    public int size() {
        System.out.println("节点数");
        return size(node);
    }
    private int size(Node node){
        if(node!=null){
            return size(node.left)+size(node.right)+1;
        }else{
            return 0;
        }
    }

    @Override
    public int getHeight() {
        System.out.println("高度");
        return getHeight(node);
    }

    private int getHeight(Node node){
        if(node!=null){
            return getHeight(node.left)>getHeight(node.right)? getHeight(node.left)+1:getHeight(node.right)+1;
        }else {
            return 0;
        }

    }

    @Override
    public Node findKye(int value) {
        return findKey(value,node);
    }

    private Node findKey(Object value, Node node){
        if(node==null){
            return null;
        }else if(node.value==value){
            return node;
        }else{
            Node left = findKey(value,node.left);
            Node right=findKey(value,node.right);
            if(right!=null&&right.value==value){
                return right;
            }else if(left!=null&&left.value==value){
                return left;
            }else {
                return null;
            }
        }
    }

    @Override
    public void preOrderTraverse() {
        System.out.println("先序递归开始");
        preOrderTraverse(node);
        System.out.println();
        System.out.println("先序递归结束");
    }

    private void preOrderTraverse(Node node){
        if(node!=null){
            //输出根节点的值
            System.out.print(node.value);
            //输出左节点的值
            preOrderTraverse(node.left);
            //输出右节点的值
            preOrderTraverse(node.right);
        }
    }

    @Override
    public void inOrderTraverse() {
        System.out.println("中序递归开始");
        inOrderTraverse(node);
        System.out.println();
        System.out.println("中序递归结束");
    }

    private void inOrderTraverse(Node node){
        if(node!=null){
            inOrderTraverse(node.left);
            System.out.print(node.value);
            inOrderTraverse(node.right);
        }
    }


    @Override
    public void postOrderTraverse() {
        System.out.println("后续递归开始");
        postOrderTraverse(node);
        System.out.println();
        System.out.println("后续递归结束");
    }

    private void postOrderTraverse(Node node){
        if(node!=null){
            //输出左
            postOrderTraverse(node.left);
            //输出右
            postOrderTraverse(node.right);
            //输出根节点的值
            System.out.print(node.value);
        }
    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void inOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }
}
