package lsf.java._200_numberOfIslands;

@SuppressWarnings("WeakerAccess")
public class Solution2 {
	public static void main(String[] args){
		Solution2 s=new Solution2();
		
		String[] ssss={"11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111","01111111111101101111","11111111111101111011","11111111110111111111","11111111111111111111","01111111011111111111","11111111111111111111","11111111111111111111","11111011111110111111","10111110111011110111","11111111111101111110","11111111111110111100","11111111111111111111","11111111111111111111","11111111111111111111",};

		char[][] grid =
		{		
				{'1','1','1','1','1','1','1'},
				{'0','0','0','0','0','0','1'},
				{'1','1','1','1','1','0','1'},
				{'1','0','0','0','1','0','1'},
				{'1','0','1','0','1','0','1'},
				{'1','0','1','1','1','0','1'},
				{'1','1','1','1','1','1','1'},
				
		};
//		char[][] grid = new char[ssss.length][];
//		for (int i=0;i<ssss.length;i++) {
//			grid[i]=ssss[i].toCharArray();
//		}
		
		
		System.out.println("大陆   "+s.numIslands(grid));
	}
	
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
		int islandNum=0;
		int row=grid.length;
		int col=grid[0].length;
		
		boolean[][] visited=new boolean[row][col];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j<  grid[0].length; j++) {
				if(isNewIsland(grid,visited,i,j))
					islandNum++;
			}
		}
		return islandNum;
	}
	public boolean isNewIsland(char[][] grid,boolean[][] visited,int i,int j){
		
		
		if(i < 0 || grid.length <= i || j < 0 || grid[0].length <= j 
		           || visited[i][j]
		           || grid[i][j] == '0')
		            return false;
		else{
			visited[i][j]=true;
			isNewIsland(grid, visited, i - 1, j);
			isNewIsland(grid, visited, i + 1, j);
			isNewIsland(grid, visited, i, j - 1);
			isNewIsland(grid, visited, i, j + 1);
	        return true;
		}
	}
}