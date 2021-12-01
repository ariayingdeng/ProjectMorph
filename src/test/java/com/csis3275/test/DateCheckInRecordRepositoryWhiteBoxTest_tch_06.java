package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.csis3275.morphModel.DateCheckInRecord;
import com.csis3275.morphRepository.DateCheckInRecordRepository;



@ExtendWith(SpringExtension.class)
@DataJpaTest
class DateCheckInRecordRepositoryWhiteBoxTest_tch_06 {
	
	@Autowired
	DateCheckInRecordRepository myRepo;

	@Test
	void test() {
		DateCheckInRecord record = new DateCheckInRecord();
		record.setUserId(1);
		record.setDate("20211111");
		record.setEat(true);
		record.setExerciese(false);
		myRepo.save(record);
		assertNotNull(myRepo);
		assertEquals("20211111", myRepo.findByuserId(1).get(0).getDate());
		assertTrue(myRepo.findByuserId(1).get(0).isEat());
		assertFalse(myRepo.findByuserId(1).get(0).isExerciese());
		
		record.setExerciese(true);
		myRepo.save(record);
		assertEquals(1, myRepo.count());
		assertEquals("20211111", myRepo.findByuserId(1).get(0).getDate());
		assertTrue(myRepo.findByuserId(1).get(0).isEat());
		assertTrue(myRepo.findByuserId(1).get(0).isExerciese());
	}

}
