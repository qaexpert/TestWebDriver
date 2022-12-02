import org.junit.Assert;
import org.junit.Test;

/* В случае отказа от посещения мероприятия по причинам,
не связанным с отменой/переносом мероприятия,
посетитель имеет право при возврате билета:
1) За 10 и более дней — получить обратно полную стоимость билета.
2) От 6 до 10 дней включительно — получить 50% стоимости билета.
3) От 3 до 5 дней включительно — получить 30% стоимости билета.
4) За 72 часа и менее до начала концерта — стоимость билета не возвращается. */

public class TestFunctionGetRefundTicketPricePercent {
    @Test
    public void testConcertCancelled() {
        int actualResult = getRefundTicketPricePercent(0, true, false);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void testConcertRescheduled() {
        int actualResult = getRefundTicketPricePercent(0, false, true);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void testConcertCancelledConcertRescheduled() {
        int actualResult = getRefundTicketPricePercent(0, true, true);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void testReturnOver10Days() {
        int actualResult = getRefundTicketPricePercent(264, false, false);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void testReturn10Days() {
        int actualResult = getRefundTicketPricePercent(240, false, false);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void testReturn6Days() {
        int actualResult = getRefundTicketPricePercent(144, false, false);
        Assert.assertEquals(50, actualResult);
    }

    @Test
    public void testReturn5Days() {
        int actualResult = getRefundTicketPricePercent(120, false, false);
        Assert.assertEquals(30, actualResult);
    }

    @Test
    public void testReturn3Days() {
        int actualResult = getRefundTicketPricePercent(72, false, false);
        Assert.assertEquals(30, actualResult);
    }

    @Test
    public void testReturnLessThan3Days() {
        int actualResult = getRefundTicketPricePercent(60, false, false);
        Assert.assertEquals(0, actualResult);
    }

    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        if (wasConcertCancelled && wasConcertRescheduled) return 100;
        if (hoursBeforeConcert > 240) return 100;
        if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if (hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }

}
