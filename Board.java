
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    public String[][] board = {{" "," "," "},
                               {" "," "," "},
                              {" "," "," "}};
    
                              
    public Board ()
    {
    }
    
    
    /**
     * This method determines whether the coordinate selected needs a horizontal line, vertical line, or nothing to create the board.
     */
    public void displayBoard()
    {
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                if(col<board.length-1){
                    System.out.print(" "+board[row][col]+" |");
                }
                else if(row<board[row].length-1){
                    System.out.print(" "+board[row][col]+" \n--- --- ---\n");
                }
                else{
                    System.out.print(" "+board[row][col]+" ");
                }
            }
        }
        System.out.println();
    }

    
    public void updateBoard(String playerLetter, int row, int col)
    {
        if(playerLetter.equals("X")||playerLetter.equals("O")){
            board[row][col]=playerLetter;
        }
        else{
            System.out.print("You must enter either an X or an O");
        }
        displayBoard();
    }
    
    /**
     * This method makes sure that the tile selected does not have a X or an O in it already.
     */
    public boolean isAvailable(int r, int c)
    { 
        if(board[r][c].equals("")||board[r][c].equals(" ")){
            return true;
        }
        else
            return false;
    }

    
    /**
     * This method makes sure that there are not any open tiles, and that no one has won already, and then checks for a tie.
     */
    public boolean isTie()
    {
        if(hasWon()==true)  
            return false;
        else{
            int count=0;
            for(int row=0;row<board.length;row++){
                for(int col=0;col<board[row].length;col++){
                    if(isAvailable(row,col)==true){
                        count++;
                    }
                }
            }
            if(count>0){
                return false;
            }
            else
                return true;
        }
    }

    
    /**
     * This method determines the vertical, horizontal, and diagonal win conditions for the TicTacToe game
     */
    public boolean hasWon()
    {   
        if(board[0][0].equals("X")&&board[0][1].equals("X")&&board[0][2].equals("X"))
            return true;
        else if(board[1][0].equals("X")&&board[1][1].equals("X")&&board[1][2].equals("X"))
            return true;
        else if(board[2][0].equals("X")&&board[2][1].equals("X")&&board[2][2].equals("X"))
            return true;
            
        else if(board[0][0].equals("X")&&board[1][0].equals("X")&&board[2][0].equals("X"))
            return true;
        else if(board[0][1].equals("X")&&board[1][1].equals("X")&&board[2][1].equals("X"))
            return true;
        else if(board[0][2].equals("X")&&board[1][2].equals("X")&&board[2][2].equals("X"))
            return true;
            
        else if(board[0][0].equals("X")&&board[1][1].equals("X")&&board[2][2].equals("X"))
            return true;
        else if(board[0][2].equals("X")&&board[1][1].equals("X")&&board[2][0].equals("X"))
            return true;
            
            
        else if(board[0][0].equals("O")&&board[0][1].equals("O")&&board[0][2].equals("O"))
            return true;
        else if(board[1][0].equals("O")&&board[1][1].equals("O")&&board[1][2].equals("O"))
            return true;
        else if(board[2][0].equals("O")&&board[2][1].equals("O")&&board[2][2].equals("O"))
            return true;
            
        else if(board[0][0].equals("O")&&board[1][0].equals("O")&&board[2][0].equals("O"))
            return true;
        else if(board[0][1].equals("O")&&board[1][1].equals("O")&&board[2][1].equals("O"))
            return true;
        else if(board[0][2].equals("O")&&board[1][2].equals("O")&&board[2][2].equals("O"))
            return true;
            
        else if(board[0][0].equals("O")&&board[1][1].equals("O")&&board[2][2].equals("O"))
            return true;
        else if(board[0][2].equals("O")&&board[1][1].equals("O")&&board[2][0].equals("O"))
            return true;
            
        else
            return false;
    }
}
