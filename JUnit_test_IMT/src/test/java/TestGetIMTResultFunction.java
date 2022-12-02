import org.junit.Assert;
import org.junit.Test;

public class TestGetIMTResultFunction {

    //проверка работы функции при нулевом значении параметра "рост"
    @Test
    public void checkNullHeight() {

        Assert.assertEquals("указан некорректный рост", getIMTResult(0f, 65f));
    }

    //проверка работы функции при превышении максимально возможного значения параметра "рост"
    @Test
    public void checkUpperHeightLimit() {

        Assert.assertEquals("указан некорректный рост", getIMTResult(351f, 456f));
    }

    //проверка работы функции при нулевом значении параметра "вес"
    @Test
    public void checkNullMass() {

        Assert.assertEquals("указан некорректный вес", getIMTResult(164f, 0f));
    }

    //проверка работы функции при превышении максимально возможного значения параметра "вес"
    @Test
    public void checkUpperMassLimit() {

        Assert.assertEquals("указан некорректный вес", getIMTResult(159f, 1001f));
    }

    //проверка правильности работы функции при ИМТ = 16
    @Test
    public void checkUserIndex16() {

        Assert.assertEquals("выраженному дефициту массы тела", getIMTResult(175f, 49f));
    }

    //проверка правильности вычисления выраженного дефицита массы тела
    @Test
    public void checkVeryLowMass() {

        Assert.assertEquals("выраженному дефициту массы тела", getIMTResult(189f, 53f));
    }

    //проверка правильности вычисления недостаточной массы тела
    @Test
    public void checkLowMass() {

        Assert.assertEquals("недостаточной массе тела", getIMTResult(168f, 50f));
    }

    //проверка правильности вычисления нормальной массы тела
    @Test
    public void checkNormalMass() {

        Assert.assertEquals("нормальной массе тела", getIMTResult(195f, 90f));
    }

    //проверка правильности работы функции при ИМТ = 19
    @Test
    public void checkUserIndex19() {

        Assert.assertEquals("нормальной массе тела", getIMTResult(178f, 60f));
    }

    //проверка правильности вычисления избыточной массы тела
    @Test
    public void checkVeryLargeMass() {

        Assert.assertEquals("избыточной массе тела", getIMTResult(177f, 90f));
    }

    //проверка правильности работы функции при ИМТ = 25
    @Test
    public void checkUserIndex25() {

        Assert.assertEquals("избыточной массе тела", getIMTResult(180f, 81f));
    }
    private String getIMTResult(Float heightCm, Float weightKg) {

        long userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));

        String userResult = null;

        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        }
        else if (userIndex > 16 && (userIndex < 19)) {
            userResult = "недостаточной массе тела";
        }
        else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        }
        else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }

        if (heightCm.equals(0.0f)) userResult += "указан некорректный рост";

        return userResult;
    }
}