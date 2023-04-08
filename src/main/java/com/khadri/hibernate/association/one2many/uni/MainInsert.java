package com.khadri.hibernate.association.one2many.uni;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainInsert {

	public static void main(String[] args) {

		Class<?> classObj1 = School.class;
		Class<?> classObj2 = Student.class;
		Class<?> classObj3 = HeadMaster.class;

		Session session = StandardRegistryUtil.createSession(classObj1,
				classObj2,classObj3);

		Transaction txn = session.beginTransaction();

		List<Student> list = new ArrayList<>();

		Student sd1 = new Student();
		sd1.setName("ALLEN");
		sd1.setGrade("X-class");

		session.save(sd1);

		Student sd2 = new Student();
		sd2.setName("COSTIN");
		sd2.setGrade("IX-class");

		session.save(sd2);

		Student sd3 = new Student();
		sd3.setName("SREE-LEELA");
		sd3.setGrade("IIX-class");

		session.save(sd3);

		list.add(sd1);
		list.add(sd2);
		list.add(sd3);

		HeadMaster master = new HeadMaster();
		master.setName("VIJAY");
		master.setAge(27);

		session.save(master);

		School school = new School();
		school.setName("KHADRI");
		school.setRegNumber("123456");
		school.setAddress("KADIRI");
		school.setStudent(list);
		school.setHeaderMaster(master);

		session.save(school);

		txn.commit();

	}
}
