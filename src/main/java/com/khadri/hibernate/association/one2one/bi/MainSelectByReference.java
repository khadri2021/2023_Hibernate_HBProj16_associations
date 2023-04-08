package com.khadri.hibernate.association.one2one.bi;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import com.khadri.hibernate.boot.exception.KhadriException;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainSelectByReference {

	public static void main(String[] args) {

		Class<Doctor> classObj1 = Doctor.class;
		Class<Patient> classObj2 = Patient.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		Doctor doctor = session.byId(Doctor.class).getReference(
				UUID.fromString("a8e9c957-bae4-4438-9412-a36bb8ded6ca"));

		Optional.ofNullable(doctor).ifPresent((d) -> {
			System.out.println("============ Doctor Information ============");
			System.out.println("Doctor UUID : " + d.getId());
			System.out.println("Doctor NAME : " + d.getName());

			System.out.println("============ Patient Information ============");
			System.out.println("Patient UUID : " + d.getPatient().getId());
			System.out.println("Patient NAME : " + d.getPatient().getName());
			System.out.println("Patient OP : " + d.getPatient().getOp());
			System.out.println(
					"Patient DISEASE : " + d.getPatient().getDisease());
		});

		try {
			// passing invalid patient uuid, expected is no record found
			// getreference always fetch proxy object and throw error if not
			// found reference.
			Patient patient = session.byId(Patient.class).getReference(
					UUID.fromString("a8e9c957-bae4-4438-9412-a36bb8ded6ca"));

			Optional.ofNullable(patient).ifPresent((p) -> {
				System.out.println(
						"============ Patient Information ============");
				System.out.println("Patient UUID : " + p.getId());
				System.out.println("Patient NAME : " + p.getName());
				System.out.println("Patient OP : " + p.getOp());
				System.out.println("Patient DISEASE : " + p.getDisease());

				System.out.println(
						"============ Doctor Information ============");
				System.out.println("Doctor UUID : " + p.getDoctor().getId());
				System.out.println("Doctor NAME : " + p.getDoctor().getName());

			});

		} catch (ObjectNotFoundException onf) {
			throw new KhadriException("No Record Found");
		}
		
	}
}
