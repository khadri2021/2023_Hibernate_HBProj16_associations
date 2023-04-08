package com.khadri.hibernate.association.one2many.bi;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.khadri.hibernate.util.StandardRegistryUtil;

public class MainInsert {

	public static void main(String[] args) {

		Class<?> class1 = Bus.class;
		Class<?> class2 = Passenger.class;

		Session session = StandardRegistryUtil.createSession(class1, class2);

		Transaction txn = session.beginTransaction();

		Bus bus = new Bus();
		bus.setBusNo("1234");
		bus.setSource("KDR");
		bus.setDestination("ATP");

		Passenger p1 = new Passenger();
		p1.setTicketNumber(geneTicketNumber());
		p1.setBus(bus);

		session.save(p1);

		Passenger p2 = new Passenger();
		p2.setTicketNumber(geneTicketNumber());
		p2.setBus(bus);

		session.save(p2);

		// List<Passenger> list = new ArrayList<>();
		// list.add(p1);
		// list.add(p2);

		bus.setListPassenger(List.of(p1, p2));

		session.save(bus);

		txn.commit();

	}

	private static String geneTicketNumber() {

		// Random random = new Random();
		//
		// int nextInt = random.nextInt();
		//
		// if (nextInt < 0) {
		// nextInt = nextInt * -1;
		// }
		//
		// String ticketNumber = String.valueOf(nextInt).substring(0, 1);
		//
		Optional<String> ticketNumber = new Random().ints(1L).map((no) -> {
			return no < 0 ? no * -1 : no;
		}).mapToObj((positiveNo) -> {
			return String.valueOf(positiveNo).substring(0, 1);
		}).findFirst();

		return "KDR-ATP" + ticketNumber;
	}
}
