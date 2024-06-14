import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(13);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(15);
        int start = 6;
        int dest = 15;
        String expected = "UURR";
        String actual = new Solution().getDirections(root, start, dest);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.right = new TreeNode(2);
        int start = 2;
        int dest = 1;
        String expected = "UUUU";
        String actual = new Solution().getDirections(root, start, dest);

        Assert.assertEquals(expected, actual);



    }
}
