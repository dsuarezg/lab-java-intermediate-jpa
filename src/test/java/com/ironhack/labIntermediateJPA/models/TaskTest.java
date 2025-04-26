package com.ironhack.labIntermediateJPA.models;

import com.ironhack.labIntermediateJPA.repositories.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskTest {

    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    private EntityManager entityManager;


    /*
     * **********************************************************************
     * **********************************************************************
     * **********************************************************************
     * ADVERTENCIA: EJECUTAR UNA SOLA VEZ para poblar la base de datos.
     * **********************************************************************
     * **********************************************************************
     * **********************************************************************
     */
    @Test
    @Transactional
    @Rollback(false)
    public void createTasks() {
        BillableTask billableTask1 = new BillableTask("Develop new feature", new Date(), true, 60.0);
        BillableTask billableTask2 = new BillableTask("Fix critical bug", new Date(), false, 70.0);
        BillableTask billableTask3 = new BillableTask("Implement API integration", new Date(), true, 80.0);
        BillableTask billableTask4 = new BillableTask("Optimize database queries", new Date(), false, 90.0);
        BillableTask billableTask5 = new BillableTask("Code review session", new Date(), true, 100.0);

        InternalTask internalTask1 = new InternalTask("Prepare team meeting", new Date(), true);
        InternalTask internalTask2 = new InternalTask("Update project documentation", new Date(), false);
        InternalTask internalTask3 = new InternalTask("Conduct training session", new Date(), true);
        InternalTask internalTask4 = new InternalTask("Organize code repository", new Date(), false);
        InternalTask internalTask5 = new InternalTask("Plan sprint retrospective", new Date(), true);

        entityManager.persist(billableTask1);
        entityManager.persist(billableTask2);
        entityManager.persist(billableTask3);
        entityManager.persist(billableTask4);
        entityManager.persist(billableTask5);

        entityManager.persist(internalTask1);
        entityManager.persist(internalTask2);
        entityManager.persist(internalTask3);
        entityManager.persist(internalTask4);
        entityManager.persist(internalTask5);
    }


    // Requiere native query porque realiza la función que en SQL podríamos asociar a un "LIKE"
    @Test
    @DisplayName("Find billable tasks where title starts with 'Dev'")
    public void findTasksWhereTitleStartsWithDev() {
        List<String> result = taskRepository.findBillableTaskTitlesWhereTitleStartsWith("dev");

        System.out.println("Tasks with title starting with 'dev': " + result);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    // Requiere native query porque realiza una función de agregación, en este caso, calcula la media de precio a la
    // que se facturan las tareas
    @Test
    @DisplayName("Get average hourly rate of billable tasks")
    public void getAverageHourlyRate() {
        double averageHourlyRate = taskRepository.getAVGHourlyRate();

        System.out.println("Average hourly rate of billable tasks: " + averageHourlyRate);

        assertTrue(averageHourlyRate > 0);
        assertEquals(80.0, averageHourlyRate);
    }

    // Requiere native query porque, además de hacer un join como en los casos anteriores, retorna las tareas ordenadas
    // por fecha de vencimiento
    @Test
    @DisplayName("Find all tasks ordered by due date")
    public void findAllTasksOrderedByDueDate() {
        List<String> tasks = taskRepository.findAllTasksOrderedByDueDate();
        System.out.println("All tasks ordered by due date: " + tasks);

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
    }
}