package org.czareg.codewars.minutes.to.midnight;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinuteTest {

    @Test
    void exampleTests() {
        Minute m = new Minute();
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date d = cal.getTime();
        assertEquals("720 minutes", m.countMinutes(d));

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        d = cal.getTime();
        assertEquals("1 minute", m.countMinutes(d));
    }

    @Test
    void randomTests() {
        Minute m = new Minute();
        Date[] dates = new Date[100];
        for (int i = 0; i < 100; i++) {
            dates[i] = getRandomDate();
        }
        for (Date date : dates) {
            assertEquals(countDown(date), m.countMinutes(date));
        }
    }

    public String countDown(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long timeDifference = calendar.getTimeInMillis() - d.getTime();
        long minutes = timeDifference / (1000 * 60);
        return minutes == 1 ? minutes + " minute" : minutes + " minutes";
    }

    public Date getRandomDate() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, (int) (Math.random() * 24));
        cal.set(Calendar.MINUTE, (int) (Math.random() * 60));
        cal.set(Calendar.SECOND, (int) (Math.random() * 60));
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}