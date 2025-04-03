package APS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj1991 {
    static class Node {
        char left, right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.put(root, new Node(left, right));
        }

        StringBuilder preorder = new StringBuilder();
        StringBuilder inorder = new StringBuilder();
        StringBuilder postorder = new StringBuilder();

        preorder('A', preorder);
        inorder('A', inorder);
        postorder('A', postorder);

        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }

    static void preorder(char node, StringBuilder sb) {
        if (node == '.') return;
        sb.append(node);
        preorder(tree.get(node).left, sb);
        preorder(tree.get(node).right, sb);
    }

    static void inorder(char node, StringBuilder sb) {
        if (node == '.') return;
        inorder(tree.get(node).left, sb);
        sb.append(node);
        inorder(tree.get(node).right, sb);
    }

    static void postorder(char node, StringBuilder sb) {
        if (node == '.') return;
        postorder(tree.get(node).left, sb);
        postorder(tree.get(node).right, sb);
        sb.append(node);
    }
}

