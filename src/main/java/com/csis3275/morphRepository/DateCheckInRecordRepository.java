package com.csis3275.morphRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.csis3275.morphModel.DateCheckInRecord;




public interface DateCheckInRecordRepository extends JpaRepository<DateCheckInRecord, Integer> {
	List<DateCheckInRecord> findByuserId(int id);

}
	