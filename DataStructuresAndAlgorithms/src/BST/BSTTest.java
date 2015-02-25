/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

/**
 *
 * @author SachinMathew
 */
public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addElement(6);        
        bst.addElement(2);
        bst.addElement(5);
        bst.addElement(4);
        bst.addElement(8);
        bst.addElement(7);
        bst.addElement(9);
        bst.addElement(3);
        bst.addElement(1);
        
        System.out.println("");
        bst.BFS();
        
        System.out.println("\nInorder");
        bst.DFS_Inorder(bst.root);
        
        System.out.println("\nPreorder");
        bst.DFS_Preorder(bst.root);
        
        System.out.println("\nPostorder");
        bst.DFS_Postorder(bst.root);
        
        boolean b = bst.deleteElement(bst.root, 5);
        System.out.println("\nInorder after deletion " + b);
        bst.DFS_Inorder(bst.root);
        
        b = bst.deleteElement(bst.root, 5);
        System.out.println("\nInorder after deletion " + b);
        bst.DFS_Inorder(bst.root);
    }
}
