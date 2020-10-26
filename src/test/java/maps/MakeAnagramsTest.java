package maps;

import org.junit.Test;
import static org.junit.Assert.*;

public class MakeAnagramsTest {

    @Test
    public void testMakeAnagrams() {
        final int result = MakeAnagrams.makeAnagrams("cde", "abc");
        assertEquals(4, result);
    }

}
