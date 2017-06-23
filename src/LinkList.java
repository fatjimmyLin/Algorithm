import java.util.Scanner;

/**
 * Created by fatjimmy on 17/5/28.
 */
//leetcode 237,206,19,21;leetcode 160 offer 37
public class LinkList {
        public ListNode head;
        public ListNode current;

        //方法：向链表中添加数据
        public void add(int data) {
            //判断链表为空的时候
            if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
                head = new ListNode(data);
                current = head;
            } else {
                //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
                current.next = new ListNode(data);
                //把链表的当前索引向后移动一位
                current = current.next;   //此步操作完成之后，current结点指向新添加的那个结点
            }
        }

        //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
        public void print(ListNode node) {
            if (node == null) {
                return;
            }

            current = node;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

        //Leetcode 237
        public void deleteNode(ListNode node) {
            node.data = node.next.data;
            node.next = node.next.next;
        }

        //Leetcode 206
        public ListNode reverseList(ListNode head) {
            ListNode newhead = null;
            ListNode nextnode;
            while(head!=null){
                nextnode = head.next;
                head.next = newhead;
                newhead = head;
                head = nextnode;
            }
            return newhead;
        }
        //leetcode 19 method 1
        /*public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode current1 = head;
            ListNode current2 = head;
            int count = 0;
            while (current1 != null) {
                count++;
                current1 = current1.next;
            }
            count = count - n - 1;
            if (count < -1) return null;
            if (count == -1) return head.next;
            while (count > 0) {
                current2 = current2.next;
                count--;
            }
            current2.next = current2.next.next;
            return head;
        }*/
        //leetcode 19 method 2
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode current1 = head;
            ListNode current2 = head;
            if(head == null || n == 0) return null;
            for(int i=0;i<n;i++){
                if(current1 == null) return null;
                current1 = current1.next;
            }
            if(current1 == null) return head.next;
            while(current1.next != null){
                current2 = current2.next;
                current1 = current1.next;
            }
            current2.next = current2.next.next;
            return head;
        }
        //leetcode 21
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            ListNode newhead = null;
            ListNode newnode = null;
            if(l1.data <= l2.data){
                newhead = l1;
                l1 = l1.next;
            }else{
                newhead = l2;
                l2 = l2.next;
            }
            newnode = newhead;
            while(l1!=null && l2!=null){
                if (l1.data < l2.data){
                    newnode.next = l1;
                    newnode = newnode.next;
                    l1 = l1.next;
                }else{
                    newnode.next = l2;
                    newnode = newnode.next;
                    l2 = l2.next;
                }
            }
            if(l1 != null){
                newnode.next = l1;
            }
            if(l2 != null){
                newnode.next = l2;
            }
            return newhead;
        }
        //leetcode 160 offer 37
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode head1 = headA;
            ListNode head2 = headB;
            int countA =1;
            while(head1!=null){
                countA++;
                head1 = head1.next;
            }
            int countB =1;
            while(head2!=null){
                countB++;
                head2 = head2.next;
            }
            int gap = countB-countA;
            if(gap>0){
                for(int i=0;i<gap;i++){
                    headB = headB.next;
                }
            }else{
                for(int i=0;i<-gap;i++){
                    headA = headA.next;
                }
            }
            while(headA!=null && headB!=null){
                if(headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }
        public static void main(String[] args) {
            LinkList ListNode1 = new LinkList();
            LinkList ListNode2 = new LinkList();
            int[] array1 ={1,2,3,4,5};
            int[] array2 ={6,7,8,9,10};
            //向LinkList中添加数据
            for (int i = 0; i < array1.length; i++) {
                ListNode1.add(array1[i]);
            }
            for (int i = 0; i < array2.length; i++) {
                ListNode2.add(array2[i]);
            }
            /*Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入
            System.out.println("请输入要删除的倒数第n个结点：");
            int n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名*/

            // 237 ListNode1.deleteNode(ListNode1.head.next);

            ListNode1.print(ListNode1.head);// 从head节点开始遍历输出
            System.out.println("Print the list: ");
            // 206 ListNode1.print(ListNode1.reverseList(ListNode1.head));
            // 19  ListNode1.print(ListNode1.removeNthFromEnd(ListNode1.head,n));
            // 21 ListNode1.print(ListNode1.mergeTwoLists(ListNode1.head,ListNode2.head));
        }
}
