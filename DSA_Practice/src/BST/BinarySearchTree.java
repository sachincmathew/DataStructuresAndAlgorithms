/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author SachinMathew
 */
public class BinarySearchTree implements BSTInterface {

    Node root = null;

    @Override
    public void addElement(int element) {
        Node newNode = new Node(element);
        if (root == null) {
            root = newNode;
        } else {
            boolean b = root.addChildNode(element);
            String s;
            s = b ? "Added Successfully" : "Duplicate Element";
            System.out.println(s);
        }
    }

    @Override
    public void BFS() {
        Queue<Node> q = new LinkedList();
        if (root == null) {
            return;
        }
        q.add(root);
        System.out.println("Breadth First Traversal: ");
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.data + ", ");
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
    }

    @Override
    public void DFS_Inorder(Node n) {
        if (n == null) {
            return;
        }
        DFS_Inorder(n.left);
        System.out.print(n.data + ", ");
        DFS_Inorder(n.right);
    }

    @Override
    public void DFS_Preorder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.data + ", ");
        DFS_Preorder(n.left);
        DFS_Preorder(n.right);

    }

    @Override
    public void DFS_Postorder(Node n) {
        if (n == null) {
            return;
        }
        DFS_Postorder(n.left);
        DFS_Postorder(n.right);
        System.out.print(n.data + ", ");

    }

    @Override
    public boolean deleteElement(Node node, int i) {
         if (root == null)
                  return false;
            else {
                  if (root.data== i) {
                        Node auxRoot = new Node(0);
                        auxRoot.left = root;
                        boolean result = root.remove(i, auxRoot);
                        root = auxRoot.left;
                        return result;
                  } else {
                        return root.remove(i, null);
                  }
            }
    }
}

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public boolean addChildNode(int element) {
        if (element == data) {
            return false;
        } else {
            if (element < this.data) {
                if (this.left == null) {
                    this.left = new Node(element);
                } else {
                    this.left.addChildNode(element);
                }
            } else if (element > this.data) {
                if (this.right == null) {
                    Node newNode = new Node(element);
                    this.right = newNode;
                } else {
                    this.right.addChildNode(element);
                }
            }
        }
        return true;
    }

    public boolean remove(int element, Node parent) {
        if (element < this.data) {
            if (left != null) {
                return left.remove(element, this);
            } else {
                return false;
            }
        } else if (element > this.data) {
            if (right != null) {
                return right.remove(element, this);
            } else {
                return false;
            }
        } else {//current node needs to be deleted
            if (left != null && right != null) {//2 children
                this.data = right.minValue();
                right.remove(this.data, this);
            } else if (parent.left == this) {//this is left child of parent
                parent.left = (left != null) ? left : right;
            } else if (parent.right == this) {//this is right child of parent
                parent.right = (left != null) ? left : right;
            }
            return true;
        }
    }

    public int minValue() {
        if (left == null) {
            return data;
        } else {
            return left.minValue();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (this.data != other.data) {
            return false;
        }
        return true;
    }
}
