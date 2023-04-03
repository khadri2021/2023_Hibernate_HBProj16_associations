package com.khadri.hibernate.association.uni.one2one;

import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainSelect {

	public static void main(String[] args) {
		Class<Citizen> classObj1 = Citizen.class;
		Class<Adhaar> classObj2 = Adhaar.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		NaturalIdLoadAccess<Citizen> naturalCitizen = session
				.byNaturalId(Citizen.class)
				.using("citizenName", "JHON");

		Citizen citizen = naturalCitizen.getReference();
		Adhaar adhaar = citizen.getAdhaar();

		System.out.println("CITIZEN UUID : " + citizen.getCitizenId());
		System.out.println("CITIZEN NAME : " + citizen.getCitizenName());

		System.out.println("ADHAAR UUID : " + adhaar.getAdhaarId());
		System.out.println("ADHAAR NUMBER : " + adhaar.getAdhaarNumber());
		System.out.println("ADHAAR COUNTRY : " + adhaar.getCountry());

	}
}
