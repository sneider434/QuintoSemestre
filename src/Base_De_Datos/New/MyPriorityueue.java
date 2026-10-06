package Base_De_Datos.New;

public class MyPriorityueue<T> {
    private Node<T> front;
    private int size;

    public MyPriorityueue(Node<T> front, int size) {
        this.front = null;
        this.size =0;
    }

    public void enqueue(T data , int priority){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        newNode.setPriority(priority);

    }
}
