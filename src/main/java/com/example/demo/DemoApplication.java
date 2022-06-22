package com.example.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	protected static int numberOfFridaysInBetweenDeliveryDate(final Date deliveryEstimateDate)
	{
		int fridayCount = 0;
		LocalDate localDateFriday = LocalDate.now();
		final LocalDate localDateDeliveryEstimate = deliveryEstimateDate.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		if (localDateFriday.getDayOfWeek().equals(DayOfWeek.FRIDAY))
		{
			fridayCount++;
		}
		localDateFriday = localDateFriday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		while (localDateFriday.compareTo(localDateDeliveryEstimate) <= 0)
		{
			fridayCount++;
			localDateFriday = localDateFriday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		}
		return fridayCount;
	}

	private static List<LocalDate> countBusinessDaysBetween_Java8(final LocalDate startDate, final LocalDate endDate,
			final Optional<List<LocalDate>> holidays) {
		// Validate method arguments
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("Invalid method argument(s) to  countBusinessDaysBetween (" + startDate
					+ "," + endDate + "," + holidays + ")");
		}

		// Predicate 1: Is a given date is a holiday
		Predicate<LocalDate> isHoliday = date -> holidays.isPresent() && holidays.get().contains(date);

		// Predicate 2: Is a given date is a weekday
		Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
				|| date.getDayOfWeek() == DayOfWeek.SUNDAY;

		// Get all days between two dates
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

		// Iterate over stream of all dates and check each day against any weekday or
		// holiday
		return Stream.iterate(startDate, date -> date.plusDays(1)).limit(daysBetween)
				.filter(isHoliday.or(isWeekend).negate()).collect(Collectors.toList());
	}
	
	

	public static void main(String[] args) {
		
		LocalDate start = LocalDate.of( 2025 , 02 , 21 );
		LocalDate end = LocalDate.of( 2025 , 02 , 27);
		
		List<LocalDate> dates = new ArrayList<>();
		LocalDate s1 = LocalDate.of( 2025 , 02 , 22 );
		dates.add(s1);
		Optional<List<LocalDate>> holidays=Optional.ofNullable(dates);
		List<LocalDate> ss=countBusinessDaysBetween_Java8(start,end,holidays);
		//System.out.println(ss);
		
		LocalDate localDate = LocalDate.now();
		//System.out.println("localDate : "+localDate);
		
		
		final LocalTime currentTime = LocalTime.parse("10:00");
		
		//System.out.println("localDate : "+currentTime);
		
		//System.out.println(numberOfFridaysInBetweenDeliveryDate(new Date()));
		System.out.println(new Date());
		System.out.println(LocalTime.now());
		
		boolean b=LocalTime.ofNanoOfDay(new Date().getTime()).isBefore(LocalTime.parse("10:00"));
		//LocalTime.parse(ffs.getDeliveryCutoffTime()).isBefore(LocalTime.parse("07:30"));
		
		System.out.println(b);
		String s=null;
		System.out.println(Objects.nonNull(s.toString()));

	}

}
