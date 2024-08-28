package com.example.library_management_system.repository;


// JPA repository is provided by jpa spring data.<Entity type(Which is entity class), Id type(Which is data type of Id)>

import com.example.library_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Allows the instance to be recognised in spring context; It is also a repository, which can't be used in data access object layer.

public interface BookRepository extends JpaRepository<Book, Long> {

}
