package 两数相加;

/**
 * @author HandsomeGrimm
 * @Date: 2020/3/30 13:52
 * @Description:
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     *
     * 功能描述:
     *
     * @param: 设立一个表示进位的变量carried，建立一个新链表，把输入的两个链表从头往后同时处理，每两个相加，将结果加上carried后的值作为一个新节点到新链表后面。
     * @return:
     * @auther: HandsomeGrimm
     * @date: 2020/3/30 13:57
     */

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead=new ListNode(0);
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode curr=dummyHead;
        int carried=0;
        while (p1!=null||p2!=null){

            int x=(p1!=null)?p1.val:0;
            int y=(p2!=null)?p2.val:0;
            int sum=x+y+carried;

            carried=sum/10;
            curr.next=new ListNode(sum%10);

            curr=curr.next;

            if (p1!=null){
                p1=p1.next;
            }
            if (p2!=null){
                p2=p2.next;
            }
        }

        //运算最后可能出现额外的进位，所以需加长链表
        if (carried>0){
            curr.next=new ListNode(carried);
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next=new ListNode(4);

        ListNode node=addTwoNumbers(l1,l2);
        System.out.println(node.val);
    }

}
