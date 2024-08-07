package collection.binaryTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode parent;
    List<TreeNode> children;

    TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class NaiveLCA {
    public static TreeNode findLCA(TreeNode node1, TreeNode node2) {
        List<TreeNode> path1 = findPathToRoot(node1);
        List<TreeNode> path2 = findPathToRoot(node2);

        int i = path1.size() - 1;
        int j = path2.size() - 1;

        while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }

        return path1.get(i + 1);
    }

    private static List<TreeNode> findPathToRoot(TreeNode node) {
        List<TreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}
