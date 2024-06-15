package com.example.java4.repositories;
import com.example.java4.entitiesNoMap.DiaChiNVNoMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DiaChiNVRepository extends JpaRepository<DiaChiNVNoMap,String> {

}
