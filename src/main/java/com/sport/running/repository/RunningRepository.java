package com.sport.running.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sport.running.entity.RunningEntity;


@Repository
public interface RunningRepository extends JpaRepository<RunningEntity, Long> {
}