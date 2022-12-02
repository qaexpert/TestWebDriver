import org.junit.Assert;
import org.junit.Test;

/* Ученик может заработать максимум 100 баллов, минимум 0.
Его оценка за экзамен может принимать значения 2, 3, 4 или 5.
Если ученик получил за экзамен
от 0 баллов (включительно) до 35 (включительно): его оценка равна 2;
от 36 баллов (включительно) до 56 (включительно): его оценка равна 3;
от 57 баллов (включительно) до 71 (включительно): его оценка равна 4;
от 72 баллов (включительно) до 100 баллов (включительно): его оценка равна 5. */
public class TestFunctionGetMarkResult {
    @Test
    public void checkNegativeValue() {
        Assert.assertEquals("no mark result", getMarkResult(-1));
    }
    @Test
    public void checkValueOverMaxLimit() {
        Assert.assertEquals("no mark result", getMarkResult(101));
    }
    @Test
    public void checkLowerLimitForMark2() {
        Assert.assertEquals("2", getMarkResult(0));
    }
    @Test
    public void checkLowerLimitForMark3() {
        Assert.assertEquals("3", getMarkResult(36));
    }
    @Test
    public void checkLowerLimitForMark4() {
        Assert.assertEquals("4", getMarkResult(57));
    }
    @Test
    public void checkLowerLimitForMark5() {
        Assert.assertEquals("5", getMarkResult(72));
    }
    @Test
    public void checkUpperLimitForMark2() {
        Assert.assertEquals("2", getMarkResult(35));
    }
    @Test
    public void checkUpperLimitForMark3() {
        Assert.assertEquals("3", getMarkResult(56));
    }
    @Test
    public void checkUpperLimitForMark4() {
        Assert.assertEquals("4", getMarkResult(71));
    }
    @Test
    public void checkUpperLimitForMark5() {
        Assert.assertEquals("5", getMarkResult(100));
    }
    private String getMarkResult(Integer mark) {

        if (mark >= 0 && mark <= 35) return "2";

        if (mark > 35 && mark <= 56) return "3";

        if (mark > 56 && mark < 71) return "4";

        if (mark > 72 && mark < 100) return "5";

        return "no mark result";

    }

}

