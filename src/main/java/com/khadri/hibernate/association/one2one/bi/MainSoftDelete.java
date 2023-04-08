package com.khadri.hibernate.association.one2one.bi;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainSoftDelete {

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

		// The below code is for soft delete operations

		Doctor existDoctor = session.find(Doctor.class,
				UUID.fromString("27460f6c-7bcc-4bce-a2f4-c08763b66f70"));
		
		existDoctor.setStatus("In-Active");
		existDoctor.getPatient().setStatus("In-Active");
		
		session.update(existDoctor);

		txn.commit();

	}
}
