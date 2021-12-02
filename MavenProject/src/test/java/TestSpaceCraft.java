import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSpaceCraft {
	
	private SpaceCraft sc;

	@Before
	public void setUp() throws Exception {
		sc = new SpaceCraft();
	}

	@After
	public void tearDown() throws Exception {
		sc = null;
	}

	@Test
	public void testBurnRate() {
		int test_br = 15;
		sc.setBurnRate(test_br);
		
		assertEquals(sc.getBurnRate(), test_br);
	}

}
