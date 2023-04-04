package com.khadri.hibernate.association.one2one.uni;

import java.util.Random;

public class AdhaarGenerator {

	public static String generateAdhaar() {

		Random random = new Random();

		long nextLong = random.nextLong();
		if (nextLong < 0) {
			nextLong = nextLong * -1;
//			System.out.println(nextLong);
		}

		String convertedString = String.valueOf(nextLong);
		String subStringAdhaar = convertedString.substring(0, 12);

//		System.out.println(subStringAdhaar);

		StringBuffer stringBuffer = new StringBuffer(subStringAdhaar);

		stringBuffer.insert(4, "-");

//		System.out.println(stringBuffer);

		stringBuffer.insert(9, "-");

		System.out.println(stringBuffer);

		return stringBuffer.toString();

	}
}
