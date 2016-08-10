/**
 * Created by Menelaos Kotsollaris on 4/10/2016. Contact: mkotsollari@gmail.com All rights
 * Reserved.
 *
 * Class Description: A complete Binary Tree where each node is smaller than its children
 */
public class MinHeap<T extends Comparable<T>> extends BinaryTree<T>
{
    private Class<T> type;
    private BinaryTreeNode<T> rightMostParent;

    public MinHeap(Class<T> type, T data)
    {
        super(new BinaryTreeNode<>(type, data));
        this.type = type;
        rightMostParent = this.root;
    }

    public void add(T element)
    {
        BinaryTreeNode<T> leftChild = rightMostParent.getLeftChild();
        boolean leftNodeInserted = false;
        if(leftChild == null)
        {
            leftNodeInserted = true;
        }
        else
        {
            rightMostParent.add(new BinaryTreeNode<>(type, element));
        }
        rightMostParent.add(new BinaryTreeNode<>(type, element));
        if(!leftNodeInserted) rebalance(rightMostParent.getRightChild());
    }

    /**
     * As explained in page 104. Returns the minimum extracted value. Null in case of empty MinHeap
     *
     * TODO test
     */
    public BinaryTreeNode<T> extractMin()
    {
        BinaryTreeNode<T> wantedNode = root;
        BinaryTreeNode<T> currNode = root;
        if(currNode == null) return null;
        do
        {
            BinaryTreeNode<T> leftChild = currNode.getLeftChild();
            BinaryTreeNode<T> rightChild = currNode.getRightChild();
            BinaryTreeNode<T> minNode;
            if(leftChild.getData().compareTo(rightChild.getData()) == 1)
            {
                minNode = rightChild;
            }
            else
            {
                minNode = leftChild;
            }
            swap(currNode, minNode);
            currNode = minNode;
        }
        while (currNode.hasChildren());
        //TODO removeChild the node.

        return wantedNode;
    }

    /**
     * Swap parent with child if child's value is less than parent's
     *
     * TODO test
     */
    private boolean rebalance(BinaryTreeNode<T> newChild)
    {
        BinaryTreeNode<T> parent;
        do
        {
            parent = newChild.getParent();
            if(parent!=null && parent.compare(newChild.getData()) == 1)
            {
                if(newChild == rightMostParent) rightMostParent = parent;
                swap(parent, newChild);
            }
        }
        while (parent != null);
        return false;
    }

    private void swap(BinaryTreeNode<T> parent, BinaryTreeNode<T> newChild)
    {
        T parentData = parent.getData();
        parent.setData(newChild.getData());
        newChild.setData(parentData);
    }
}
