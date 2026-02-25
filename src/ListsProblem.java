public class ListsProblem {

    public static void main(String[] args) {

    }
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        int count = 0;
        SinglyLinkedListNode temp = llist;
        while (temp != null) {
            count++;
            if (count == position) {
                SinglyLinkedListNode node = new SinglyLinkedListNode(data);
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }

        return llist;

    }
}
