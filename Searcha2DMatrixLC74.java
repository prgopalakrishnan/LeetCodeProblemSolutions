class Searcha2DMatrixLC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lowRow = 0; int lowCol = 0;
        int highRow = m-1; int highCol = n-1;
        int midRow = 0;
        int midCol = 0;

        while(lowRow <= highRow) {
            midRow = (lowRow+highRow)/2;

            if(target < matrix[midRow][0] ) {
                highRow = midRow -1;
            } else if (matrix[midRow][n-1] < target) {
                lowRow = midRow+1;
            } else {
                break;
            }
        }


        if(midRow < 0 || midRow > m-1) {
            return false;   
        }

        while(lowCol <= highCol) {
            midCol = (lowCol + highCol)/2;
            
            if(target == matrix[midRow][midCol]) {
                return true;
            } else if(target > matrix[midRow][midCol]) {
                lowCol = midCol+1;
            } else {
                highCol = midCol-1;
            }
        }

        return false;
        
    }

}
