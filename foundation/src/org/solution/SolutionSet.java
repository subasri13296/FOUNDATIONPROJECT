package org.solution;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SolutionSet {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		sf.close();
	}

}
