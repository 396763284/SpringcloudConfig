package learn.structure.BTree;

public interface BinaryTree {

    public boolean isEmpty();

    public int size();

    public int getHeight();

    public Node findKye(int value);

    /**
     * 前序遍历
     */
    public void preOrderTraverse();

    /**
     * 中序遍历
     */
    public void inOrderTraverse();

    /**
     * 后序遍历
     */
    public void postOrderTraverse();

    public void preOrderByStack();

    public void inOrderByStack();

    public void postOrderByStack();

}
