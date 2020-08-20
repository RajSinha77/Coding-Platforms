/*The diameter of a tree (sometimes called the width) is the number of 
nodes on the longest path between two end nodes. The diagram below shows
two trees each with diameter nine, the leaves that form the ends of a 
longest path are shaded (note that there is more than one path in each 
tree of length nine, but no path longer than nine nodes). */


/* Solution: The diameter of a tree T is the largest of the following quantities:

1.The diameter of T's left subtree.
2.The diameter of T's right subtree.
3.The longest path between leaves that goes through the root of T 
(this can be computed from the heights of the subtrees of T).

The longest path between leaves that goes through a particular node say, nd can be calculated as:

1 + height of left subtree of nd + height of right subtree of nd

Therefore, final Diameter of a node can be calculated as:
Diameter = maximum(lDiameter, rDiameter, 1 + lHeight + rHeight)
Where,

1.lDiameter = Diameter of left subtree
2.rDiameter = Diameter of right subtree
3.lHeight = Height of left subtree
4.rHeight = Height of right subtree    */

// Time Complexity: O(N2), where N is the number of nodes in the binary tree.



// Recursive optimized Java program to find the diameter of a
// Binary Tree

/* Class containing left and right child of current
 node and key value*/
class Node
{
    int data;
    Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

/* Class to print the Diameter */
class BinaryTree
{
    Node root;

    /* Method to calculate the diameter and return it to main */
    int diameter(Node root)
    {
        /* base case if tree is empty */
        if (root == null)
            return 0;

        /* get the height of left and right sub trees */
        int lheight = height(root.left);
        int rheight = height(root.right);

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1,
                        Math.max(ldiameter, rdiameter));

    }

    /* A wrapper over diameter(Node root) */
    int diameter()
    {
        return diameter(root);
    }

    /*The function Compute the "height" of a tree. Height is the
      number f nodes along the longest path from the root node
      down to the farthest leaf node.*/
    static int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter());
    }
}
