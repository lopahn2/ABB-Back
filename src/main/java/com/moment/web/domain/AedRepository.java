package com.moment.web.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AedRepository extends JpaRepository<Aed, Long> {
}
