/**
 * Created by fatjimmy on 17/6/14.
 */
// leetcode 138 offer 26
public class ComplexLinkList {
    public RandomListNode head;
    public RandomListNode current;
    public RandomListNode start;
    //方法：向链表中添加数据
    public void add(int data) {
        //判断链表为空的时候
        if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
            head = new RandomListNode(data);
            current = head;
        } else {
            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
            current.next = new RandomListNode(data);
            //把链表的当前索引向后移动一位
            current = current.next;   //此步操作完成之后，current结点指向新添加的那个结点
        }
    }
    public void addRandom(RandomListNode node){
        if(node == null) return;
        current = node;
        start = node;
        while(current != null){
            if(current.label == 1){
                current.random = current.next.next;
            }
            if(current.label == 2){
                current.random = current.next.next.next;
            }
            if(current.label == 3){
                current.random = null;
            }
            if(current.label == 4){
                while(start != null){
                    if(start.label == 2){
                        current.random = start;
                        break;
                    }
                    start = start.next;
                }
            }
            if(current.label == 5){
                current.random = null;
            }
            current = current.next;
        }
    }
    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
    public void print(RandomListNode node) {
        if (node == null) {
            return;
        }

        current = node;
        while (current != null) {
            System.out.print("current node is: "+ current.label);
            if(current.random != null){
                System.out.print(" random node is: "+ current.random.label);
            }else System.out.print(" random node is: null");

            System.out.println();
            current = current.next;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        copyList(head);
        addRandomPointer(head);
        return reConnect(head);
    }

    public void copyList(RandomListNode head){
        while(head != null){
            RandomListNode newnode = new RandomListNode(head.label);
            newnode.next = head.next;
            head.next = newnode;
            head = newnode.next;
        }
    }

    public void addRandomPointer(RandomListNode head){
        RandomListNode headnext = head.next;
        while(head.next != null){
            if(head.random != null){
                headnext.random = head.random.next;
            }else headnext.random = null;
            head = head.next.next;
            if(headnext.next!=null) {
                headnext = headnext.next.next;
            }else break;
        }
    }

    public RandomListNode reConnect(RandomListNode head){
        RandomListNode newhead = head.next;
        RandomListNode goodhead = newhead; //important!
        while(head.next != null){
            head.next = head.next.next;
            if(newhead.next != null) {
                newhead.next = newhead.next.next;
            }else break;
            head = head.next;
            newhead = newhead.next;
        }
        return goodhead;
    }

    public static void main(String[] args) {
        ComplexLinkList ListNode1 = new ComplexLinkList();
        int[] array1 ={1,2,3,4,5};
        //向LinkList中添加数据
        for (int i = 0; i < array1.length; i++) {
            ListNode1.add(array1[i]);
        }
        ListNode1.addRandom(ListNode1.head);
        ListNode1.print(ListNode1.head);// 从head节点开始遍历输出
        System.out.println();
        ListNode1.copyRandomList(ListNode1.head);
        ListNode1.print(ListNode1.head);// 从head节点开始遍历输出
    }
}
