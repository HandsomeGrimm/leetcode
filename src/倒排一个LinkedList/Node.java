package 倒排一个LinkedList;

public class Node {
    char value;
    Node next;

    public Node(char c){
        this.value=c;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
