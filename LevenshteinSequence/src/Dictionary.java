import java.io.*;
import java.util.*;

public class Dictionary{
	
	public ArrayList<String> createDictionary() {
		ArrayList<String> aListWords = new ArrayList<String>();
		try {
			String filename = "src/dictionary.txt";
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String s;
			String word = null;
			
			int j = 0;
			while ((s = br.readLine()) != null) {
				Scanner scan = new Scanner(s);
				while (scan.hasNext()) {
					word = scan.next().toLowerCase();
					aListWords.add(word);
					j++;
				}
				scan.close();
			}
			br.close();
			fr.close();
			removeDuplicates(aListWords);
			Collections.sort(aListWords);
			int size = aListWords.size();
			for (int i = 0; i < size; i++) {
				// originally for making sure the dictionary gets read correctly.
				//System.out.println(aListWords.get(i));
			}
			System.out.println(j + " entries in the Dictionary! (including duplicates)");
			return aListWords;
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally {
			// System.out.println(aListWords);
		}
		return aListWords;
	}

	// This isn't really necessary because the dictionary has no duplicates
	// Leaving it in because users might have a different dictionary file.
	public void removeDuplicates(ArrayList aList) {
		HashSet h = new HashSet(aList);
		aList.clear();
		aList.addAll(h);
	}
}