

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	GradeBook g1;


	@Before
	public void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(75);

	}

	@After
	public void tearDown() throws Exception {
		g1 = null;

	}

	@Test
	public void testAddScore() {
		assertEquals(true, g1.addScore(50));
	}

	@Test
	public void testGetScoreSize() {
		assertEquals(5, g1.getScoreSize(), .0001);
	}

	@Test
	public void testSum() {
		assertEquals(125, g1.sum(), .0001);

	}
	@Test
	public void testMinimum() {
		assertEquals(50, g1.minimum(), .001);
	}

	@Test
	public void testFinalScore() {
		assertEquals(75,g1.finalScore(), 0.01);
	}

	@Test
	public void testToString() {
		
		assertTrue(g1.toString().equals("50.0 75.0 "));

	}

}
