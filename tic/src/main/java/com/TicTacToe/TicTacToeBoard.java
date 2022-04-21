package com.TicTacToe;
import java.util.*;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
	

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   *
   */
  String input;
  int countX=0;
  int countO=0;
  int xwins=0;
  int owins=0;
  public TicTacToeBoard(String board) {
	  this.input = board.toLowerCase();	  

  } 

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
	  if(input.length()!=9)
		  return Evaluation.UnreachableState;
	  for(int i=0;i<input.length();i++)
	  {
		  if(input.charAt(i) == 'x')
			  countX++;
		  if(input.charAt(i) == 'o')
			  countO++;
	  }
	  if(Math.abs(countX-countO) > 1)
		  return Evaluation.UnreachableState;
	  
      if(check(input,'x'))
    	 xwins=1;
   
      if(check(input,'o'))
    	  owins=1;
      if(xwins==1 && owins==1)
    	  return Evaluation.UnreachableState;
      if(xwins==1)
    	  return Evaluation.Xwins;
      if(owins==1)
    	  return Evaluation.Owins;
      
      return Evaluation.NoWinner;
  }
  public static boolean check(String input,char a) {
	  int j=-1;
	  for(int i=0;i<=6;i=i+3)
	  {
		  j++;
		  //to check rows
		  if(input.charAt(i)==a && input.charAt(i+1)==a && input.charAt(i+2)==a)
			  return true;
		  //To check column
		    if(input.charAt(j)==a && input.charAt(j+3)==a && input.charAt(j+6)==a)
		    	return true;
	   }
	  //To check diagonal
	  if(input.charAt(0)==a && input.charAt(4)==a && input.charAt(8)==a)
		  return true;
	  if(input.charAt(2)==a && input.charAt(4)==a && input.charAt(6)==a)
		  return true;
	  return false;
  }
public static void main(String args[] ){
Scanner sc = new Scanner(System.in);
String input = sc.nextLine();
TicTacToeBoard T = new TicTacToeBoard(input);
System.out.println(T.evaluate());


}
}
