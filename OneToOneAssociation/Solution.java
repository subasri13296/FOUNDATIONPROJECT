package org.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SolutionSet {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		session.beginTransaction();
		
		UserCredential steve = new UserCredential();
		UserProfile prof1 = new UserProfile();
		
		steve.setUserName("suba");
		steve.setPassword("suba");
		steve.setStatus(1);
	
		prof1.setFirstName("Suba");
		prof1.setLastName("SRI");
		prof1.setEmail("suba@doc.com");
		prof1.setPhone(125478935);
		
		steve.setProfile(prof1);
		prof1.setCredential(steve);
		
		session.save(steve);
		session.save(prof1);
		session.getTransaction().commit();

		sf.close();
	}

}
