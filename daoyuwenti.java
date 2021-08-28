public class daoyuwenti {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for(int i = 0;i < grid.length;i++){
                for(int j = 0;j < grid[0].length;j++){
                    if(grid[i][j] == 1){
                        int num = deepSearch(grid,i,j);
                        max = Math.max(num,max);
                    }
                }
            }
            return max;
        }
        public int deepSearch(int[][] grid,int i,int j){
            if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j] == 1){
                grid[i][j]=0;
                return 1 + deepSearch(grid,i-1,j) + deepSearch(grid,i+1,j)
                        + deepSearch(grid,i,j-1) + deepSearch(grid,i,j+1);
            }else
                return 0;
        }

}
