package DFS_BFS;

import java.util.List;

public class N_559 {
    static int max;
    static class Node {
        public int val;
        public List<Node> children;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        max = 0;
        if (root == null) return max;
        dfs(root, 1);
        return max;
    }

    public static void dfs(Node cur, int depth) {
        if (cur.children.isEmpty()) {
            if (depth > max) {
                max = depth;
            }
            return;
        }

        for (Node next : cur.children) {
            dfs(next, depth + 1);
        }
    }
}
