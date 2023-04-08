package com.khadri.hibernate.association.one2one.bi;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.Session;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainSelectByFind {

	public static void main(String[] args) {

		Class<Doctor> classObj1 = Doctor.class;
		Class<Patient> classObj2 = Patient.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		
		//Doctor to Patient Fetch
		Doctor doctor = session.find(Doctor.class,
				UUID.fromString("808495f4-d322-4aa9-8453-50472c83d218"));

	 

		Optional.ofNullable(doctor).ifPresentOrElse((d) -> {

			System.out.println("============ Doctor Information ============");
			System.out.println("Doctor UUID : " + d.getId());
			System.out.println("Doctor NAME : " + d.getName());

			System.out.println("============ Patient Information ============");
			System.out.println("Patient UUID : " + d.getPatient().getId());
			System.out.println("Patient NAME : " + d.getPatient().getName());
			System.out.println("Patient OP : " + d.getPatient().getOp());
			System.out.println(
					"Patient DISEASE : " + d.getPatient().getDisease());

		},()->{System.out.println("No Record Found");}); 

	
	//Patient to Doctor Fetch
	Patient patient = session.find(Patient.class,
					UUID.fromString("f8bf1dd9-66c5-41ae-83dd-3747f43bf451"));

		 

			Optional.ofNullable(patient).ifPresentOrElse((p) -> {
				
				System.out.println("============ Patient Information ============");
				System.out.println("Patient UUID : " + p.getId());
				System.out.println("Patient NAME : " + p.getName());
				System.out.println("Patient OP : " + p.getOp());
				System.out.println(
						"Patient DISEASE : " + p.getDisease());
				
				
				System.out.println("============ Doctor Information ============");
				System.out.println("Doctor UUID : " +p.getDoctor().getId());
				System.out.println("Doctor NAME : " + p.getDoctor().getName());


			},()->{System.out.println("No Record Found");}); 

		}
}
