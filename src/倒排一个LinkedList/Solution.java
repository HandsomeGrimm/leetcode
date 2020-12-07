package 倒排一个LinkedList;

public class Solution {

    public static Node reverseList(Node current){
        Node pre=null;
        Node next=null;
        while (current!=null){
            //倒排
            next=current.next;
            current.next=pre;

            //更新节点
            pre=current;
            current=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node1=new Node('a');
        Node node2=new Node('b');
        Node node3=new Node('c');
        Node node4=new Node('d');

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        Node node=reverseList(node1);
        System.out.println(node.toString());

    }


}
