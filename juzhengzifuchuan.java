class juzhengzifuchuan {
    private final static int[][] direction={{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || word == null)
            return true;
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        //要明确的一点就是每个点都是从头搜索一遍 你的visited矩阵对每个点都是新的
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m;i++){
            for(int j = 0; j<n; j++){
                if(help(0, i, j, visited, board, word))
                    return true;
            }
        }
        return false;

    }

    private boolean help(int curlen, int r, int c, boolean[][] visited,
                         final char[][] board, final String word){
        //如果长度等于word。length说明是0-n n-1是满足条件的字符 所以可以返回true
        if (curlen == word.length()) {
            return true;
        }

        if(r < 0 || r >= m || c < 0 || c >= n || visited[r][c] ||
                board[r][c] != word.charAt(curlen))
            return false;
//这种情况是和 visited[r][c]对应的 说明我走过这个点了 先标注有以下

        visited[r][c] = true;//注意先改变在循环

        for(int[] d: direction){
//这里是重点 如果在四个方向的递归之中找到了满足条件的情况 就返回true
            if(help(curlen+1, r+d[0], c+d[1], visited, board, word))
                return true;
        }
        //上面都没有返回说明这个点不可能是满足条件的点 所以标回为false不影响下次判断

        visited[r][c] = false;

        return false;

    }
}