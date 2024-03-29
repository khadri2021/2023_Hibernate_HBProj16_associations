package com.khadri.hibernate.association.one2one.bi;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainInsert {

	public static void main(String[] args) {

		Class<Doctor> classObj1 = Doctor.class;
		Class<Patient> classObj2 = Patient.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		Transaction txn = session.beginTransaction();

		Patient patient = new Patient();
		patient.setName("ALLEN");
		patient.setDisease("COVID-19");
		patient.setOp(GenerateOP.createOP());

		Doctor doctor = new Doctor();
		doctor.setName("JHON");
		doctor.setPatient(patient);
		
		patient.setDoctor(doctor);
		session.save(patient);
		//session.save(doctor);

		txn.commit();

	}
}
