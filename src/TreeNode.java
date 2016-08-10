/**
 * Created by Menelaos Kotsollaris on 3/27/2016. Contact: mkotsollari@gmail.com All rights Reserved.
 * <p> Class Description:
 */
public class TreeNode<T>
{
    private T data;
    private LinkedList<TreeNode<T>> childrenLinkedList;
    private LinkedList<TreeNode<T>> parentLinkedList;//FIXME addChild parents too
    private boolean visited;//needed for the implementation of algorithms such as BFS, DFS etc.

    public TreeNode()
    {
        childrenLinkedList = new LinkedList<>();
    }

    public TreeNode(T data)
    {
        this.data = data;
        childrenLinkedList = new LinkedList<>();
        parentLinkedList = new LinkedList<>();
    }

    public void addChild(TreeNode<T> data)
    {
        childrenLinkedList.addToTail((data));
    }

    public void addParent(TreeNode<T> data)
    {
        parentLinkedList.addToTail((data));
    }

    public boolean removeParent(TreeNode<T> treeNode)
    {
        return childrenLinkedList.remove(treeNode);
    }

    public boolean removeChild(TreeNode<T> treeNode)
    {
        return childrenLinkedList.remove(treeNode);
    }

    public LinkedList<TreeNode<T>> getChildren()
    {
        return childrenLinkedList;
    }

    public boolean hasChildren()
    {
        return (childrenLinkedList.length > 0);
    }

    public T getData()
    {
        return data;
    }

    /**
     * Returns true if treeNode is Child
     **/
    public boolean isChild(TreeNode<T> element)
    {
        return element.childrenLinkedList.find(this);
    }

    /**
     * Returns true if treeNode is Child
     **/
    public boolean isParent(TreeNode<T> element)
    {
        return this.childrenLinkedList.find(element);
    }

    public boolean isRelationship(TreeNode<T> element)
    {
        return (isParent(element) || isChild(element));
    }


}