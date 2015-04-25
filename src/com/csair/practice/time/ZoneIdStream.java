package com.csair.practice.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Stream;
public class ZoneIdStream {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		Stream <String> zoneIdStream = ZoneId.getAvailableZoneIds().stream();
		zoneIdStream.forEach((x)->{
				ZonedDateTime zdt = ldt.atZone(ZoneId.of(x));
				System.out.println(x+" : " + zdt.getOffset());
			});
	}
}
