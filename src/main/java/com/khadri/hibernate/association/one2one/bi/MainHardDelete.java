package com.khadri.hibernate.association.one2one.bi;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainHardDelete {

	public static void main(String[] args) {

		Class<Doctor> classObj1 = Doctor.class;
		Class<Patient> classObj2 = Patient.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		Transaction txn = session.beginTransaction();

		// Enable the below code for status insert operations

		//
		// Patient patient = new Patient();
		// patient.setDisease("General");
		// patient.setName("JACKAS");
		// patient.setOp(99L);
		// patient.setStatus("Active");
		//
		// session.save(patient);
		//
		// Doctor doctor = new Doctor();
		// doctor.setName("Ramnaih");
		// doctor.setStatus("Active");
		// doctor.setPatient(patient);
		//
		// // soft delete
		// session.save(doctor);

		// The below code is for hard delete operations

		Doctor existDoctor = session.find(Doctor.class,
				UUID.fromString("7e500066-0ed8-48ce-8260-d59f6433337e"));
		
		session.delete(existDoctor);

		txn.commit();

	}
}
