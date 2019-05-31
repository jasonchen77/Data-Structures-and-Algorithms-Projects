/****
 * A class to store and traverse a maze
 * 
 *
 */
import java.util.*;
public class Maze {
 
	/**
	 * Two dimensional array to represent a maze
	 */
	private char[][] maze;
	
	/**
	 * Constructor initializing the maze array
	 * @param maze
	 */
	
	
	public Maze(char[][] maze)
	{
		this.maze= maze;
	}
	
	
/**
	 *  You need to implement this method
	 * @param start: The start Position in the maze
	 * @param goal: The goal Position in the maze
	 * @return An array of Position which stores a solution to the maze. If a solution is not found a null value should be returned.
	 */
	public ArrayList<Position> traversewithStack(Position start, Position goal)
	{
		ArrayList<Position> solution = new ArrayList<Position>();
			
		if (start.getRow() < 0 || start.getRow() > maze.length-1 || start.getColumn() < 0 || start.getColumn() > maze[0].length-1 ||
				goal.getRow() < 0 || goal.getRow() > maze.length-1 || goal.getColumn() < 0 || goal.getColumn() > maze[0].length-1 ||
				maze[start.getRow()][start.getColumn()] != ' ' || maze[goal.getRow()][goal.getColumn()] != ' ' || maze == null) {
			throw new IllegalArgumentException("Invalid parameters or array");
		}
		
		Stack<Position> path = new Stack<Position>();
		path.push(start);
		//solution.add(start);
		maze[start.getRow()][start.getColumn()] = 'v';
		Position current = new Position(start.getRow(), start.getColumn());
		Position addPosition;
			
		while(!path.isEmpty() && !current.equals(goal)) {
			if (current.getColumn()-1 >= 0 && current.getColumn()-1 < maze[0].length && maze[current.getRow()][current.getColumn()-1] == ' ') {
				current.setColumn(current.getColumn()-1);
				addPosition = new Position(current.getRow(), current.getColumn());
				path.push(addPosition);
				//solution.add(addPosition);
				maze[current.getRow()][current.getColumn()] = 'v';
			}
			else if (current.getColumn()+1 >= 0 && current.getColumn()+1 < maze[0].length && maze[current.getRow()][current.getColumn()+1] == ' ') {
				current.setColumn(current.getColumn()+1);
				addPosition = new Position(current.getRow(), current.getColumn());
				path.push(addPosition);
				//solution.add(addPosition);
				maze[current.getRow()][current.getColumn()] = 'v';
			}
			else if (current.getRow()-1 >= 0 && current.getRow()-1 < maze.length && maze[current.getRow()-1][current.getColumn()] == ' ') {
				current.setRow(current.getRow()-1);
				addPosition = new Position(current.getRow(), current.getColumn());
				path.push(addPosition);
				//solution.add(addPosition);
				maze[current.getRow()][current.getColumn()] = 'v';
			}
			else if (current.getRow()+1 >= 0 && current.getRow()+1 < maze.length && maze[current.getRow()+1][current.getColumn()] == ' ') {
				current.setRow(current.getRow()+1);
				addPosition = new Position(current.getRow(), current.getColumn());
				path.push(addPosition);
				//solution.add(addPosition);
				maze[current.getRow()][current.getColumn()] = 'v';
			}
			else {
				current.setRow(path.peek().getRow());
				current.setColumn(path.peek().getColumn());
				addPosition = new Position(current.getRow(), current.getColumn());
				//solution.add(addPosition);

//				if(current.equals(start)) {
//					return null;
//				}
				if (current.getColumn()-1 >= 0 && current.getColumn()+1 < maze[0].length && 
						current.getRow()-1 >= 0 && current.getRow()+1 < maze.length) {
					if((maze[current.getRow()][current.getColumn()-1] != ' ' && maze[current.getRow()-1][current.getColumn()] != ' ' && 
							maze[current.getRow()][current.getColumn()+1] != ' ' && maze[current.getRow()+1][current.getColumn()] != ' ')) {
						path.pop();
					}
				}
				else if (current.getColumn() == 0 && current.getRow() == 0 && 
						maze[current.getRow()][current.getColumn()+1] != ' ' && maze[current.getRow()+1][current.getColumn()] != ' ') {
					path.pop();
				}
				else if (current.getColumn() == maze[0].length-1 && current.getRow() == 0 && 
						maze[current.getRow()][current.getColumn()-1] != ' ' && maze[current.getRow()+1][current.getColumn()] != ' ') {
					path.pop();
				}
				else if (current.getColumn() == 0 && current.getRow() == maze.length-1 && 
						maze[current.getRow()-1][current.getColumn()] != ' ' && maze[current.getRow()][current.getColumn()+1] != ' ') {
					path.pop();
				}
				else if (current.getColumn() == maze[0].length-1 && current.getRow() == maze.length-1 &&
						maze[current.getRow()][current.getColumn()-1] != ' ' && maze[current.getRow()-1][current.getColumn()] != ' ') {
					path.pop();
				}
				else if (current.getColumn() == 0 && maze[current.getRow()-1][current.getColumn()] != ' ' && 
						maze[current.getRow()][current.getColumn()+1] != ' ' && maze[current.getRow()+1][current.getColumn()] != ' '){
					path.pop();
				}
				else if (current.getColumn() == maze[0].length-1 && maze[current.getRow()][current.getColumn()-1] != ' ' && 
						maze[current.getRow()-1][current.getColumn()] != ' ' && maze[current.getRow()+1][current.getColumn()] != ' ') {
					path.pop();
				}
				else if (current.getRow() == 0 && maze[current.getRow()][current.getColumn()-1] != ' ' && 
						maze[current.getRow()][current.getColumn()+1] != ' ' && maze[current.getRow()+1][current.getColumn()] != ' ') {
					path.pop();
				}
				else if (current.getRow() == maze.length-1 && maze[current.getRow()][current.getColumn()-1] != ' ' && 
						maze[current.getRow()-1][current.getColumn()] != ' ' && maze[current.getRow()][current.getColumn()+1] != ' ') {
					path.pop();
				}
			}
		}
		if(path.isEmpty() && !current.equals(goal)) {
			return null;
		}
		else {
			while(!path.isEmpty()) {
				solution.add(path.pop());
			}
			Collections.reverse(solution);
			return solution;
		}
		
	}
	
	
	
	
	/**
	 *  You need to implement this method
	 * @param start: The start Position in the maze
	 * @param goal: The goal Position in the maze
	 * @return An array of Position which stores a solution to the maze. If a solution is not found a null value should be returned.
	 */
	ArrayList<Position> solutionRecursive = new ArrayList<Position>();
	
