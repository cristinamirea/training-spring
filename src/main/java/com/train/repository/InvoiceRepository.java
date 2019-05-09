package com.train.repository;
import com.train.entity.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    /*@Modifying
    @Query(value = "insert into InvoiceIar(id, nr, total, issue) values (?1,?2,?3)", nativeQuery = true)
     void insertInDb(int id, int nr, int total, int issue);*/
}