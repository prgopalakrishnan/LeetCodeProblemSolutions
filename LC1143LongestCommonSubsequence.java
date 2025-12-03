class LC1143LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        int longestCommonLength = 0;
        int rows = text1.length()+1;
        int cols = text2.length()+1;
        int[][] dpMat = new int[rows][cols];

        for(int i = 0; i < cols; i++) {
            dpMat[rows-1][i] = 0;
        }
        for(int j = 0; j < rows; j++) {
            dpMat[j][cols-1] = 0;
        }

        int curLength = 0;
        for(int i = rows-2; i >= 0; i--) {
            for(int j = cols-2; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    curLength = 1+dpMat[i+1][j+1];
                } else {
                    curLength = dpMat[i+1][j+1];
                }
                dpMat[i][j] = Math.max(curLength, Math.max(dpMat[i][j+1], dpMat[i+1][j]));
            }
        }
        return dpMat[0][0];
    }
}
