package com.loatr.learning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
class LearningApplicationTests {

	@Test
	void contextLoads() {

	}

	public static void main(String[] args) {
		String str = null;
		String s = str + "";
		System.out.println(s);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		UnitVisibleEmployee2 other = (UnitVisibleEmployee2) obj;
		if(!Objects.equals(unitId,other.unitId)){
			return false;
		}
		return Objects.equals(unitVisibleEmployees ,other.unitVisibleEmployees);
	}
}
