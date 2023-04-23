package org.example;

public class ReverseTree {
    public static void main(String[] args) {
        int[] l = {1,3, 9, 20, 15, 7};
        int[] m = {9, 3, 1,15, 20, 7};
        Node root = solution(m, 0, m.length, l, 0, l.length);
        System.out.println(root);
    }

    public static Node solution(int[] middle, int middle_start, int middle_to, int[] left, int left_start, int left_to) {
        if (middle_start >= middle_to) {//处理边界
            return null;
        }
        int root_data = middle[middle_start];
        Node root = new Node(root_data);
        if (middle_start + 1 == middle_to) {//只有一个
            return root;
        }
        int split_count = 0;//根据root，对前序遍历进行拆分，一定存在，
        for (int i = left_start; i < left_to; i++) {
            if (root_data != left[i]) {
                split_count++;
                continue;
            }
            break;
        }
        //根据拆分后，左边是root的左遍历，，右边是root的右遍历，
        root.l = solution(middle, middle_start + 1, middle_start + 1 + split_count, left, left_start, left_start + split_count);
        root.r = solution(middle, middle_start + 1 + split_count, middle_to, left, left_start + split_count + 1, left_to);
        return root;
    }

    static class Node {
        int data;
        Node l;
        Node r;

        public Node(int d) {
            this.data = d;
        }
    }
}
