package org.main;

import org.auth.UserCredential;
import org.auth.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		UserCredential steve = new UserCredential();
		steve.setUsername("steve");
		steve.setPassword("jobs");
		steve.setStatus(0);
		
		UserCredential guido = new UserCredential();
		guido.setUsername("guido");
		guido.setPassword("rossum");
		guido.setStatus(0);
		
		UserProfile profile1 = new UserProfile();
		profile1.setFirstName("Steve");
		profile1.setLastName("Jobs");
		profile1.setEmailId("steve@apple.com");
		profile1.setPhoneNo("9876543210");
		
		UserProfile profile2 = new UserProfile();
		profile2.setFirstName("Guido Van");
		profile2.setLastName("Rossum");
		profile2.setEmailId("guido@python.org");
		profile2.setPhoneNo("9876543211");
		
		UserProfile profile3 = new UserProfile();
		profile3.setFirstName("James");
		profile3.setLastName("Gosling");
		profile3.setEmailId("james@java.com");
		profile3.setPhoneNo("9876543212");
		
		steve.getProfiles().add(profile1);
		steve.getProfiles().add(profile3);
		guido.getProfiles().add(profile2);
		
		profile1.setCredential(steve);
		profile2.setCredential(guido);
		
		
		session.save(steve);
		session.save(guido);
		session.save(profile1);
		session.save(profile2);
		session.save(profile3);
		
		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
