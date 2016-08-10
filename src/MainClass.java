import java.util.*;

/**
 * Created by Menelaos Kotsollaris on 2/25/2016. Contact: mkotsollari@gmail.com
 * All rights Reserved.
 *
 * Class Explanation:  TODO
 */
public class MainClass
{
    public static void main(String[] args)
    {
        TreeNode<String> treeNode1 = new TreeNode<>("x1");
        TreeNode<String> treeNode2 = new TreeNode<>("x2");
        TreeNode<String> treeNode3 = new TreeNode<>("x3");
        TreeNode<String> treeNode4 = new TreeNode<>("x4");
        TreeNode<String> treeNode5 = new TreeNode<>("x5");
        TreeNode<String> treeNode6 = new TreeNode<>("x6");
        TreeNode<String> treeNode7 = new TreeNode<>("x7");
        TreeNode<String> treeNode8 = new TreeNode<>("x8");
        Graph<String> graph = new Graph<>(String.class);
        graph.add(null, treeNode1);
        graph.add(treeNode1, treeNode2);
        graph.flush();
    }
}