package preperationExamples;

import java.util.LinkedList;

public class TrainComposition {
	private LinkedList<Integer> list=new LinkedList<>();

	public void attachWagonFromLeft(int wagonId) {
		list.add(wagonId);

	}

	public void attachWagonFromRight(int wagonId) {
		list.addLast(wagonId);
	}

	public int detachWagonFromLeft() {
		
		return list.removeLast();
	}

	public int detachWagonFromRight() {
		
	return	list.removeFirst();
	}

	public static void main(String[] args) {
		  TrainComposition train = new TrainComposition();
	        train.attachWagonFromLeft(7);
	        train.attachWagonFromLeft(13);
	        train.attachWagonFromLeft(14);
	        train.attachWagonFromLeft(15);
	        System.out.println(train.detachWagonFromRight()); // 7 
	        System.out.println(train.detachWagonFromLeft()); // 13
	}


}