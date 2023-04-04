package com.khadri.hibernate.association.uni.one2one;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;

import com.khadri.hibernate.boot.exception.KhadriException;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainSelect {

	public static void main(String[] args) {
		Class<Citizen> classObj1 = Citizen.class;
		Class<Adhaar> classObj2 = Adhaar.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		getByNaturalId(session);

		getByReference(session);

		findByPrimaryKey(session);

	}

	private static void findByPrimaryKey(Session session) {
		Citizen citizen = session.find(Citizen.class,
				UUID.fromString("9567b745-c5ef-4897-9864-1d7ddf926af8"));

		processCitizen(citizen);

	}

	private static void getByReference(Session session) {
		Citizen citizen = session.byId(Citizen.class).getReference(
				UUID.fromString("69aeaf51-e3cd-4c7c-955d-c41250b605c8"));

		processCitizen(citizen);
	}

	private static void getByNaturalId(Session session) {
		NaturalIdLoadAccess<Citizen> naturalCitizen = session
				.byNaturalId(Citizen.class).using("citizenName", "JHON");

		Citizen citizen = naturalCitizen.getReference();

		processCitizen(citizen);
	}

	private static void processCitizen(Citizen citizen) {
		Optional.ofNullable(citizen).ifPresentOrElse((citi) -> {

			Adhaar adhaar = citi.getAdhaar();
			System.out.println("CITIZEN UUID : " + citi.getCitizenId());
			System.out.println("CITIZEN NAME : " + citi.getCitizenName());

			System.out.println("ADHAAR UUID : " + adhaar.getAdhaarId());
			System.out.println("ADHAAR NUMBER : " + adhaar.getAdhaarNumber());
			System.out.println("ADHAAR COUNTRY : " + adhaar.getCountry());

		}, () -> {
			throw new KhadriException("No Record Found");
		});
	}
}
