import jdk.nashorn.internal.runtime.regexp.joni.constants.TargetInfo;

import javax.swing.text.html.HTML;
import java.security.Principal;
import java.util.List;

/**
 * charles
 * java learn
 * 2019-04-08
 */
public class SingleLinkList {
    public static void headInsert(ListNode head, ListNode newhead){
        ListNode old = head;
        head = newhead;
        head.next = old;
    }

    public static void append(ListNode tail, ListNode newtail){
        ListNode old = tail;
        tail = newtail;
        newtail.next = null;
        old.next = newtail;
    }

    public static void traverse(ListNode head){
        while(head != null){
            System.out.print((head.value));
            head = head.next;
        }
        System.out.println();
    }

    public static int find(ListNode head, int value){
        int index = -1;
        int count = 0;
        while(head != null){
            if(head.value == value){
                index = count;
                return index;
            }
            count ++;
            head = head.next;
        }
        return index;
    }

    public static void insert(ListNode pre,ListNode newnode){
        ListNode next = pre.next;
        pre.next = newnode;
        newnode.next = next;
    }

    public static void delete(ListNode head,ListNode target){
        if(target != null && target.next != null){
            ListNode p = target.next;
            target.value = p.value;
            target.next = p.next;
            target = null;
        }
        if(target.next == null){
            while(head != null){
                if(head.next != null && head.next == target){
                    head.next = null;
                    break;
                }
                head = head.next;
            }
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        traverse(node1);
        ListNode node4 = new ListNode(4);
        append(node3,node4);
        delete(node1,node3);
        traverse(node1);
    }
}








