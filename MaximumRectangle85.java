
public class MaximumRectangle85 {
	

	    class MatrixCell {
	        int left = 0;
	        int top = 0;
	    }

	    public int maximalRectangle(char[][] matrix) {
	        // initialize left ,top for matrix
	        int maxRectangleSoFar = 0;
	        int maxRectangle = 0;
	        int row = matrix.length;
	        int col = matrix[0].length;

	        MatrixCell[][] infoMatrix = new MatrixCell[row][col];

	        
	        for(int i =0; i < row; i++) {
	            for(int j =0; j <col; j++) {
	                infoMatrix[i][j] = new MatrixCell();

	                if(i ==0 && j==0) {
	                    if(matrix[i][j] == '1') {
	                        infoMatrix[i][j].left = 1;
	                        infoMatrix[i][j].top = 1;
	                    }
	                    
	                } else if(i ==0 && j != 0) {
	                    if(matrix[i][j] == '1') {
	                        infoMatrix[i][j].left = infoMatrix[i][j-1].left + 1;
	                        infoMatrix[i][j].top = 1;
	                    }
	                } else if(i != 0 && j == 0) {
	                    if(matrix[i][j] == '1') {
	                        infoMatrix[i][j].left = 1;
	                        infoMatrix[i][j].top = infoMatrix[i-1][j].top + 1;
	                    }
	                } else {
	                    if(matrix[i][j] == '1') {
	                        infoMatrix[i][j].left = infoMatrix[i][j-1].left + 1;
	                        infoMatrix[i][j].top = infoMatrix[i-1][j].top + 1;
	                     }
	                }
	                
	            }
	        }//populate matrix info


	        print(infoMatrix);

	        
	        int[][] maxRectangleSoFarMatrix = new int[row][col];

	        // fill top row
	        maxRectangleSoFarMatrix[0][0]  = Character.getNumericValue(matrix[0][0]);
	        maxRectangleSoFar = Character.getNumericValue(matrix[0][0]);
	        maxRectangle = 0;
	        for(int i =1; i < col; i++) {
	            if(matrix[0][i] == '1' && matrix[0][i-1] == '1') {
	             maxRectangleSoFarMatrix[0][i] = Math.max(maxRectangleSoFar,
	            		 infoMatrix[0][i].left);
	            } else if(matrix[0][i] == '1' && matrix[0][i-1] == '0') {
		             maxRectangleSoFarMatrix[0][i] = Math.max(maxRectangleSoFar,
                             1);
	            } else {
	                maxRectangleSoFarMatrix[0][i] = maxRectangleSoFar;
	            }

	            if(maxRectangleSoFar < maxRectangleSoFarMatrix[0][i]) {
	                maxRectangleSoFar = maxRectangleSoFarMatrix[0][i];
	            }
	        }

	        //fill left column
	        maxRectangleSoFar = Character.getNumericValue(matrix[0][0]);
	        for(int i =1; i < row; i++) {
	            if(matrix[i][0] == '1' &&  matrix[i-1][0] == '1') { 
	             maxRectangleSoFarMatrix[i][0] = Math.max(maxRectangleSoFar,
	            		 infoMatrix[i][0].top);
	            } else if(matrix[i][0] == '1' &&  matrix[i-1][0] == '0') { 
		             maxRectangleSoFarMatrix[i][0] = Math.max(maxRectangleSoFar,
                             1);
	            }  else {
	                maxRectangleSoFarMatrix[i][0] = maxRectangleSoFar;
	            }

	            if(maxRectangleSoFar < maxRectangleSoFarMatrix[i][0]) {
	                maxRectangleSoFar = maxRectangleSoFarMatrix[i][0];
	            }
	        }


	        // fill remaining cells
	        maxRectangleSoFar  = 0;
	        int tmpMax = 0;
	        int[] elems = null;
	        for(int i = 1; i < row; i++) {
	            for(int j =1; j < col; j++) {
	                if(matrix[i][j] == '0') {
	                    maxRectangleSoFarMatrix[i][j] = Math.max(maxRectangleSoFarMatrix[i][j-1],
	                                                            maxRectangleSoFarMatrix[i-1][j]);
	                } else if(matrix[i][j] == '1' && matrix[i][j-1] == '0' && matrix[i-1][j] == '0') {
	                    maxRectangleSoFarMatrix[i][j] = Math.max(maxRectangleSoFarMatrix[i][j-1],
	                                                            maxRectangleSoFarMatrix[i-1][j]);

	                } else if(matrix[i][j] == '1' && matrix[i][j-1] == '0' && matrix[i-1][j] == '1') {
	                    elems = new int[]{maxRectangleSoFarMatrix[i][j-1],maxRectangleSoFarMatrix[i-1][j],
	                                            infoMatrix[i][j].top};
	                    maxRectangleSoFarMatrix[i][j] = getMax(elems);
	                } else if(matrix[i][j] == '1' && matrix[i][j-1] == '1' && matrix[i-1][j] == '0') {
	                    elems = new int[]{maxRectangleSoFarMatrix[i][j-1],maxRectangleSoFarMatrix[i-1][j],
	                                            infoMatrix[i][j].left};
	                    maxRectangleSoFarMatrix[i][j] = getMax(elems);

	                } else if(matrix[i][j] == '1' && matrix[i][j-1] == '1' && matrix[i-1][j] == '1' &&
	                                                 matrix[i-1][j-1] == '0' )  {
	                   
	                    elems = new int[]{maxRectangleSoFarMatrix[i][j-1],maxRectangleSoFarMatrix[i-1][j],
	                                            infoMatrix[i][j].left,infoMatrix[i][j].top};
	                    maxRectangleSoFarMatrix[i][j] = getMax(elems);

	                } else if(matrix[i][j] == '1' && matrix[i][j-1] == '1' && matrix[i-1][j] == '1' &&
	                                                 matrix[i-1][j-1] == '1'){

	                    elems = new int[] {maxRectangleSoFarMatrix[i][j-1],maxRectangleSoFarMatrix[i-1][j],
	                                            infoMatrix[i][j].left,infoMatrix[i][j].top,getArea(i,j,infoMatrix)};
	                    maxRectangleSoFarMatrix[i][j] = getMax(elems);

	                }

	                if(maxRectangleSoFar < maxRectangleSoFarMatrix[i][j]) {
	                    maxRectangleSoFar = maxRectangleSoFarMatrix[i][j];
	                } else {
	                    maxRectangleSoFarMatrix[i][j] = maxRectangleSoFar;
	                }
	            }
	        }
	        print(maxRectangleSoFarMatrix);
	        return maxRectangleSoFarMatrix[row-1][col-1];

	    }


