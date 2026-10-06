package Base_De_Datos.Test;

public class MyQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    public MyQueue(){
        this.front=null;
        this.rear=null;
        this.size=0;
    }
    public void enqueue(T data){
        Node<T> newNode = new Node<>();
        newNode.setData(data);
        if(front == null){
            this.front=newNode;
            this.rear=newNode;
        }else{
            rear.setNext(front);
            rear=newNode;
        }
        size++;
    }

    public T dequeue(){
        if(front == null){
            return null;
        }
        T data = front.getData();
        front = front.getNext();
        size--;
        if(front == null){
            rear= null;

        }

        return data;
    }
    public T peak(){
        return (this.isEmpty()) ? null:this.front.getData();
    }
    public boolean isEmpty(){
        return (this.front == null);

    }
    public int size(){
        return this.size;

    }
}
