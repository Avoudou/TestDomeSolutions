package preperationExamples;

import java.util.ArrayList;
import java.util.Collection;

public class Folders {
	public static Collection<String> folderNames(String xml, char startingLetter) {
		
		Collection<String> results = new ArrayList<String>();

		ArrayList<Integer> folderIndexes = new ArrayList<>();
		int nextFolderIndex = -10;
		int n = 0;
		while (nextFolderIndex != -1) {
 
			nextFolderIndex = ordinalIndexOf(xml, "<folder name=\"", n);
		//	System.out.println("adding index "+ nextFolderIndex);
			folderIndexes.add(nextFolderIndex);
			n++;
		}
		
		
		for(int i=0;i<folderIndexes.size()-1;i++) {
			String candidate = xml.substring(folderIndexes.get(i)+1);
//			System.out.println(candidate.substring(13,14));
//			System.out.println(String.valueOf(startingLetter));
			System.out.println(candidate.substring(13,14).equals(String.valueOf(startingLetter)));
			if(candidate.substring(13,14).equals(String.valueOf(startingLetter))) {
				int endPoint= ordinalIndexOf(candidate,"\"",1);
				String resultString=candidate.substring(13, endPoint);
				//System.out.println(resultString);
				results.add(resultString);
				
			}
		}
//System.out.println(folderIndexes.get(folderIndexes.size()-1));
		return results;
	}

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"u\">" +
                    "<folder name=\"urogram files\">" +
                        "<folder name=\"uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }

	public static int ordinalIndexOf(String str, String substr, int n) {
		int pos = -1;
		do {
			pos = str.indexOf(substr, pos + 1);
		} while (n-- > 0 && pos != -1);
		return pos;
	}
}