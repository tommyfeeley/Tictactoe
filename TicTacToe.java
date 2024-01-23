import java.util.Scanner;
/**
 * Write a description of class TicTacToe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicTacToe
{
    Scanner keyboard= new Scanner(System.in);
    Board board = new Board();
    

    
    
    /**
     * This method starts the TicTacToe game, and determines whether a certain player has won, or there is a tie.
     */
    public void playGame()
    {
        int count=0;
        while(count==0){
            playerMoveX();
            if(board.hasWon()==true)
            {
                System.out.println("Player X has won!");
                count++;
                break;
            }
            else if(board.isTie()==true)
            {
                System.out.println("Player O and Player X have tied!");
                count++;
                break;
            }
            playerMoveO();
            if(board.hasWon()==true)
            {
                System.out.println("Player O has won!");
                count++;
                break;
            }
            else if(board.isTie()==true)
            {
                System.out.println("Player O and Player X have tied!");
                count++;
                break;
            }
        }
    }
    
    
    /**
     * This method determines where the X goes for that turn, and if player X picks an invalid number it tells the user to pick a valid number between 0 and 2.
     */
    public void playerMoveX()
    { 
        int row = 5;
        int col = 5;
        while(row==5&&col==5)
        {
            while(row>2||row<0){
                System.out.println("Select a row to place the X."); 
                row = keyboard.nextInt();
                if (row>2||row<0){
                    System.out.println("Select a valid number (0,1, or 2)");
                }
            }   
            while(col>2||col<0){
                System.out.println("Select a column to place the X."); 
                col = keyboard.nextInt();
                if (col<=-1||col>=3){
                    System.out.println("Select a valid number (0,1, or 2).");
                }
            }   
            if(board.isAvailable(row,col)==true)
            {
                System.out.println("Your row is "+ row +" and your column is "+ col +".\n");
                board.updateBoard("X",row,col);
            }
            else{
                System.out.print("The spot you chose is taken, choose a new row and column\n");
                row = 5;
                col = 5;
            }
        }
    }
    
    
    /**
     * This method determines where the O goes for that turn, and if player O picks an invalid number it tells the user to pick a valid number between 0 and 2.
     */
    public void playerMoveO()
    {
        int row = 5;
        int col = 5;
        while(row==5&&col==5)
        {
            while(row>2||row<0){
                System.out.println("Select a row to place the O."); 
                row = keyboard.nextInt();
                if (row<0&&row>2){
                    System.out.println("Please select a valid row (0,1, or 2)");
                }
            }   
            while(col>2||col<0){
                System.out.println("Select a column to place the O."); 
                col = keyboard.nextInt();
                if (col>-1&&col<3){
                    System.out.println("Please select a valid column (0,1, or 2)");
                }
            }   
            if(board.isAvailable(row,col)==true)
            {
                System.out.println("Your row is "+row+" and your column is "+col+".\n");
                board.updateBoard("O",row,col);
            }
            else{
                System.out.print("The tile that you chose is taken, please input a new row and column");
                row = 5;
                col = 5;
            }
        }
    }
}
