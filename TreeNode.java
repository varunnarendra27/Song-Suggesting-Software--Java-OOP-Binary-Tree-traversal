
import java.io.*;
import java.io.IOException;
//import java.util.Queue;


public class TreeNode
{
    private String payload;
    private TreeNode left_node;
    private TreeNode right_node;
    
    
    public TreeNode(String value)
    {
        this.payload = value;
    }
    
    public TreeNode(String value, TreeNode left, TreeNode right)
    {
        this.payload = value;
        this.left_node = left;
        this.right_node = right;
    }
    
    public String getPayload()
    {
        return this.payload;
    }
    
    public TreeNode getLeft()
    {
        return this.left_node;
    }
    
    public TreeNode getRight()
    {
        return this.right_node;

        
        
    }
    
    public void setLeft(TreeNode left)
    {
        this.left_node = left;
    }
    
    public void setRight(TreeNode right)
    {
        this.right_node = right;
    }
    
    public void setPayload(String payload)
    {
        this.payload = payload;
    }
    
    public boolean isLeaf()
    {
        if (this.left_node != null & this.right_node != null)
        {
            return false;
        }
        else
        {return true;}
        
    }
    
     
    public void print()
    {
        try(BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter("suggestions.txt", true)))
        {
            
  
            bufferedwriter.write(this.getPayload());
            bufferedwriter.newLine();
            bufferedwriter.flush();
            
        
            if(this.getLeft() != null)
            {
                this.getLeft().print();
                
                
            }                           
            
            if(this.getRight() != null)
            {
                this.getRight().print();
                
            }
            bufferedwriter.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
