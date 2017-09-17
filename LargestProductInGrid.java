import java.util.ArrayList;
import java.util.Arrays;

public class LargestProductInGrid {
	private String grid;
	public LargestProductInGrid(String grid) {
		this.grid = grid;
	}
	
	public void parse() {
		String str = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 " + 
				"49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 " + 
				"81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 " + 
				"52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 " + 
				"22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 " + 
				"24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 " + 
				"32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 " + 
				"67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 " + 
				"24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 " + 
				"21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 " + 
				"78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 " + 
				"16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 " + 
				"86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 " + 
				"19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 " + 
				"04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 " + 
				"88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 " + 
				"04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 " + 
				"20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 " + 
				"20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 " + 
				"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
		String name = str+" "; //"00 11 "
		System.out.println(name);
		char[] chArr = name.toCharArray();
		System.out.println(Arrays.toString(chArr));
		System.out.println("chArr length:"+chArr.length);
		ArrayList<String> bigJet = new ArrayList<String>();
		String a = null, b = null;
		int i=0;
		while(i<chArr.length) {
			if(chArr[i] != ' ' && i%3 == 0) {
				a = Character.toString(chArr[i]);
			}
			else if(chArr[i] != ' ' && i%3 == 1) {
				b = Character.toString(chArr[i]);
			}
			else if(chArr[i] == ' ') {
				bigJet.add(a+b);
			}
			i++;
		}
		System.out.println("String array: ");
		System.out.println(bigJet); // string array
		// int array;
		i=0;
		int[] grid = new int[bigJet.size()];
		while(i<bigJet.size()) {
			grid[i] = Integer.parseInt(bigJet.get(i));
			i++;
		}
		System.out.println("int array: ");
		System.out.println("grid length: " +grid.length);
		System.out.println(Arrays.toString(grid));
		System.out.println("now making a 2D grid");
		
		int k=0;
		int[][] twoD = new int[20][20];
		for(i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				twoD[i][j] = grid[k];
				k++;
			}
		} 
		System.out.println("twoD array is 2D array");//2D array made. From a String to charArray to
		//String array to int 1D array to int 2D array
		System.out.println(Arrays.deepToString(twoD));
		System.out.println("now multiplication of 2D");
		
		//mutliplication row wise
		int rowProd=1,rowMax=0;
		String rowIndex=null;
		
		for(int row=0;row<19;row++) { // outer index[row][col]
				for(int j=0;j<17;j++) { // rail of shift to next number in line
						for(int col=0;col<4;col++) { //group of 4 numbers
							rowProd = rowProd*twoD[row][j+col];
						}
						if(rowMax<rowProd) {
						  rowMax=rowProd;
						  rowIndex= "row:"+row+","+"col:"+j;
						}
						rowProd=1;
				}
		}
		System.out.println("Max prod in row: "+rowMax+" at "+rowIndex);
		
		
		//mutliplication col wise
				int colProd=1,colMax=0;
				String colIndex=null;
				
				for(int col=0;col<19;col++) { // outer index[row][col]
						for(int j=0;j<17;j++) { // rail of shift to next number in line
								for(int row=0;row<4;row++) { //group of 4 numbers
									colProd = colProd*twoD[row+j][col];
								}
								if(colMax<colProd) {
								  colMax=colProd;
								  colIndex= "row:"+j+","+"col:"+col;
								}
								colProd=1;
						}
				}
				System.out.println("Max prod in col: "+colMax+" at "+colIndex);

				//mutliplication leftDiagonal wise
				int leftDiagUpProd=1,leftDiagDownProd=1,leftDiagMidProd=1,leftDiagMax=0;
				String leftDiagIndex=null;
				int j=0;
				for(int start=16;start>=0;start--) {
					for(int row=start,col=0;row<20&&col<20;row++,col++) {
						if(row!=col) {
							leftDiagDownProd = leftDiagDownProd*twoD[row][col];
							leftDiagUpProd = leftDiagUpProd*twoD[col][row];
							j++;
							if(j==4) {
								j=0;
								if(leftDiagDownProd<leftDiagUpProd) {
									if(leftDiagMax<leftDiagUpProd) {
										leftDiagMax=leftDiagUpProd;
										leftDiagIndex="row:"+(col-3)+","+"col:"+(row-3);
									}
								}
								else {
									if(leftDiagMax<leftDiagDownProd) {
										leftDiagMax=leftDiagDownProd;
										leftDiagIndex="row:"+(row-3)+","+"col:"+(col-3);
									}
								}
								if(row!=19 && col!=19) { // check for border numbers in grid
									row=row-3;
									col=col-3;
								}
								leftDiagDownProd=1;
								leftDiagUpProd=1;
							}
						}
						else {
							leftDiagMidProd=leftDiagMidProd*twoD[row][col];
							j++;
							if(j==4) {
								j=0;
								if(leftDiagMax<leftDiagMidProd) {
									leftDiagMax=leftDiagMidProd;
									leftDiagIndex="row:"+(row-3)+","+"col:"+(col-3);
								}
								if(row!=19 && col!=19) { // check for border numbers in grid
									row=row-3;
									col=col-3;
								}
								leftDiagMidProd=1;
							}
						}
					}
				}
				System.out.println("Max prod in leftDiagonal: "+leftDiagMax+" at "+leftDiagIndex);
	
	
				//mutliplication rightDiagonal wise
				//flip the columns in a matrix and apply the same algo
				// make a new 2D grid
				int newTwoD[][] = new int[20][20];
				for(int y=0;y<20;y++) {
					for(int x=0;x<20;x++) {
						newTwoD[x][19-y] = twoD[x][y];
					}
				}
				
				System.out.println(Arrays.deepToString(newTwoD));
				
				int rightDiagUpProd=1,rightDiagDownProd=1,rightDiagMidProd=1,rightDiagMax=0;
				String rightDiagIndex=null;
				j=0;
				for(int start=16;start>=0;start--) {
					for(int row=start,col=0;row<20&&col<20;row++,col++) {
						if(row!=col) {
							rightDiagDownProd = rightDiagDownProd*newTwoD[row][col];
							rightDiagUpProd = rightDiagUpProd*newTwoD[col][row];
							j++;
							if(j==4) {
								j=0;
								if(rightDiagDownProd<rightDiagUpProd) {
									if(rightDiagMax<rightDiagUpProd) {
										rightDiagMax=rightDiagUpProd;
										rightDiagIndex="row:"+(col-3)+","+"col:"+(row-3);
									}
								}
								else {
									if(rightDiagMax<rightDiagDownProd) {
										rightDiagMax=rightDiagDownProd;
										rightDiagIndex="row:"+(row-3)+","+"col:"+(col-3);
									}
								}
								if(row!=19 && col!=19) { // check for border numbers in grid
									row=row-3;
									col=col-3;
								}
								rightDiagDownProd=1;
								rightDiagUpProd=1;
							}
						}
						else {
							rightDiagMidProd=rightDiagMidProd*newTwoD[row][col];
							j++;
							if(j==4) {
								j=0;
								if(rightDiagMax<rightDiagMidProd) {
									rightDiagMax=rightDiagMidProd;
									rightDiagIndex="row:"+(row-3)+","+"col:"+(col-3);
								}
								if(row!=19 && col!=19) { // check for border numbers in grid
									row=row-3;
									col=col-3;
								}
								rightDiagMidProd=1;
							}
						}
					}
				}
				System.out.println("Max prod in rightDiagonal: "+rightDiagMax+" at "+rightDiagIndex);
	}
}
