package com.ym.line.algo.linkedList;

public class LinkedListCounter {
    public int count(ListNode head){
        if(head == null) return 0;
        int cnt = 0;
        ListNode curr = head;
        while (curr != null){
            cnt++;
            curr = curr.next;
        }
        return cnt;
    }
    public int countFor(ListNode head){
        if(head == null) return 0;
        int cnt = 0;
        for(ListNode curr = head; curr != null;curr = curr.next){
            cnt++;
        }
        return cnt;
    }
    public int countTarget(ListNode head, int target){
        if(head == null) return 0;
        int cnt = 0;
        ListNode curr = head;
        while (curr != null){
            if (curr.val == target) cnt++;
            curr = curr.next;
        }
        return cnt;
    }
    public int countForTarget(ListNode head, int target){
        if(head == null) return 0;
        int cnt = 0;
        for(ListNode curr = head; curr != null;curr = curr.next){
            if(curr.val == target) cnt++;
        }
        return cnt;
    }
}
