import java.util.ArrayList;

/**
 * A simple driver class to test the maze traversal. Please note that this is only provided as a sample test case. In order to make sure that your program is correct you must test it on several test cases.
 * 
 * Below is what should be printed by your traverse method:
row:1 column:0
row:1 column:1
row:1 column:2
row:2 column:2
row:2 column:3
row:2 column:4
row:1 column:4
row:1 column:5
row:1 column:6
row:2 column:6
row:2 column:7
row:2 column:8
row:2 column:9
row:3 column:9
row:4 column:9
row:4 column:10
row:4 column:11
row:5 column:11
row:5 column:12
The goal is reached
 * 
 */
/**
 * Note this is just an example of a main method to test your program. You should test your program.
 * You must test your program for more test cases to ensure that it works in all cases
 * 
 *
 */
public class MazeTester {

	public static void main(String[] args)
	{
		char[][] sample_maze ={
				{'x','x','x','x','x','x','x','x','x','x','x','x','x'},
				{' ',' ',' ','x',' ',' ',' ','x','x','x','x',' ','x'},
				{'x','x',' ',' ',' ','x',' ',' ',' ',' ','x',' ','x'},
				{'x','x',' ','x','x',' ','x',' ','x',' ','x',' ','x'},
				{'x','x',' ',' ','x',' ',' ',' ','x',' ',' ',' ','x'},
				{'x','x','x','x','x','x','x',' ','x',' ',' ',' ',' '},
				{'x','x','x','x','x','x','x','x','x','x','x','x','x'}
	         };
		char[][] sample_maze2 ={
				   {'x','x','x','x','x','x','x','x','x','x','x','x','x'},
				   {' ',' ',' ','x',' ',' ',' ','x','x','x','x',' ','x'},
				   {'x','x',' ',' ',' ','x',' ',' ',' ',' ','x',' ','x'},
				   {'x','x',' ','x','x',' ','x',' ','x',' ','x',' ','x'},
				   {'x','x',' ',' ','x',' ',' ',' ','x',' ',' ',' ','x'},
				   {'x','x','x','x','x','x','x',' ','x',' ',' ',' ',' '},
				   {'x','x','x','x','x','x','x','x','x','x','x','x','x'}
		         };
	Maze m = new Maze(sample_maze);
	ArrayList<Position> sol= m.traversewithStack(new Position(2,7), new Position(5,12));
	System.out.println("The solution returned by traverseWithStack is: ");
	if (sol!= null)
	{
		for (int i=0; i<sol.size(); i++)
			System.out.println(sol.get(i));
		System.out.println("The goal is reached");
	}
	else
		System.out.println("This maze has no solution");

	Maze m2 = new Maze(sample_maze2);
	ArrayList<Position> sol2= m2.traverseRecursive(new Position(1,0), new Position(5,12));
	System.out.println("The solution returned by traverseRecursive is: ");
	if (sol2!= null)
	{
		for (int i=0; i<sol2.size(); i++)
			System.out.println(sol2.get(i));
		System.out.println("The goal is reached");
	}
	else
		System.out.println("This maze has no solution");
}
}