package org.example.general;

import java.util.Stack;

public class BinaryTreesTheSame {
    static public class Node {

        private final int data;
        public Node left;
        public Node right;

        public Node(final int data){
            this.data = data;
        }
    }

    /**
     * Must be a stack
     * @param a
     * @param b
     * @return
     */
    public static boolean isTheSame(Node a, Node b) {
        // Add two stacks to help comparison
        Stack<Node> nodesOne = new Stack();
        Stack<Node> nodesTwo = new Stack();

        nodesTwo.push(a);
        nodesTwo.push(b);
        boolean isSame = false;
        while (!nodesTwo.empty() && !nodesTwo.empty()) {
            Node x = nodesTwo.pop();
            Node y = nodesTwo.pop();

            if (x.left !=null && y.left != null) {
                if (isSame)
                    return  true;
                nodesOne.push(x.left);
                nodesTwo.push(y.left);
            }
            else
                isSame = true;

            if (x.right !=null && y.right != null) {
                if (isSame)
                    return  true;
                nodesOne.push(x.right);
                nodesTwo.push(y.right);
            }
            else
            if ((x.right ==null &&  y.right != null) ||
                    (x.right !=null &&  y.left == null))
                return false;
            else
                isSame = true;
        }

        return isSame;
    }
}
