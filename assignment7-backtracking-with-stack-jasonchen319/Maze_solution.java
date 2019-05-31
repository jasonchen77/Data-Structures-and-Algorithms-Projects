/****
 * A class to store and traverse a maze
 * 
 *
 */
import java.util.*;
public class Maze_solution {
 
	/**
	 * Two dimensional array to represent a maze
	 */
	private char[][] maze;
	
	/**
	 * Constructor initializing the maze array
	 * @param maze
	 */
	public Maze_solution(char[][] maze)
	{
		this.maze= maze;
	}
	
/**
	 *  You need to implement this method
	 * @param start: The start Position in the maze
	 * @param goal: The goal Position in the maze
	 * @return An array of Position which stores a solution to the maze. If a solution is not found a null value should be returned.
	 */
	public Position[] traversewithStack(Position start, Position goal)
	{
		
		char[][]maze_cloned=mazeCopy(maze);
		
		//Do initial checking to make sure that the maze is not null and the start and end positions are valid
		if (maze_cloned==null || maze_cloned.length==0)
			return null;
		if (!isValid(start)|| maze_cloned[start.getRow()][start.getColumn()]!=' ')
			throw new IllegalArgumentException("invalid start position");
		if (!isValid(goal)|| maze_cloned[goal.getRow()][goal.getColumn()]!=' ')
			throw new IllegalArgumentException("invalid end position");
		
		
			
		Stack<Position> solution = new Stack<Position>();
		Position current = start;
		solution.push(current);
		
		int row_size = maze_cloned.length-1;
		int col_size = maze_cloned[0].length-1;
		
		while (!solution.isEmpty())
		{
			// if the goal position is reached then stop
			if (current.equals(goal))
				 break;
			
			int row = current.getRow();
			int column = current.getColumn();
			col_size = maze_cloned[row].length-1;
			
			if (maze_cloned[row][column]==' ')
				maze_cloned[row][column]='V';
			
			//If the cell to the left is empty then move left
			if(column>0 &&  maze_cloned[row][column-1]== ' ')
			{
				Position newPosition = new Position(row, column-1);
				solution.push(newPosition);
				current =newPosition;
			}
			
			//If the cell to the right is empty then move 
			else if (column< col_size && maze_cloned[row][column+1]==' ')
			{
				Position newPosition = new Position(row, column+1);
				solution.push(newPosition);
				current =newPosition;
			}
			
			//If the cell down is empty then move down
			else if (row >0 && column<maze_cloned[row-1].length && maze_cloned[row-1][column]==' ')
			{	
				Position newPosition = new Position(row-1, column);
				solution.push(newPosition);
				current =newPosition;
			}
			
			//If the cell up is empty then move up
			else if (row<row_size && column<maze_cloned[row+1].length&& maze_cloned[row+1][column]==' ')
			{
				Position newPosition = new Position(row+1, column);
				solution.push(newPosition);
				current =newPosition;
				
			}
			
			
			//if no neighboring cell is empty, backtrack
			else
			{
				solution.pop();
				if (!solution.isEmpty())
					current= solution.peek();
				
			}
			
		}
		
		if (solution.isEmpty())
			return null;
		else
		{
			int solutionSize= solution.size();
			Position[] traverse = new Position[solutionSize]; 
			for (int i=solutionSize -1; i>=0; i--)
				traverse[i] = solution.pop();
			return traverse;
		}
				
		
	}
		
	public Boolean isValid(Position p)
	{
		if (p!=null && p.getRow()>=0 && p.getRow()<maze.length && p.getColumn()>=0 && p.getColumn()<maze[p.getRow()].length)
			return true;
		return false;
	}

	
	
	
	
