package Java.Queue;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    QueueNode front;
    QueueNode rear;

    void enqueue(int data) {
        QueueNode newNode = new QueueNode(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    void dequeue() {
        if (front == null) {
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    void printQueue() {
        QueueNode current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}