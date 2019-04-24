import apple.laf.JRSUIUtils;
import sun.font.TrueTypeGlyphMapper;

import javax.swing.tree.TreeNode;
import java.security.KeyStore;

/**
 * charles
 * java learn
 * 2019-04-24
 *
 */
public class SearchBinaryTree{
    public static void main(String[] args) {
        SearchBinaryTree binaryTree = new SearchBinaryTree();
        int[] intArray = new int[]{50,30,20,44,88,33,87,16,7,77};
        for(int i: intArray) {
            binaryTree.put(i);
        }
        binaryTree.midOrder(binaryTree.root);
//        TreeNode node1 = new TreeNode(2,88);
//        >>>binaryTree.find(binaryTree.root,88) >> true
//        >>>binaryTree.find(binaryTree.root,22) >> false
        boolean a =  binaryTree.find(binaryTree.root,22);
        System.out.println(a);
    }


    private TreeNode root;
    public SearchBinaryTree(){

    }
//这里很有意思，想一想为什么在这里中序遍历正好是查找树的顺序排序
    public void midOrder(TreeNode node){
        if(node == null){
            return;
        }else{
            midOrder(node.leftNode);
            System.out.println(node.data);
            midOrder(node.rightNode);
        }
    }

//只需要查找log n 次个这是作业的答案哈 传入两个node
    private boolean find1(TreeNode root, TreeNode toFind){
        if(root == null){
            return false;
        }
        if(toFind.data < root.data)
            return find1(root.leftNode,toFind);
        if(toFind.data > root.data)
            return find1(root.rightNode,toFind);
        else
            return true;

        }
//直接传参法验证。传入一个node 和 一个数值
    private boolean find(TreeNode root, int a){
        if(root == null){
            return false;
        }
        if(a < root.data)
            return find(root.leftNode,a);
        if(a > root.data)
            return find(root.rightNode,a);
        else
            return true;

    }

//
//    }
    public TreeNode put(int data){
        TreeNode node = null;
        TreeNode parent = null;
        if (root == null) {
            node = new TreeNode(0, data);
            root = node;
            return node;
        }
        node = root;
        while (node!= null) {
            parent = node;
            if (data > node.data) {
                node = node.rightNode;
            } else if (data < node.data) {
                node = node.leftNode;
            } else {
                return node;
            }
        }
        node = new TreeNode(0, data);
        if (data < parent.data) {
            parent.leftNode = node;
            node.parent = parent;
        }else{
            parent.rightNode = node;
        }
        node.parent = parent;
        return node;
    }

    class TreeNode{
        private int key;
        private TreeNode leftNode;
        private TreeNode rightNode;
        private int data;
        private TreeNode parent;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public TreeNode(int key, int data){
            super();
            this.key = key;
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
            this.parent = null;
        }
    }






}
