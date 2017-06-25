import java.util.*;
import java.util.Queue;
import java.util.Stack;
/**
 * Created by fatjimmy on 17/5/28.
 */
// leetcode 572 offer 18; leetcode 101; leetcode 226 offer 19; leetcode 102 offer 23; leetcode 113 offer 25; leetcode 114;
// offer 39 leetcode 104;
    // leetcode 617
public class Bintrees {
    private static List<TreeNode> nodeList = null;

    public TreeNode createBintree(int[] array) {
        nodeList = new LinkedList<TreeNode>();

        // 将数组的值转换为node
        if(array.length == 0) return null;
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new TreeNode(array[nodeIndex]));
        }

        // 对除最后一个父节点按照父节点和孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }

        // 最后一个父节点
        int lastParentIndex = array.length / 2 - 1;

        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);

        // 如果为奇数，建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }
        return  nodeList.get(0);
    }
    // 前序遍历
    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    // 中序遍历
    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }

    // 后序遍历
    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val + " ");
    }

    //leetcode 572 offer 18
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        if(s!=null && t!=null){
            if(s.val == t.val){
                result = DoesTree1HasTree2(s,t);
            }
            if(result == false){
                result = isSubtree(s.left,t);
            }
            if(result == false){
                result = isSubtree(s.right,t);
            }
        }
        return result;
    }
    public boolean DoesTree1HasTree2(TreeNode s, TreeNode t){
        if(s == null && t == null) return true; //if(t == null) return true;
        if(s == null || t == null) return false; //if(s == null) return false;
        if(s.val != t.val) return false;
        return DoesTree1HasTree2(s.left,t.left) && DoesTree1HasTree2(s.right,t.right);
    }
    // leetcode 101
    public boolean isSymmetric(TreeNode root) {
        boolean flag = false;

        return flag;
    }
    // leetcode 226 offer 19
    public static TreeNode MirrorRecursively(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode newroot = root.left;
        root.left = root.right;
        root.right = newroot;
        MirrorRecursively(root.left);
        MirrorRecursively(root.right);
        return root;
    }
    public static boolean isSame(TreeNode root1,TreeNode root2){
        boolean flag = false;
        if(root1 == null && root2 == null) return true;
        if(root1 == null && root2 != null) return false;
        if(root1 != null && root2 == null) return false;
        if(root1.val != root2.val) return false;

        if(root1.val == root2.val){
            flag = isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
        }
        return flag;
    }
    //leetcode 102 offer 23
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root == null) return list;
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> layer = new ArrayList<Integer>();
            Queue<TreeNode> Subqueue = new LinkedList<TreeNode>();
            while (!queue.isEmpty()){
                TreeNode current = queue.poll();
                layer.add(current.val);
                if(current.left!=null) Subqueue.add(current.left);
                if(current.right!=null) Subqueue.add(current.right);
            }
            queue = Subqueue;
            list.add(layer);
        }
        return list;
    }

    //leetcode 113 offer 25
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<Integer>();
        int count =0;
        List<List<Integer>> newlist = traverse(root,list,sublist,count,sum);
        return newlist;
    }
    public List<List<Integer>> traverse(TreeNode node, List<List<Integer>> list,List<Integer> sublist,int count,int sum) {
        if(node == null) return list;

        count = count + node.val;
        sublist.add(node.val);
        if(node.left==null && node.right==null && count == sum){
            List<Integer> newlist = new ArrayList<>(sublist);
            list.add(newlist);
            sublist.remove(sublist.size()-1);
            return list;
        }

        traverse(node.left,list,sublist,count,sum);
        traverse(node.right,list,sublist,count,sum);

        sublist.remove(sublist.size()-1);

        if(sublist.size() == 0)return list;
        else return null;
    }
    //leetcode 112
    public boolean hasPathSum(TreeNode root, int sum) {
        int count = 0;
        int flag = 0;
        flag = judge(root,count,sum,flag);
        if(flag == 0) return false;
        else return true;
    }
    public int judge(TreeNode node,int count,int sum,int flag) {
        if(node == null){
            return 0;
        }

        count = count + node.val;
        if(node.left==null && node.right==null && count == sum){
            return 1;
        }

        flag = flag + judge(node.left,count,sum,flag);
        flag = flag + judge(node.right,count,sum,flag);
        count = count - node.val;

        return flag;
    }

    // leetcode 114
    public void flatten(TreeNode root) {
        if(root == null) return;
        convert(root);
    }

    public static TreeNode convert(TreeNode root){
        if(root == null) return null;
        if(root.left ==null && root.right==null) return root;
        TreeNode node = root.right;
        TreeNode last = null;

        //直接假设能获得last，从宏观角度考虑递归，再处理细节
        root.right = root.left;
        if(root.left != null) {
            last = convert(root.left);
            last.right = node;
        }else{
            last = root;
            last.right = node;
        }
        root.left = null;

        if(last.right != null) {
            last = convert(last.right);
        }
        return last;
    }
    //leetcode 617
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 != null && t2 == null) return t1;
        if(t1 == null && t2 != null) return t2;

        if(t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
        }
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
    //offer 39 leetcode 104
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left>right) return left+1;
        else return right+1;
    }
    //offer 39 leetcode 110
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int diff = left - right;
        if(diff>1 || diff<-1){
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }
    public static void main(String[] args) {
        Bintrees binTree = new Bintrees();
        int[] array1 = {1,2,9,3,6,10,13,4,5,7,8,11,12,14,15};
        TreeNode root1 = binTree.createBintree(array1);
        // int[] array2 = {4,1,2};
        // TreeNode root2 = binTree.createBintree(array2);
        // leetcode 572 boolean flag = binTree.isSubtree(root1,root2);
        // System.out.println("Subtree of Another Tree is: "+flag);
        System.out.println("前序遍历1：");
        preOrderTraverse(root1);
        System.out.println();

        System.out.println("中序遍历1：");
        inOrderTraverse(root1);
        System.out.println();

        System.out.println("后序遍历1：");
        postOrderTraverse(root1);
        System.out.println();

        // Scanner read = new Scanner(System.in); //创建Scanner对象read 接受从控制台输入
        // int n = read.nextInt(); //调用Scanner类中的方法.nextInt() 对象名.方法名

        // leetcode 102 offer 23 List<List<Integer>> list = binTree.levelOrder(root1);
        // leetcode 113 offer 25 List<List<Integer>> list = binTree.pathSum(root1,i);
        // int i = 20;
        // leetcode 112 boolean flag = binTree.hasPathSum(root1,i);
        // System.out.println("The path is: "+flag);

        // leetcode 226 offer 19 TreeNode rootmirror = binTree.MirrorRecursively(root1);
        // leetcode 101  boolean flag = binTree.isSymmetric(root1);
        // leetcode 617 TreeNode root = binTree.mergeTrees(root1,root2);
        // leetcode 114 binTree.flatten(root1);
        // leetcode 104 int i = binTree.maxDepth(root1);
        // leetcode 110 boolean flag = binTree.isBalanced(root1);
        System.out.println();

        //System.out.println("balanced tree："+flag);
    }
}
