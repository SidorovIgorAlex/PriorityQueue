import java.util.ArrayList;

public class PropertyQueue<T> {

    static class Node
    {
        Node next;
        int item;
        int priority;
    }

    static Node newNode(int priority, int item)
    {
        Node temp = new Node();
        temp.item = item;
        temp.priority = priority;
        return temp;
    }

    static Node push(Node head, int priority, int item)
    {
        Node start = head;

        Node temp = newNode(priority, item);

        if(head.priority > priority)
        {
            temp.next = head;
            head = temp;
        }
        else
        {
            while(start.next != null && start.next.item < priority)
            {
                start = start.next;
            }
            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }

    static Node pop(Node head)
    {
        Node temp = head;
        head = head.next;
        return head;
    }

    static int peek(Node head)
    {
        return head.item;
    }

    static boolean isEmpty(Node head)
    {
        return(head == null);
    }

    public static void main(String[] args) {
        Node pq = newNode(1, 4);
        pq =push(pq, 5, 2);
        pq =push(pq, 6, 3);
        pq =push(pq, 7, 0);

        while (!isEmpty(pq)) {
            System.out.printf("%d ", peek(pq));
            pq=pop(pq);
        }
    }

}
