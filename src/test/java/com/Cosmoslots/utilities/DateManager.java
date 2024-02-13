/**
 * 
 */
package com.Cosmoslots.utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author shrikrushna.sonkar
 *
 */
public class DateManager {


    public static DateRange getDateRange() {
    	    LocalDate today = LocalDate.now();
	        LocalDate yesterday = today.minusDays(1);
	        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
	        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
	        LocalDate startOfLastWeek = startOfWeek.minusDays(7);
	        LocalDate endOfLastWeek = endOfWeek.minusDays(7);
        
        
        return new DateRange(today, yesterday, startOfWeek, endOfWeek, startOfLastWeek, endOfLastWeek);
    }

    public static class DateRange {
        private LocalDate today;
        private LocalDate yesterday;
        private LocalDate startOfWeek;
        private LocalDate endOfWeek;
        private LocalDate startOfLastWeek;
        private LocalDate endOfLastWeek;

        public DateRange(LocalDate today, LocalDate yesterday, LocalDate startOfWeek, LocalDate endOfWeek,
                         LocalDate startOfLastWeek, LocalDate endOfLastWeek) {
            this.today = today;
            this.yesterday = yesterday;
            this.startOfWeek = startOfWeek;
            this.endOfWeek = endOfWeek;
            this.startOfLastWeek = startOfLastWeek;
            this.endOfLastWeek = endOfLastWeek;
        }

        public LocalDate getToday() {
            return today;
        }

        public LocalDate getYesterday() {
            return yesterday;
        }

        public LocalDate getStartOfThisWeek() {
            return startOfWeek;
        }

        public LocalDate getEndOfWeek() {
            return endOfWeek;
        }

        public LocalDate getStartOfLastWeek() {
            return startOfLastWeek;
        }

        public LocalDate getEndOfLastWeek() {
            return endOfLastWeek;
        }
    }
}
