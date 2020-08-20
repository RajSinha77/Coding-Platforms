/* Top View: Top view of a binary tree is the set of nodes visible when
the tree is viewed from the top. A node x is there in output if x is the
topmost node at its horizontal distance. Horizontal distance of left child
of a node x is equal to the horizontal distance of x minus 1, and that of
right child is the horizontal distance of x plus 1.

So, the idea is to do a level order traversal of the tree and calculate the 
horizontal distance of every node from the root node and print those nodes which
are the first nodes of a particular horizontal distance.

Hashing can be used to keep a check on whether any node with a particular 
horizontal distance is encountered yet or not.
 */






// Structure of binary tree 
// Binary Tree node is modified to contain
// an extra parameter hd, which is the 
// horizontal distance of the node from root node.
struct Node 
{ 
    Node * left; 
    Node* right; 
    int hd; 
    int data; 
}; 

// Function to print the topView of 
// the binary tree 
void topview(Node* root) 
{ 
    if(root==NULL) 
        return; 
    
    queue<Node*>q; 
    
    map<int,int> m; 
    
    int hd=0; 
    
    root->hd = hd; 
    
    // push node and horizontal distance to queue 
    q.push(root); 
    
    print "The top view of the tree is : "; 
    
    while(q.size()) 
    { 
        hd = root->hd; 
        
        // Check if any node with this horizontal distance
        // is encontered yet or not.
        // If not insert, current node's data to Map
        if(m.count(hd)==0) 
            m[hd]=root->data; 
        
        // Push the left child with its 
        // horizontal distance to queue
        if(root->left) 
        { 
            root->left->hd=hd-1; 
            q.push(root->left); 
        } 
        
        // Push the right child with its 
        // horizontal distance to queue        
        if(root->right) 
        { 
            root->right->hd=hd+1; 
            q.push(root->right); 
        } 
        
        q.pop(); 
        root=q.front(); 
    } 
    
    // Print the map as it stores the nodes 
    // appearing in the Top View
    for(auto i=m.begin();i!=m.end();i++) 
    { 
        cout<<i->second<<" "; 
    }     
} 
