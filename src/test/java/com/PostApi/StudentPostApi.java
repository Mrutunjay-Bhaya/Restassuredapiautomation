package com.PostApi;

import org.testng.annotations.Test;

public class StudentPostApi {

	@Test
	void testPostApi() {

		PojoClass sa = new PojoClass();
		sa.setName("Sibu");
		sa.setLocation("India");
		sa.setPhone("753696529");

		String courseArry[] = { "c", "c#" };
		sa.setCourses(courseArry);
	}
}
