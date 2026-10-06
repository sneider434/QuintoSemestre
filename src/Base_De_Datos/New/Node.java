package Base_De_Datos.New;

public class Node<T> {
        private T data;
        private Node<T> next;
        private int priority;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
