import static org.junit.Assert.*;
import org.junit.Test;

public class WordOperationsTest {
	WordOperations wo = new WordOperations();
	Dictionary d = new Dictionary();


	@Test
	public void testDeleteLetter() {
		//assertEquals("", wo.deleteLetter("i", 0));
		assertEquals("pen", wo.deleteLetter("pent", 3));
	}

	@Test
	public void testAddLetter() {
		assertEquals("i", wo.addLetter("", 0, 'i'));
		assertEquals("the", wo.addLetter("he", 0, 't'));
	}
	
	public void testReplaceLetter() {
		assertEquals("pie", wo.replaceLetter("tie", 0, 'p'));
	}

	@Test
	public void testIsWord() {
		assertTrue(wo.isWord("apple"));
		assertFalse(wo.isWord("deez"));
	}

	@Test
	public void testComputeDistance() {
		assertEquals(4, wo.computeDistance("team", "mate"));
		assertNotEquals(3, wo.computeDistance("team", "mate"));
		assertEquals(0, wo.computeDistance("team", "team"));
		assertNotNull(wo.computeDistance("", ""));
	}

	@Test
	public void testIsAnagram() {
		// if the two strings are of equal length, then they pass
		assertTrue(wo.isAnagram("team", "mate"));
		assertTrue(wo.isAnagram("", ""));
		assertTrue(wo.isAnagram("a", "a"));
		assertFalse(wo.isAnagram("a", "b"));
		assertFalse(wo.isAnagram("ab", "abc"));
	}

}
