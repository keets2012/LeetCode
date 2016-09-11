package array;

/**
 * Created by keets on 7/28/16.
 */
public class WordSearch {

    public boolean findWord(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    if (word.length() == 1 ||findNext(i,j,board,word.substring(1),visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }
    public boolean findNext(int x,int y,char[][] board,String word,boolean[][] visited){
        if(word.length()==0){
            return true;
        }

        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0;i<direction.length;i++){
            int ii = x + direction[i][0];
            int jj = y + direction[i][1];
            if(ii>=0&&jj>=0&&ii<board.length&&jj<board[0].length&&word.charAt(0)==board[ii][jj]&&visited[ii][jj]){
                visited[ii][jj] = true;
                if(word.length() == 1 || findNext(ii,jj,board,word.substring(1),visited)){
                    return true;
                }
                visited[ii][jj] = false;
            }
        }
        return false;
    }
}

