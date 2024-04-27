import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1(){
        String ring = "godding";
        String key = "gd";
        int expected = 4;
        int actual = new Solution().findRotateSteps(ring, key);

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void test2(){
        String ring = "godding";
        String key = "godding";
        int expected = 13;
        int actual = new Solution().findRotateSteps(ring, key);

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void test3(){
        String ring = "abcde";
        String key = "ade";
        int expected = 6;
        int actual = new Solution().findRotateSteps(ring, key);

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void test4(){
        String ring = "caotmcaataijjxi";
        String key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";
        int expected = 137;
        int actual = new Solution().findRotateSteps(ring, key);

        Assert.assertEquals(expected, actual);

    }
}