	//Have to create a new sample_maze array, otherwise values from traversewithStack
	//will carry over in the maze data field
	public ArrayList<Position> traverseRecursive(Position start, Position goal)
	{
		
		if (start.getRow() < 0 || start.getRow() > maze.length-1 || start.getColumn() < 0 || start.getColumn() > maze[0].length-1 ||
				goal.getRow() < 0 || goal.getRow() > maze.length-1 || goal.getColumn() < 0 || goal.getColumn() > maze[0].length-1 ||
				(maze[start.getRow()][start.getColumn()] != ' ' && maze[start.getRow()][start.getColumn()] != 'v') || 
				maze[goal.getRow()][goal.getColumn()] != ' ' ||  
				maze == null) {
			throw new IllegalArgumentException("Invalid parameters or array");
		}
		
		if (start.equals(goal)) {
			
			return solutionRecursive;
		}
		
		else if (maze[start.getRow()][start.getColumn()] == ' ') {
			maze[start.getRow()][start.getColumn()] = 'v';
			solutionRecursive.add(new Position(start.getRow(), start.getColumn()));
			
			if (start.getColumn()-1 >= 0 && start.getColumn()-1 < maze[0].length && maze[start.getRow()][start.getColumn()-1] == ' ') {
				start.setColumn(start.getColumn()-1);
				//solutionRecursive.add(new Position(start.getRow(), start.getColumn()));
				traverseRecursive(start, goal);
			}
			else if (start.getColumn()+1 >= 0 && start.getColumn()+1 < maze[0].length && maze[start.getRow()][start.getColumn()+1] == ' ') {
				start.setColumn(start.getColumn()+1);
				//solutionRecursive.add(new Position(start.getRow(), start.getColumn()));
				traverseRecursive(start, goal);
			}
			else if (start.getRow()-1 >= 0 && start.getRow()-1 < maze.length && maze[start.getRow()-1][start.getColumn()] == ' ') {
				start.setRow(start.getRow()-1);
				//solutionRecursive.add(new Position(start.getRow(), start.getColumn()));
				traverseRecursive(start, goal);
			}
			else if (start.getRow()+1 >= 0 && start.getRow()+1 < maze.length && maze[start.getRow()+1][start.getColumn()] == ' ') {
				start.setRow(start.getRow()+1);
				//solutionRecursive.add(new Position(start.getRow(), start.getColumn()));
				traverseRecursive(start, goal);
			}
			
			
		}
		return null;
	}
	
}
