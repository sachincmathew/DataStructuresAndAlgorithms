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
public interface BSTInterface {
    public void addElement(int i);
    public boolean deleteElement(Node n, int i);
    public void BFS();
    public void DFS_Inorder(Node n);
    public void DFS_Preorder(Node n);
    public void DFS_Postorder(Node n);
}
