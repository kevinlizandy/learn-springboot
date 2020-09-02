package com.vika.learn.repository.transaction;

import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vika.learn.model.transaction.Transfer;
import com.vika.learn.model.transaction.TransferHistory;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

	@Query(value = "select t from Transfer t where :id in(senderId, beneficiaryId)")
	public List<Transfer> getHistoryById(@Param("id") Long id);
	
}
