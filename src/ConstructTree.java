import java.util.List;

/**
 * Created by fatjimmy on 17/5/28.
 */
public class ConstructTree {
    //leetcode 105; offer 6

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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        //judge whether it is leaf node
        if(preorder == inorder && preorder.length == 1){
            TreeNode leaf = new TreeNode(preorder[0]);
            return leaf;
        }

        //set the head treenode
        TreeNode head = new TreeNode(preorder[0]);
        //find where the treenode is in the inorder
        int mark = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                mark = i;
                break;
            }
        }

        //deal with the left part
        int[] preleft = new int[mark];
        int[] inleft = new int[mark];
        if(preleft.length != 0){
            for(int i=0;i<mark;i++){
                preleft[i] = preorder[1+i];
                inleft[i] = inorder[i];
            }
            TreeNode leftchild = buildTree(preleft,inleft);//build left child tree;
            head.left = leftchild;
        }

        //deal with the right part
        int[] preright = new int[preorder.length-1-mark];
        int[] inright = new int[preorder.length-1-mark];
        if(preright.length!=0){
            for(int i=0;i<preright.length;i++){
                preright[i] = preorder[1+mark+i];
                inright[i] = inorder[1+mark+i];
            }
            TreeNode rightchild = buildTree(preright,inright);//build right child tree;
            head.right = rightchild;
        }

        return head;
    }


    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {1,2,3};
        TreeNode root = buildTree(preorder,inorder);

        System.out.println("前序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }
}
