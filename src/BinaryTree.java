/**
 * Created by Menelaos Kotsollaris on 4/1/2016. Contact: mkotsollari@gmail.com All rights Reserved.
 * <p> Class Description:
 */
public class BinaryTree<T extends Comparable<T>>
{
    protected BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> root)
    {
        this.root = root;
    }

    /**
     * In order traversal for a binary tree
     *
     * First priority is the leftmost child, then the parent and finally the rightmost node. For
     * more check here: https://en.wikipedia.org/wiki/Tree_traversal
     *
     * Complexity: O(N)
     *
     * FIXME DOES NOT work x1->x2 (added to the right)
     *
     * @return queue: the queue with the Level Order
     */
    public Queue<BinaryTreeNode<T>> inOrderTraversal()
    {
        Stack<BinaryTreeNode<T>> tempStack = new Stack<>();
        Queue<BinaryTreeNode<T>> wantedQueue = new Queue<>();
        BinaryTreeNode<T> currNode = root;
        boolean hasLeftChild, hasRightChild, hasBeenTraversed;
        do
        {
            hasBeenTraversed = hasBeenTraversed(wantedQueue, currNode);
            if(hasBeenTraversed)
            {
                wantedQueue.push(currNode);
                tempStack.pop();
            }
            else
            {
                hasRightChild = currNode.hasRightChild();
                hasLeftChild = currNode.hasLeftChild();
                if(hasRightChild)
                {
                    tempStack.pop();
                    tempStack.push(currNode.getRightChild());
                    tempStack.push(currNode);
                }
                if(hasLeftChild)
                {
                    tempStack.push(currNode.getLeftChild());
                }
                if(!hasLeftChild && !hasRightChild)
                {
                    wantedQueue.push(currNode);
                    tempStack.pop();
                }
            }
            if(tempStack.isEmpty()) break;
            currNode = tempStack.getTail().getElement();
        }
        while (currNode != null || !tempStack.isEmpty());
        return wantedQueue;
    }

    public void flush()
    {
        Queue<BinaryTreeNode<T>> wantedQueue = levelOrderTraversal();
        for(int i = 0; i < wantedQueue.getLength(); i++)
        {
            System.out.println(wantedQueue.get(i).getElement().getData());
        }
    }

    /**
     * @deprecated
     * Traverses the tree (by using inOrderTraversal) and then if it finds the node, it returns the
     * parent node; else it returns null.
     *
     * Complexity: O(N)
     *
     * TODO test + consider if it's worth using only inOrderTraversal() (it will be O(N)+O(N); TODO
     * TODO keep parent on Insert
     *
     * important: save parent while inserting.
     */
    public BinaryTreeNode<T> getParent(BinaryTreeNode<T> node)
    {
        Stack<BinaryTreeNode<T>> tempStack = new Stack<>();
        Queue<BinaryTreeNode<T>> wantedQueue = new Queue<>();
        BinaryTreeNode<T> currNode = root;
        boolean hasLeftChild, hasRightChild, hasBeenTraversed;
        do
        {
            hasBeenTraversed = hasBeenTraversed(wantedQueue, currNode);
            if(hasBeenTraversed)
            {
                wantedQueue.push(currNode);
                tempStack.pop();
            }
            else
            {
                if(currNode == null) return null;
                hasRightChild = currNode.hasRightChild();
                hasLeftChild = currNode.hasLeftChild();
                if(hasRightChild)
                {
                    tempStack.pop();
                    tempStack.push(currNode.getRightChild());
                    tempStack.push(currNode);
                }
                if(hasLeftChild)
                {
                    tempStack.push(currNode.getLeftChild());
                }
                if(currNode.containsChild(node)) return currNode;
                if(!hasLeftChild && !hasRightChild)
                {
                    wantedQueue.push(currNode);
                    tempStack.pop();
                }
            }
            if(tempStack.isEmpty()) break;
            currNode = tempStack.getTail().getElement();
        }
        while (currNode != null || !tempStack.isEmpty());
        return null;
    }

    /**
     * Returns if the node has been traversed in the past
     */
    private boolean hasBeenTraversed(Queue<BinaryTreeNode<T>> wantedQueue,
                                     BinaryTreeNode<T> parentNode)
    {
        ListNode<BinaryTreeNode<T>> currNode = wantedQueue.getHead();
        if(currNode == null) return false;
        do
        {
            if(parentNode.hasChild(currNode.getElement())) return true;
            currNode = currNode.getNext();
        }
        while (currNode != null);
        return false;
    }

    /**
     * In order Traversal for any type of tree
     * <p>
     * First priority are the parents, then the children.
     * For more check here: https://en.wikipedia.org/wiki/Tree_traversal
     *
     * @return queue: the queue with the Level Order
     */
    Queue<BinaryTreeNode<T>> levelOrderTraversal()
    {
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        Queue<BinaryTreeNode<T>> wantedQuery = new Queue<>();
        queue.push(root);
        BinaryTreeNode<T> currNode;
        while (!queue.isEmpty())
        {
            currNode = queue.getHead().getElement();
            if(currNode!= null && currNode.hasChildren())
            {
                queue.push(currNode.getChildrenListen());
            }
            wantedQuery.push(queue.getHead().getElement());
            queue.pop();
        }
        return wantedQuery;
    }
}
