package com.example.parsings.repository;

import com.example.parsings.models.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValuesRepository extends JpaRepository<Values, Long> {
}
