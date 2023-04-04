package com.khadri.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.khadri.hibernate.association.one2one.uni.Adhaar;
import com.khadri.hibernate.association.one2one.uni.Citizen;

public class StandardRegistryUtil {

	private static SessionFactory factory;
	private static Session session;

	public static Session createSession(Class<?> classObj1,
			Class<?> classObj2) {

		BootstrapServiceRegistry bootstrapServiceRegistry = new BootstrapServiceRegistryBuilder()
				.build();

		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder(
				bootstrapServiceRegistry).build();

		factory = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(classObj1).addAnnotatedClass(classObj2)
				.buildMetadata().buildSessionFactory();

		session = factory.openSession();

		return session;
	}

	public static void closeResources() {
		session.close();
		factory.close();
	}

}
