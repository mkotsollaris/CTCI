/**
 * Created by Menelaos Kotsollaris on 4/12/2016. Contact: mkotsollari@gmail.com All rights
 * Reserved.
 *
 * Class Description:
 */
public class Graph<T>
{
    private ArrayList<TreeNode<T>> treeNodes;
    private Class<TreeNode<T>> type;

    public Graph(Class<T> type)
    {
        this.type = (Class<TreeNode<T>>) new TreeNode<>().getClass();
        treeNodes = new ArrayList<>(this.type);
    }

    public void add(TreeNode<T> parent, TreeNode<T> child)
    {
        if(parent != null) parent.addChild(child);
        else treeNodes.add(child);
    }

    public void remove(TreeNode<T> node)
    {
        for(int i = 0; i < treeNodes.length(); i++)
        {
            if(treeNodes.get(i) == node) treeNodes.remove(treeNodes.get(i));
        }
    }

    public void flush()
    {
        for(int i = 0; i < treeNodes.length(); i++)
        {
            TreeNode<T> parent = treeNodes.get(i);
            System.out.println(parent.getData());
            if(parent.hasChildren())
            {
                LinkedList<TreeNode<T>> children = parent.getChildren();
                for(int j = 0; j < children.length; j++)
                {
                    System.out.println(children.get(j).getElement().getData());
                }
            }
        }
    }
}
