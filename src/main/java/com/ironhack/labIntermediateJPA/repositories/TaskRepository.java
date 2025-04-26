package com.ironhack.labIntermediateJPA.repositories;
import com.ironhack.labIntermediateJPA.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT t.title FROM task t INNER JOIN billable_task bt ON t.id = bt.id WHERE t.title LIKE CONCAT(:title, '%')", nativeQuery = true)
    List<String> findBillableTaskTitlesWhereTitleStartsWith(@Param("title") String title);

    @Query(value = "SELECT AVG(hourly_rate) FROM billable_task", nativeQuery = true)
    double getAVGHourlyRate();

    @Query(value = "SELECT t.title, t.id, t.due_date FROM task t LEFT JOIN billable_task bt ON t.id = bt.id LEFT JOIN internal_task it ON t.id = it.id ORDER BY t.due_date DESC ", nativeQuery = true)
    List<String> findAllTasksOrderedByDueDate();

}
