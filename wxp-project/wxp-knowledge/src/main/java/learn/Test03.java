package learn;

import java.util.ArrayList;

/**
 *
 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Test03 {

         ListNode head = null; // 头节点
       public    class ListNode {
             int val;
             ListNode next = null;
             ListNode(int val) {
                this.val = val;
            }
         }
    public  void addNode(ListNode node){
        ListNode temp = head;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while(temp.next != null){    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
    }

    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
      // ListNode node=new ListNode(3);

    }
}
