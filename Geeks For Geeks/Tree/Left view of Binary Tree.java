/* Problem: Given a Binary Tree. The task is to print the 
nodes of the binary tree when viewed from different sides. 
That is, the left view of the binary tree will contain only
those nodes which can be seen when the Binary tree is viewed from left. */

/* Left View: A simple solution is to notice that 
the nodes appearing in the left view of the binary 
tree are the first nodes at every level. So, the idea is to do a 
level order traversal of the binary tree using a marker to identify
levels and print the first node at every level.  */



// Function to print the left view of the binary tree 
void leftViewUtil(Node root) 
{ 
      // Declare a queue for Level order Traversal
      queue<Node*> q;
  
    if (root == NULL) 
        return; 

    // Push root 
    q.push(root); 

    // Delimiter 
    q.push(NULL); 

    while (!q.empty()) { 
        Node* temp = q.front(); 

        if (temp) { 

            // Prints first node 
            // of each level 
            print temp->data;

            // Push children of all nodes at 
            // current level 
            while (q.front() != NULL) { 

                // If left child is present 
                // push into queue 
                if (temp->left) 
                    q.push(temp->left); 

                // If right child is present 
                // push into queue 
                if (temp->right) 
                    q.push(temp->right); 

                // Pop the current node 
                q.pop(); 

                temp = q.front(); 
            } 

            // Push delimiter 
            // for the next level 
            q.push(NULL); 
        } 

        // Pop the delimiter of 
        // the previous level 
        q.pop(); 
    } 
} 
