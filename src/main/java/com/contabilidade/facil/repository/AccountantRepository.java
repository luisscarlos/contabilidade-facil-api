package com.contabilidade.facil.repository;

import com.contabilidade.facil.entity.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, Long> {
}
