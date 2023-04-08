package com.khadri.hibernate.association.one2many.uni;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import com.khadri.hibernate.boot.exception.KhadriException;
import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainSelectByReference {

	public static void main(String[] args) {

		Class<?> classObj1 = School.class;
		Class<?> classObj2 = Student.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		try {
			School school = session.getReference(School.class,
					UUID.fromString("163251ef-6095-4b65-94bb-01013cdecf39"));

			Optional.ofNullable(school).ifPresent((sc) -> {
				System.out.println("====School Information ====");
				System.out.println("School UUID: " + sc.getId());
				System.out.println("School Name: " + sc.getName());
				System.out.println("School Address: " + sc.getAddress());
				System.out.println(
						"School Register Number: " + sc.getRegNumber());

				System.out.println("====Student Information ====");
				List<Student> listStds = sc.getStudent();

				listStds.stream().forEach((std) -> {
					System.out.println("Student UUID: " + std.getId());
					System.out.println("Student Name: " + std.getName());
					System.out.println("Student Grade: " + std.getGrade());
				});

			});
		} catch (ObjectNotFoundException e) {
			throw new KhadriException("No Record Found");
		}
	}
}