	    int getArea(int row, int col, MatrixCell[][] infoMatrix ) {
	        int min = infoMatrix[row][col].left;
	        int maxAreaSoFar = 0;
	        int curArea = 0;
	        int b = 1;
	        int minSoFar = infoMatrix[row][col].left;
	        for(int i = row; i > row-infoMatrix[row][col].top; i--) {
	        	min = Math.min(min,infoMatrix[i][col].left);
	        	curArea = min*b;
	        	b++;
	        	if(maxAreaSoFar < curArea) {
	        		maxAreaSoFar = curArea;
	        	}
	            if(minSoFar < min) {
	                min = minSoFar;
	            }
	        }
	        return maxAreaSoFar;
	    }

	    
	    int getMax(int[] elems) {
	        int max = elems[0];
	        for(int i = 1; i < elems.length; i++) {
	            if(max < elems[i]) {
	                max = elems[i];
	            }
	        }
	        return max;
	    }
	    
	    public void print(MatrixCell[][] infoMatrix) {
	    	for(int i =0; i<infoMatrix.length; i++) {
	    		for(int j =0; j < infoMatrix[0].length; j++) {
	    			System.out.print("  "+infoMatrix[i][j].left+","+infoMatrix[i][j].top);
	    		}
	    		System.out.println();
	    	}
	    }
	    
	    public void print(int[][] maxRectable) {
	    	for(int i =0; i<maxRectable.length; i++) {
	    		for(int j =0; j < maxRectable[0].length; j++) {
	    			System.out.print("  "+maxRectable[i][j]);
	    		}
	    		System.out.println();
	    	}
	    }
	    
	    
	    public static void main(String args[]) {
	    	MaximumRectangle85 obj = new MaximumRectangle85();
	    	char[][] matrix = 
	    	
	    		{{'1','0','1','1','1','1','0','1','1'},
	    	    		{'0','1','0','1','0','0','0','0','0'},
	    	    		{'0','0','0','0','1','0','1','1','0'},
	    	    		{'1','1','1','0','1','0','1','0','1'}
	    					  };
	    	//obj.maximalRectangle(matrix);
	    	int val = 1;
	    	int yourInt = val+98;
	    	char ch = (char) yourInt;
	    	System.out.println(yourInt);
	    	System.out.println(ch);
	    }
	    

}
