package com.capstone.capstone.repository;

import com.capstone.capstone.models.Walkie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkieRepository extends JpaRepository<Walkie, Long> {
}
