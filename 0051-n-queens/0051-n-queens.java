class Solution {
        List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n)
     {
        char board[][] = new char [n][n];
        
        for(char row[] : board)
        {
            Arrays.fill( row,'.');
        }

        backtrack(board,0,n);
        return ans;
    }

   private void backtrack(char[][] board , int row , int n)
   {
      if(row==n)
      {
        List<String> temp = new ArrayList<>();
        for(char[] i : board)
        {
            temp.add(new String(i));
        }
        ans.add(temp);
        return;
      }

      // col 
     for(int j =0;j<n;j++)
     {
        if(isSafe(board,row,j,n))
        {
            board[row][j]='Q';
            backtrack(board,row+1,n);
            board[row][j]='.';
        }
     }
   }

   private boolean isSafe(char [][] board , int row , int col , int n)
   {
     // vertical
     for(int i=0;i<n;i++)
     {
        if(board[i][col]=='Q')  return false;
     }
     // horixontal
     for(int j=0;j<n;j++)
     {
        if(board[row][j]=='Q')  return false;
     }
     // left daigonal 
     for(int i = row , j = col ; i>=0 && j>=0 ; i-- ,j--)
     {
        if(board[i][j]=='Q') return false;
     }
     //right daiginal 
     for(int i = row , j = col ; i>=0 && j<n ; i-- ,j++)
     {
        if(board[i][j]=='Q') return false;
     }

    return true;
   }
}