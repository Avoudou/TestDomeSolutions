package routePlanner;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SingleSelectionModel;

public class RoutePlanner {

	public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
		if (fromRow == toRow && fromColumn == toColumn) {
			return true;
		}
		int rightDistance = Integer.MAX_VALUE;
		int downDistance = Integer.MAX_VALUE;
		int leftDistance = Integer.MAX_VALUE;
		int upDistance = Integer.MAX_VALUE;
		
		
		if(fromColumn<mapMatrix[0].length-1 && mapMatrix[fromRow][fromColumn+1]==true) {
			rightDistance=evaluateDistance(fromRow, fromColumn+1, toRow, toColumn);
		}
		if(fromRow<mapMatrix.length-1 && mapMatrix[fromRow+1][fromColumn]==true) {
			downDistance=evaluateDistance(fromRow+1, fromColumn, toRow, toColumn);
		}
		if(fromColumn>0 && mapMatrix[fromRow][fromColumn-1]==true) {
			rightDistance=evaluateDistance(fromRow, fromColumn-1, toRow, toColumn);
		}
		if(fromRow>0 && mapMatrix[fromRow-1][fromColumn]==true) {
			downDistance=evaluateDistance(fromRow-1, fromColumn, toRow, toColumn);
		}

		
		int[] distances = new int[] { rightDistance, downDistance, leftDistance, upDistance };
	
		
		int[] distancesToSortRaw = new int[] { rightDistance, downDistance, leftDistance, upDistance };
		Arrays.sort(distancesToSortRaw);
		
		
		//System.out.println("best guess "+ find(distances, distancesToSortRaw[0]));

		if (find(distances, distancesToSortRaw[0]) == 0) {
			return routeExists(fromRow, fromColumn + 1, toRow, toColumn, mapMatrix);
		} 
		if (find(distances, distancesToSortRaw[0]) == 1) {
			
			return routeExists(fromRow + 1, fromColumn, toRow, toColumn, mapMatrix);

		} 
		if (find(distances, distancesToSortRaw[0]) == 2) {
			return routeExists(fromRow, fromColumn - 1, toRow, toColumn, mapMatrix);
		} 
		if (find(distances, distancesToSortRaw[0]) == 3) {
			return routeExists(fromRow - 1, fromColumn, toRow, toColumn, mapMatrix);
		}

		return false;
	}

	public static void main(String[] args) {
		boolean[][] mapMatrix = { { true, false, false }, { true, true, false }, { false, true, true } };

		System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
	}

	public static int evaluateDistance(int fromRow, int fromColumn, int toRow, int toColumn) {
		return toRow + toColumn - fromRow - fromColumn;
	}
	public static int find(int[] array, int value) {
	    for(int i=0; i<array.length; i++) { 
	         if(array[i] == value) {
	             return i;
	             }
	    }
	    return -1;
	}
}
