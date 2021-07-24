package preperationExamples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Song {
	private String name;
	private Song nextSong;

	public Song(String name) {
		this.name = name;
	}

	public void setNextSong(Song nextSong) {
		this.nextSong = nextSong;
	}

	public Song getNextSong() {
		return this.nextSong;
	}

	public String getSongName() {
		return this.name;
	}

	public boolean isRepeatingPlaylist() {

		HashSet<String> set = new HashSet<>();

		return isRepeatingPlaylist(set, this);
	}

	public boolean isRepeatingPlaylist(HashSet<String> set, Song song) {

		if (set.contains(song.getSongName())) {
			return true;
		}
		if (song.nextSong == null) {
			return false;
		}

		set.add(song.getSongName());

		return isRepeatingPlaylist(set, song.getNextSong());

	}
	

	public static int[] findTwoSum(int[] list, int sum) {
		
		HashMap<Integer,Integer> map= new HashMap<>();
		
		Arrays.sort(list);
//		for (int i = 0; i < list.length; i++) {
//			if((list[i]>sum )) {
//				return null;
//			}
//		}
		for (int i = 0; i < list.length; i++) {
			if((list[i]>sum )) {
				return null;
			}
			for (int j = i; j < list.length; j++) {
				
				//System.out.println(list[i]+" "+list[j]);
				if (list[i] + list[j] == sum && i!=j) {
					int[] result = new int[2];
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return null;

	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] { 5, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
	}
}