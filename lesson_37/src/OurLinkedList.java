public class OurLinkedList<E> implements OurList<E>{
    private int size;
    private Node<E> first;
    private Node<E> last;

    public OurLinkedList() {

    }

    @Override
    public void append(E value) {

        if (size > 0) {
            Node<E> newNode = new Node<>(last, value, null);
            last.next = newNode;
            last = newNode;


        } else {
            Node<E> newNode = new Node<>(null, value, null);
            first = newNode;
            last = newNode;
        }
        size++;
    }


    private Node<E> getNodeByIndex(int index){
        if (index>=size || index<0) {
            return null;
        } else {
            int currentIndex=0;
            Node<E> currentNode= first;
            while (currentIndex<index){
                currentNode = currentNode.next;
                currentIndex++;
            }
            return currentNode;
        }

    }

    @Override
    public E get(int index) {
        if (index>=size || index<0) {
            return null;
        }
        return getNodeByIndex(index).value;
    }

    @Override
    public void set(E object, int index) {
        if (index>=size || index<0) {
            return;
        }
        getNodeByIndex(index).value = object;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E o) {
        Node<E> currentNode=first;
        while (currentNode!=null){
            if(currentNode.value.equals(o)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public boolean remove(E o) {
        return false;
    }

    @Override
    public E removeById(int index) {
        Node<E> deletedNode = getNodeByIndex(index);
        if (deletedNode!=null) {
            E value = deletedNode.value;
            if (deletedNode == first){
                first = deletedNode.next;
                if (deletedNode.next!=null) {
                    deletedNode.next.prev = null;
                }
            }
            if(deletedNode==last){
                last = deletedNode.prev;
                if(deletedNode.prev!=null){
                    deletedNode.prev.next=null;
                }
            }
            if(deletedNode!=first && deletedNode!=last) {
                deletedNode.next.prev = deletedNode.prev;
                deletedNode.prev.next = deletedNode.next;
                deletedNode.prev=null;
                deletedNode.next=null;
                deletedNode.value=null;
            }
            return value;
        }
        return null;
    }

    @Override
    public void printList() {
        if (size == 0) {
            System.out.println("List is empty");
        } else {
            int currentIndex = 0;
            Node<E> currentNode= first;

            while(currentIndex < size){
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
                currentIndex++;
            }
        }
    }


    private static class Node<E> {
        Node<E> prev;

        E value;

        Node<E> next;


        Node(Node<E> prev,E value, Node<E> next  ) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }


    }
}
