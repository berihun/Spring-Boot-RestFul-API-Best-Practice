package com.company.dstructure;

public class LinkedLNodeExampleDemo {
    LinkedLNodeExample head;

    LinkedLNodeExample insertInBegining(int key, LinkedLNodeExample head) {
        LinkedLNodeExample temp = new LinkedLNodeExample(key);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        return head;
    }

    LinkedLNodeExample insertInEnd(int key, LinkedLNodeExample head) {
        LinkedLNodeExample temp = new LinkedLNodeExample(key);
        LinkedLNodeExample temp1 = head;

        if (temp1 == null) {
            head = temp;
        } else {
            while (temp1.next != null)
                temp1 = temp1.next;
            temp1.next = temp;
        }
        return head;
    }

    LinkedLNodeExample insertByPosition(int key, int position, LinkedLNodeExample head) {
        LinkedLNodeExample temp = new LinkedLNodeExample(key);
        if (position == 1) {
            temp.next = head;
            head = temp;
        } else {
            LinkedLNodeExample temp1 = head;
            for (int i = 0; temp1 != null && i < position; i++) {
                temp1 = temp.next;
            }
            temp.next = temp1.next;
            temp.next = temp;
        }
        return head;
    }

    LinkedLNodeExample delete(int position, LinkedLNodeExample head) {
        LinkedLNodeExample temp = head;
        if (position == 1)
            head = temp.next;
        else {
            for (int i = 0; temp != null && i < position; i++)
                temp = temp.next;
            temp.next = temp.next.next;
        }
        return head;
    }

    int length(LinkedLNodeExample head) {
        LinkedLNodeExample temp = head;
        int c = 0;
        if (temp == null)
            return 0;
        else {
            while (temp != null) {
                temp = temp.next;
                c++;
            }
        }
        return c;
    }

    LinkedLNodeExample reverse(LinkedLNodeExample head)
    {
        LinkedLNodeExample prevLNode=null,curLNode=head,nextLNode=null;
        while(curLNode!=null)
        {
            nextLNode=curLNode.next;
            curLNode.next=prevLNode;

            prevLNode=curLNode;
            curLNode=nextLNode;
        }

        head=prevLNode;
        return head;
    }

    void display(LinkedLNodeExample head)
    {
        LinkedLNodeExample ttmp=head;
        while(ttmp!=null)
        {System.out.print(ttmp.data+" ");
            ttmp=ttmp.next;
        }
    }
}
