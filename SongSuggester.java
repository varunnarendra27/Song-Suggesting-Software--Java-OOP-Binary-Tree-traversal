import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.util.Queue;



public class SongSuggester
{
    
   
    public static void main(String[] args)
    {
        
        SongSuggester song_suggester = new SongSuggester();
        
        
        TreeNode root_question_node = new TreeNode("Do you like classical music? [y/n]", new TreeNode("Are you a fan of mozart? [y/n]", new TreeNode("Eine Kleine Nachtmusik"), new TreeNode("3 Romances by Clara Schumann")),new TreeNode("\"Take Five\" by Dave Brubeck"));
    
        
        
        
        boolean reached_leaf = false;
        
        System.out.println("Welcome! Let's help you find a song.");
            
        boolean start_over = true;
        while (start_over == true)
        {
            TreeNode current_node = root_question_node;
            
            reached_leaf = false;
            while (reached_leaf == false)
                {
                    String current_question = current_node.getPayload();
                    
                    if (current_node.isLeaf() == true)
                    {
                        Scanner choice = new Scanner(System.in);
                        Scanner choice2 = new Scanner(System.in);
                    
                        System.out.println(current_node.getPayload());
                        
                        boolean song_satisfactory = false;
                        
                        System.out.println("Is this satisfactory? [y/n]");
                        String song_satisfactory_choice = choice.nextLine();
                        
                        if (song_satisfactory_choice.equals("n")) {song_satisfactory=false;}
                        
                        else{song_satisfactory=true;}
                        
                        if (song_satisfactory == false)
                        {
                        
                            String old_suggestion = current_node.getPayload();
                            String new_suggestion;
                            String new_question;
                            
                            System.out.println("What would you prefer instead?");
                            new_suggestion = choice.nextLine();
                            System.out.println("Tell me a question that distinguishes " + old_suggestion + " from " + new_suggestion);
                            new_question = choice.nextLine();
                            
                            current_node.setLeft(new TreeNode(new_suggestion));
                            current_node.setPayload(new_question);
                            current_node.setRight(new TreeNode(old_suggestion));
                            
       
                        }
                        System.out.println("Do you want to play again? [y/n]");
                            
                        String play_again = choice2.nextLine();
                        
                        
                        
                        if (play_again.equals("n"))
                        {
                            
                            start_over = false;
                            
                            reached_leaf = true;
                            
                            System.out.println("Do you want to save the current tree? [y/n]");
                            String save_tree = choice.nextLine();
                            if(save_tree.equals("y"))
                            {
                                //Queue<TreeNode> queue = new LinkedList<TreeNode>();
                                root_question_node.print();
                            }
                            
                            
                            
                        }
                        else
                        {
                            
                            start_over = true;
                            reached_leaf = true;
                            
                        }
                                
                        
                    }
                    else if (current_node.isLeaf() == false)
                    {
                        
                        
                        
                        boolean askYesNo_value = song_suggester.askYesNo(current_question);
                       

                        if (askYesNo_value == true)
                        {
                        
                            current_node = current_node.getLeft();
                            
                        }
                    
                        else if (askYesNo_value == false)
                        {
                            current_node = current_node.getRight();
                        }
                        
                    
                    }
                    
                    
                    
                }
                
        }
        
        
        
        
        
        
    }
    
    
    
    
    public boolean askYesNo(String question)
    {
        Scanner input = new Scanner(System.in);
    
        System.out.println(question);
        String y_OR_n = input.nextLine();
        
        if (y_OR_n.equals("y"))
        {
            return true;
        }
        
//         else if (y_OR_n == "n") 
//         {
//             return false;
//         }
        
        else {return false;}
    }
    

        
        
    

}
