package com.ym.line.algo.linkedList;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while(curr != null){
            sb.append(curr.val).append("->");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
