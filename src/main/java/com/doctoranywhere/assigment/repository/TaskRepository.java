package com.doctoranywhere.assigment.repository;

import com.doctoranywhere.assigment.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    //@Query(value="", nativeQuery = true)
}
