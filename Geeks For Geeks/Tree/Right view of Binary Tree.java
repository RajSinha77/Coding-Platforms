/* Right View: Printing Right View of the Binary Tree is similar to the above
 approach of printing the Left view of the tree. The idea is to print the last 
 node present at every level. So, perform a level order traversal using a delimeter 
 to identify levels and print the last node present at every level.    */



// Function to print the right view of the binary tree 
void rightViewUtil(Node root) 
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
