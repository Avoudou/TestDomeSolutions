package preperationExamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] findTwoSum(int[] list, int sum) {

		HashMap<Integer, Integer> map = new HashMap<>();
		// HashMap<Integer,Integer> dublicateMap= new HashMap<>();
		// for (int i = 0; i < list.length; i++) {
		// if(!map.containsKey(list[i])) {
		// map.put(Integer.valueOf(list[i]),i);
		// }else {
		// dublicateMap.put(Integer.valueOf(list[i]),i);
		// }
		// }
		//
		// Arrays.sort(list);
		//
		// for (int i = 0; i < list.length; i++) {
		// if(list[i]>sum) {
		// return null;
		// }
		// for (int j = i+1; j < list.length; j++) {
		// if (list[i] + list[j] == sum) {
		// int[] result = new int[2];
		// if(!dublicateMap.containsKey(list[i])) {
		// result[0] = map.get(list[i]);
		// result[1] = map.get(list[j]);
		// }else {
		// result[0] = map.get(list[i]);
		// result[1] = dublicateMap.get(list[j]);
		// }
		//// result[0] = i;
		//// result[1] = j;
		// return result;
		// }
		// }
		// }

		int[] indexList = new int[sum + 1];
		for (int i = 0; i < indexList.length; i++) {
			indexList[i] = -1;
		}

		for (int i = 0; i < list.length; i++) {

			int discover = sum - list[i];
			// System.out.println("loop coounter: "+i+" value "+list[i]);
			// System.out.println("discover "+ discover);
			// System.out.println(indexList[discover] + " discover index");
			if (discover < 0 || discover > sum) {

			} else if (indexList[discover] != -1) {
				int[] result = new int[2];
				result[0] = i;
				result[1] = indexList[discover];
				return result;

			} else {
				System.out.println("value added");
				indexList[sum - list[i]] = i;
			}
			System.out.println("indexArray ");
			printArray(indexList);
			System.out.println();
			System.out.println("list ");
			printArray(list);
		}

		return null;

	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 7, 9 }, 10);
		if (indices != null) {
			System.out.println("final result :" + indices[0] + " " + indices[1]);
		}
	}

	public static void printArray(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]);
		}
	}
	public static int[] findTwoSum1(int[] nums, int sum) {
		Map<Integer, Integer> valueToIndex = new HashMap<>();
		
		for (int i = 0; i < nums.length ; i++) {
			Integer index = valueToIndex.get(sum - nums[i]);
			if(index != null) {
				return new int[] {index, i };
			} else {
				if(valueToIndex.get(nums[i]) == null) {
					valueToIndex.put(nums[i], i);
				}
			}
		}
		return null;
	}

}