/**
 * Created by Menelaos Kotsollaris on 3/27/2016.
 * Contact: mkotsollari@gmail.com
 * All rights Reserved.
 * <p>
 * Class Description:
 */
public class Tree<T>
{
    private TreeNode<T> root;

    public Tree(TreeNode<T> root)
    {
        this.root = root;
    }

    public void add(TreeNode<T> parentNode, TreeNode<T> childNode)
    {
        parentNode.addChild(childNode);
    }

    public boolean remove(TreeNode<T> parentNode, TreeNode<T> childNode)
    {
        return parentNode.removeChild(childNode);
    }

    /**
     * Pre order traversal for a binary tree
     * <p>
     * First priority are the left nodes, then the right nodes.
     * For more check here: https://en.wikipedia.org/wiki/Tree_traversal
     *
     * @return queue: the queue with the Level Order
     */
    public Queue<TreeNode<T>> preOrderTraversal()
    {
        Stack<TreeNode<T>> tempStack = new Stack<>();
        Queue<TreeNode<T>> wantedQuery = new Queue<>();
        TreeNode<T> currNode = root;
        tempStack.push(currNode);
        while (!tempStack.isEmpty())
        {
            LinkedList<TreeNode<T>> childrenLinkedList;
            if(currNode.hasChildren())
            {
                childrenLinkedList = currNode.getChildren().getInverse();
                tempStack.push(childrenLinkedList);
            }
            wantedQuery.push(currNode);
            tempStack.remove(currNode);
            if(!tempStack.isEmpty()) currNode = tempStack.getTail().getElement();
        }
        return wantedQuery;
    }

    /**
     * Post Order traversal for a binary tree
     * <p>
     * First priority are the children (left and then right node) and then the parents.
     * For more check here: https://en.wikipedia.org/wiki/Tree_traversal
     *
     * @return queue: the queue with the Level Order
     */
    public Queue<TreeNode<T>> postOrderTraversal()
    {
        Stack<TreeNode<T>> tempStack = new Stack<>();
        Queue<TreeNode<T>> wantedQuery = new Queue<>();
        TreeNode<T> currNode = root;
        tempStack.push(currNode);
        while (!tempStack.isEmpty())
        {
            LinkedList<TreeNode<T>> childrenLinkedList;
            if(currNode.hasChildren())
            {
                //is parent of recently removed
                if(wantedQuery.getTail() != null && currNode.isParent(wantedQuery.getTail().getElement()))
                {
                    wantedQuery.push(currNode);
                    tempStack.remove(currNode);
                }
                else
                {
                    childrenLinkedList = currNode.getChildren().getInverse();
                    tempStack.push(childrenLinkedList);
                }
            }
            else
            {
                wantedQuery.push(currNode);
                tempStack.remove(currNode);
            }
            if(!tempStack.isEmpty()) currNode = tempStack.getTail().getElement();
        }
        return wantedQuery;
    }
}