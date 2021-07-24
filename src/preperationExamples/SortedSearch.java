package preperationExamples;

public class SortedSearch {

	public static int countNumbers(int[] sortedArray, int lessThan) {
		if (sortedArray[sortedArray.length - 1] < lessThan) {
			// System.out.println("???");
			return sortedArray.length;
		}
		if (sortedArray[0] > lessThan) {
			return 0;
		}

		int startIndex = 0;
		int endIndex = sortedArray.length - 1;
		int midIndex = 0;

		while (endIndex-startIndex>0) {
			
			if (sortedArray[midIndex] >= lessThan) {

				midIndex = startIndex + ((endIndex - startIndex) / 2);
				endIndex = midIndex;
			} else {

				midIndex = endIndex - ((endIndex - startIndex) / 2);
				startIndex = midIndex;

			}
			//System.out.println(midIndex);
			if(sortedArray[midIndex]==lessThan) {
				return midIndex;
			}

		}

		return midIndex;
	}

	public static void main(String[] args) {
		// System.out.println("result " + SortedSearch.countNumbers(new int[] { 0, 1, 2,
		// 3, 4, 5, 6, 7, 8, 9,10 ,11,12,13,14,15 }, 6));
		System.out.println("result " + SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
	}

	// public static int countNumbers(int[] sortedArray, int lessThan) {
	//
	// int randomIndex = 0;
	// int repeatTimes = Math.max(2, (sortedArray.length / 2));
	// //System.out.println(repeatTimes);
	//
	// int startIndex = 0;
	// int endIndex = sortedArray.length - 1;
	//
	// for (int i = 0; i < repeatTimes; i++) {
	// randomIndex = (int) (Math.random() * sortedArray.length) ;
	// if (sortedArray[randomIndex] == lessThan) {
	// return randomIndex;
	// }
	// if (sortedArray[randomIndex] < lessThan && randomIndex > startIndex) {
	// startIndex = randomIndex;
	// }
	// if (sortedArray[randomIndex] > lessThan && randomIndex < endIndex) {
	// endIndex = randomIndex;
	// }
	// System.out.println("startindex "+startIndex);
	// System.out.println("endIndex " +endIndex);
	// }
	//
	// for (int j = 0; j < endIndex - startIndex+1; j++) {
	// if (sortedArray[startIndex + j] >= lessThan) {
	// return startIndex + j;
	// }
	// }
	//
	//
	// if(sortedArray[sortedArray.length-1]<lessThan) {
	// System.out.println("???");
	// return sortedArray.length;
	// }
	//
	//
	// return 0;
	// }

}