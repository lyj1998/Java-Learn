package com.itheimia.dao.impl;

public class ListNode {
    private int val;
    private ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public  String toString( ) {
        // TODO: 写代码以递归的方式实现链表的toString方法
        //从自身开始循环
        StringBuilder stringBuilder = new StringBuilder();
        ListNode current = this;
        //循环遍历，只要current不为空，就进行操作
        while (current!=null){
             stringBuilder.append(current.val+"->");
             current = current.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }


    public static ListNode covert(int[] input) {
        // TODO: 写代码实现数组到链表的转换
//        ListNode listNode = new ListNode(input[0]);
//        ListNode next = listNode;
//        for (int i = 1; i<input.length; i++){
//            ListNode temp = new ListNode(input[i]);
//            next.next = temp;
//            next = temp;
//        }
//        return listNode;
        ListNode listNode = new ListNode();
        ListNode next = listNode;
        for (int i = 0; i<input.length; i++){
            ListNode temp = new ListNode(input[i]);
            next.next = temp;
            next = temp;
        }
        return listNode.next;
    }
    public static void main(String args[]) {
        int[] input = {1,4,5, 7, 8};
        ListNode ln = covert(input);
        System.out.println(ln);
    }
}
