package org.main;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.test.TestPerson;

public class Solution {
	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(TestPerson.class);
		for (Failure fail : result.getFailures()) {
			System.out.println(fail.toString());
		}
		System.out.println(result.wasSuccessful()?"All Test Case Pass":"Some Test Case Failed");
	}
}
