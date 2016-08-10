import java.lang.reflect.Array;

/**
 * Created by Menelaos Kotsollaris on 4/1/2016. Contact: mkotsollari@gmail.com All rights Reserved.
 *
 * Class Description:
 *
 * The Binary Node has maximum 2 children whereas a TreeNode has infinite number of children.
 *
 * Choosing not to extend from the TreeNode seems better since it would probably lead to hackish
 * code by probably adding an extra field of 'Left' and 'Right' type of Node.
 */
public class BinaryTreeNode<T extends Comparable<T>>
{
    private T data;
    private BinaryTreeNode<T>[] childrenArray;
    private BinaryTreeNode<T> parent;

    public BinaryTreeNode(Class<T> type, T data)
    {
        childrenArray = (BinaryTreeNode<T>[]) Array.newInstance(BinaryTreeNode.class, 2);
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public int compare(T b)
    {
        return this.getData().compareTo(b);
    }

    /**
     * First tries to addChild in the left element and then tries the right
     *
     * @param binaryNode: the new node
     */
    public boolean add(BinaryTreeNode<T> binaryNode)
    {
        if(childrenArray[0] == null)
        {
            parent = this;
            childrenArray[0] = binaryNode;
            return true;
        }
        else if(childrenArray[1] == null)
        {
            parent = this;
            childrenArray[1] = binaryNode;
            return true;
        }
        return false;
    }


    /**
     * Makes the index from the childrenArray equals to null
     *
     * @return true or false if the deleteChild occurred
     */
    public boolean deleteChild(int index)
    {
        if(index < 0 || index > 1) return false;
        if(childrenArray[index] == null) return false;
        childrenArray[index] = null;
        return true;
    }

    /**
     * Makes the 0 index (left child) from the childrenArray equals to null
     *
     * @return true or false if the deleteChild occurred
     */
    public boolean removeLeftChild()
    {
        if(childrenArray[0] == null) return false;
        childrenArray[0] = null;
        return true;
    }

    /**
     * Makes the 1 index (right child) from the childrenArray equals to null
     *
     * @return true or false if the deleteChild occurred
     */
    public boolean removeRightChild()
    {
        if(childrenArray[1] == null) return false;
        childrenArray[1] = null;
        return true;
    }

    public boolean hasLeftChild()
    {
        return childrenArray[0] != null;
    }

    public boolean hasRightChild()
    {
        return childrenArray[1] != null;
    }

    public boolean hasRelation(BinaryTreeNode<T> currNode)
    {
        return (currNode.hasChild(this) || this.hasChild(currNode));
    }

    public boolean hasChild(BinaryTreeNode<T> binaryTreeNode)
    {
        return (childrenArray[0] == binaryTreeNode || childrenArray[1] == binaryTreeNode);
    }

    public BinaryTreeNode<T> getRightChild()
    {
        return childrenArray[1];
    }

    public BinaryTreeNode<T> getLeftChild()
    {
        return childrenArray[0];
    }

    public BinaryTreeNode<T>[] getChildren()
    {
        return childrenArray;
    }

    public boolean containsChild(BinaryTreeNode<T> node)
    {
        for(int i = 0; i < this.childrenArray.length; i++)
        {
            if(this.childrenArray[i] == node) return true;
        }
        return false;
    }

    public boolean hasChildren()
    {
        return (childrenArray[0] != null || childrenArray[1] != null);
    }

    public void addLeftChild(BinaryTreeNode<T> child)
    {
        this.childrenArray[0] = child;
    }

    public void addRightChild(BinaryTreeNode<T> child)
    {
        this.childrenArray[1] = child;
    }

    public LinkedList<BinaryTreeNode<T>> getChildrenListen()
    {
        LinkedList<BinaryTreeNode<T>> linkedList = new LinkedList<>();
        if(childrenArray[0] != null)linkedList.addToTail(childrenArray[0]);
        if(childrenArray[1] != null)linkedList.addToTail(childrenArray[1]);
        return linkedList;
    }

    public BinaryTreeNode<T> getParent()
    {
        return parent;
    }
}
