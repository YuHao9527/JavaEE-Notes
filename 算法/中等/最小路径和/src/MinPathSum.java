package easy.最小路径和;

/**
 * @ClassName MinPathSum
 * @Description 最小路径和
 * @Author 0715-YuHao
 * @Date 2020/7/23 12:37
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int min = minPathSum(grid);
        System.out.println("最小路径和为：" + min);
    }

    /**
     * @Author 0715-YuHao
     * @Description 思路： 动态规划
     * @Date 2020/7/23 14:02
     * @Param [grid]
     * @return int
     */
    public static int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // (0, 0)起点
                if(i == 0 && j == 0) {
                    continue;
                }
                // 上边界, 只能从左边来
                else if(i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                // 左边界, 只能从上面来
                else if(j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                // 无边界，取最小值
                else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
