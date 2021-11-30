package com.csis3275.morphRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.csis3275.morphModel.DateCheckInRecord;




public interface DateCheckInRecordRepository extends CrudRepository<DateCheckInRecord, Integer> {
	List<DateCheckInRecord> findByuserId(int id);
}
	