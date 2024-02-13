package com.Cosmoslots.website;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class demo2 {
	public static void main(String[] args) throws InterruptedException {
//		
//		System.out.println("Hello World");
//		// Get today's date
//		 // Get today's date
//        LocalDate today = LocalDate.now();
//        System.out.println("Today: " + today);
//
//        // Get yesterday's date
//        LocalDate yesterday = today.minusDays(1);
//        System.out.println("Yesterday: " + yesterday);
//
//        // Get the start and end date of the current week
//        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
//        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
//        System.out.println("This week - Start Date: " + startOfWeek + ", End Date: " + endOfWeek);
//
//        // Get the start and end date of the last week
//        LocalDate startOfLastWeek = startOfWeek.minusDays(7);
//        LocalDate endOfLastWeek = endOfWeek.minusDays(7);
//        System.out.println("Last week - Start Date: " + startOfLastWeek + ", End Date: " + endOfLastWeek);
				        DateRange dateRange = getDateRange();
		        
		        System.out.println("Today: " + dateRange.getToday());
		        System.out.println("Yesterday: " + dateRange.getYesterday());
		        System.out.println("This week - Start Date: " + dateRange.getStartOfWeek() + ", End Date: " + dateRange.getEndOfWeek());
		        System.out.println("Last week - Start Date: " + dateRange.getStartOfLastWeek() + ", End Date: " + dateRange.getEndOfLastWeek());
		    }

		    public static DateRange getDateRange() {
		        LocalDate today = LocalDate.now();
		        LocalDate yesterday = today.minusDays(1);
		        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
		        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
		        LocalDate startOfLastWeek = startOfWeek.minusDays(7);
		        LocalDate endOfLastWeek = endOfWeek.minusDays(7);

		        return new DateRange(today, yesterday, startOfWeek, endOfWeek, startOfLastWeek, endOfLastWeek);
		    }

		    static class DateRange {
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

		        public LocalDate getStartOfWeek() {
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



