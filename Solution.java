class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        this.left=null;
        this.right = null;
    }
}
class Solution
{
     static Node root;
    static void createNode(int parent[], int i, Node created[])
    {
        // If this node is already created
        if (created[i] != null)
            return;
  
        // Create a new node and set created[i]
        created[i] = new Node(i+1);
  
        // If 'i' is root, change root pointer and return
        if (parent[i] == -1)
        {
            root = created[i];
            return;
        }
  
        // If parent is not created, then create parent first
        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);
  
        // Find parent pointer
        Node p = created[parent[i]];
  
        // If this is first child of parent
        if (p.left == null)
            p.left = created[i];
        else // If second child
          
            p.right = created[i];
    }
  
    /* Creates tree from parent[0..n-1] and returns root of
       the created tree */
    static Node createTree(int parent[], int n)
    {   
        // Create an array created[] to keep track
        // of created nodes, initialize all entries
        // as NULL
        Node[] created = new Node[n];
        for (int i = 0; i < n; i++)
            created[i] = null;
  
        for (int i = 0; i < n; i++)
            createNode(parent, i, created);
  
        return root;
    }
    
    static void solutions(Node root, int ans, int total_ans){
        System.out.println("HEre we are");
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            total_ans+=ans;
            ans= 0;
            return ;
        }
        
        ans = Math.max(ans, root.data);
        System.out.println(ans);
        solutions(root.left, ans , total_ans);
        
        solutions(root.right, ans , total_ans);
    }
    
    static long solve(int n, int Par[])
    {
        Node root = createTree(Par , n);
        System.out.println(root.data + " " +root.right.data + " ");
        int ans = 0, total_ans = 0;
        solutions(root, ans, total_ans);
        return total_ans;
    }
    public static void main(String[] args) {
        int [] p  ={-1,1,2,2,4};
    System.out.println(solve(5,p));
    }
}
