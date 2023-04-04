package com.khadri.hibernate.association.bi.one2one;

import javax.print.Doc;

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

		session.save(patient);

		Doctor doctor = new Doctor();
		doctor.setName("JHON");
		doctor.setPatient(patient);

		session.save(doctor);

		txn.commit();

	}
}
