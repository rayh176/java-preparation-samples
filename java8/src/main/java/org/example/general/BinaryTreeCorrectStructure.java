package org.example.general;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeCorrectStructure {

    public void viewStructure(Node node){
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(node);
        while(!nodes.isEmpty()) {
            Node n = nodes.poll();
            if (n.left != null) {
                Node nleft = n.left;
                nodes.offer(nleft);
            } else if (n.right != null) {
                Node nRight = n.right;
                nodes.offer(nRight);
            }
        }
    }

    @ToString
    @EqualsAndHashCode
    @RequiredArgsConstructor
    static private final class Node {

        @NonNull
        private Node left;

        @NonNull
        private Node right;

    }

}
