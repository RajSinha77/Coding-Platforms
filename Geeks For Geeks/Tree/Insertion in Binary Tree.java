/* Problem: Given a Binary Tree and a Key. The task is to insert the key into the binary 
tree at first position available in level order.

The idea is to do iterative level order traversal of the given tree using a queue. 
If we find a node whose left child is empty, we make new key as the left child of the node. 
Else if we find a node whose right child is empty, we make new key as the right child of that
node. We keep traversing the tree until we find a node whose either left or right child is empty.  */




// Java program to insert element in binary tree 

import java.util.LinkedList; 
import java.util.Queue; 
public class GFG { 
    
    // Binary Tree Node
    static class Node { 
        int key; 
        Node left, right; 
        
        // constructor 
        Node(int key){ 
            this.key = key; 
            left = null; 
            right = null; 
        } 
    } 
    
    static Node root; 
    static Node temp = root; 
    
    // Function to perform InOrder traversal
    // of the Binary Tree
    static void inorder(Node temp) 
    { 
        if (temp == null) 
            return; 
    
        inorder(temp.left); 
        System.out.print(temp.key+" "); 
        inorder(temp.right); 
    } 
    
    // Function to insert a new element in the 
    // Binary Tree
    static void insert(Node temp, int key) 
    { 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(temp); 
    
        // Do level order traversal until we find 
        // an empty place. 
        while (!q.isEmpty()) { 
            temp = q.peek(); 
            q.remove(); 
    
            if (temp.left == null) { 
                temp.left = new Node(key); 
                break; 
            } else
                q.add(temp.left); 
    
            if (temp.right == null) { 
                temp.right = new Node(key); 
                break; 
            } else
                q.add(temp.right); 
        } 
    } 
    
    // Driver code 
    public static void main(String args[]) 
    {   
        // Create the following Binary Tree
        //          10
        //         /  \
        //        11   9
        //       /      \
        //      7        8
        root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8); 
    
        System.out.print( "Inorder traversal before insertion: "); 
        inorder(root); 
    
        int key = 12; 
        insert(root, key); 
    
        System.out.print("\nInorder traversal after insertion: "); 
        inorder(root); 
    } 
} 
