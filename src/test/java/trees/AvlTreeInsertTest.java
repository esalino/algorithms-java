package trees;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AvlTreeInsertTest {

    @Test
    public void testMakeAnagrams() {
        Node root = null;
        int[] arr = { 14, 25, 21, 10, 23, 7, 26, 12, 30, 16, 19 };
        for (int i : arr) {
            root = AvlTreeInsert.insert(root, i);
        }
        StringBuffer result = new StringBuffer();
        createStringOfTree(root, result);
        assertEquals("21:3,14:2,10:1,7:0,12:0,16:1,19:0,25:2,23:0,26:1,30:0,", result.toString());
    }

    private void createStringOfTree(Node node, StringBuffer result) {
        if (node != null) {
            result.append(node.val + ":" + node.ht + ",");
            createStringOfTree(node.left, result);
            createStringOfTree(node.right, result);
        }
    }

}
