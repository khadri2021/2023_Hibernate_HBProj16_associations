package com.khadri.hibernate.association.many2many.uni;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class Main {

	public static void main(String[] args) {
		Class<?> classObj1 = Employee.class;
		Class<?> classObj2 = Project.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2);

		Transaction txn = session.beginTransaction();

		Project p1 = new Project();
		p1.setName("Payment");
		session.save(p1);

		Project p2 = new Project();
		p2.setName("Payment");
		session.save(p2);

		Employee e1 = new Employee();
		e1.setName("JHON");
		e1.addProjects(List.of(p1, p2));
		session.save(e1);

		Employee e2 = new Employee();
		e2.setName("JHON");
		e2.addProjects(List.of(p1, p2));
		session.save(e2);

		Employee e3 = new Employee();
		e3.setName("JHON");
		e3.addProjects(List.of(p1, p2));
		session.save(e3);

		txn.commit();
	}
}