	/**
	 *  You need to implement this method
	 * @param start: The start Position in the maze
	 * @param goal: The goal Position in the maze
	 * @return An array of Position which stores a solution to the maze. If a solution is not found a null value should be returned.
	 */
	public Position[] traverseRecursive(Position start, Position goal)
	{
		
		if (!isValid(goal)|| maze[goal.getRow()][goal.getColumn()]!=' ')
			throw new IllegalArgumentException("invalid end position");
		
		char[][] maze_cloned=mazeCopy(maze);
		LinkedList<Position> path=traverseRecursiveInner(start, goal, maze_cloned);
		
		Position[] solution = new Position[path.size()];
		int i=0;
		for(Position p:path)
		{
			solution[i++]=p;
		}
			
		return solution;	
		
		//Your implementation goes here.
	}
	
	/**
	 * A helper recursive method for traversing the maze
	 * @param start: start position
	 * @param goal: end position
	 * @return a linked list of positions that can be traversed to go from start to goal. 
	 * The reason I chose linked list to store the solution is because I can build up the solution recursively by 
	 * adding the start position to the beginning of the solution returned by going left, right, down, or up. 
	 * Adding an item to the beginning of a linked list can be done in O(1) and does not require shifting other elements.
	 */
	private LinkedList<Position> traverseRecursiveInner(Position start, Position goal, char[][] maze){
	
	//Do initial checking to make sure that the maze is not null and the start and end positions are valid
			if (maze==null || maze.length==0)
				return null;
			if (!isValid(start)|| maze[start.getRow()][start.getColumn()]!=' ')
				throw new IllegalArgumentException("invalid start position: "+start.getRow()+" , "+start.getColumn());
			

			
			//Stopping condition, if start equals goal, we no longer need to look further so we return the start position as the solution		
			if(start.equals(goal))
			{
				LinkedList<Position> solution= new LinkedList<Position>();
				solution.add(start);
				return solution;
				
			}
			
			maze[start.getRow()][start.getColumn()]='V';
			int row = start.getRow();
			int column = start.getColumn();
			
			
		
			//If the cell to the left is empty then move left
			if(column>0 &&  maze[row][column-1]== ' ')
			{
				Position left = new Position(row, column-1);
				LinkedList<Position> leftPath= traverseRecursiveInner(left, goal,maze);
				
				//Add the start position to the solution found by going left and return it
				if ((leftPath)!=null) {
					leftPath.addFirst(start);
					return leftPath;
				}
			}
			
			//If the cell to the right is empty then move 
			if (column< maze[row].length && maze[row][column+1]==' ')
			{
				Position right = new Position(row, column+1);
				LinkedList<Position> rightPath= traverseRecursiveInner(right, goal,maze);
				
				//Add the start position to the solution found by going right and return it
				if ((rightPath)!=null) {
					rightPath.addFirst(start);
					return rightPath;
				}
			}
			
			//If the top is empty then move top
			if (row >0 && column<maze[row-1].length && maze[row-1][column]==' ')
			{	
				Position top = new Position(row-1, column);
				LinkedList<Position> topPath= traverseRecursiveInner(top, goal,maze);
				
				//Add the start position to the solution found by going down and return it
				if ((topPath)!=null) {
					topPath.addFirst(start);
					return topPath;
				}
			}
			
			//If the bottom cell is empty then move up
			if (row<maze.length && column<maze[row+1].length&& maze[row+1][column]==' ')
			{
				Position down = new Position(row+1, column);
				LinkedList<Position> downPath= traverseRecursiveInner(down, goal,maze);
				
				//Add the start position to the solution found by going down and return it
				if ((downPath)!=null) {
					downPath.addFirst(start);
					return downPath;
				}
				
			}
			
			//no solution was found by going left, right, down or up, so maze has no solution, return null
			return null;
			
	}	
	private char[][] mazeCopy(char[][]maze){
		char[][]copy= new char[maze.length][maze[0].length];
		for (int i=0;i<maze.length; i++)
			for(int j=0;j<maze[i].length; j++)
				copy[i][j]=maze[i][j];
		return copy;
				
	}
}