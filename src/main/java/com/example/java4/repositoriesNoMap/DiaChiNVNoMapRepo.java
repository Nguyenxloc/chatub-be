package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesLv2.DiaChiNV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DiaChiNVNoMapRepo extends JpaRepository<DiaChiNV,String> {

}
