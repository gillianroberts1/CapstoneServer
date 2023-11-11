package com.capstone.capstone.repository;

import com.capstone.capstone.models.GroupWalkie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupwalkieRepository extends JpaRepository<GroupWalkie, Long> {
}
