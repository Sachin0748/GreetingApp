package com.greetingapp.repo;

import com.greetingapp.entities.GreetingMessageEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingMessageEntity, Integer> {
}