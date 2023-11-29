package com.example.domy.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> getByTaskId(Long id);

    @Query("SELECT task FROM User u " +
            "JOIN u.boards b " +
            "JOIN b.taskLists tl " +
            "JOIN tl.tasks task " +
            "WHERE u.userId = :userId")
    List<Task> findTasksByUserId(@Param("userId") Long userId);

}
