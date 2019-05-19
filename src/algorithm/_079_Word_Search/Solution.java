package algorithm._079_Word_Search;

public class Solution {

    /*给定一个二维数组和字符串，判断该字符串可不可以在二维数组中找到*/
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //该起点进行搜索
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean exist(char[][] board, int i, int j, String word, int index) {
        //递归结束条件，也就是前面的全部都匹配成功了
        if (index == word.length()) {
            return true;
        }
        //失败的结束条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        //先修改该值，递归的时候就不能再次利用这个值了
        board[i][j] = '*';
        boolean result = exist(board, i - 1, j, word, index + 1) || exist(board, i + 1, j, word, index + 1) || exist(board, i, j - 1, word, index + 1) || exist(board, i, j + 1, word, index + 1);
        //递归结束要将该值修改为原值
        board[i][j] = word.charAt(index);
        //将结果返回
        return result;
    }

}
