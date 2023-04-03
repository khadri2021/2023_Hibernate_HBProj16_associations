package com.khadri.hibernate.association.uni.one2one;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainInsert {

	public static void main(String[] args) {
		Class<Citizen> classObj1 = Citizen.class;

		Class<Adhaar> classObj2 = Adhaar.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		Transaction txn = session.beginTransaction();

		Adhaar adhaar = new Adhaar();
		adhaar.setCountry("INDIA");
		adhaar.setAdhaarNumber(AdhaarGenerator.generateAdhaar());

		session.save(adhaar);

		Citizen citizen = new Citizen();
		citizen.setCitizenName("THORSTEN");
		citizen.setAdhaar(adhaar);// uni directional way

		session.save(citizen);

		txn.commit();

	}
}
