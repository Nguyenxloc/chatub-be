package com.example.java4.repositories;
import com.example.java4.entitiesLv1.PhuongXa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PhuongXaRepository extends JpaRepository<PhuongXa,String> {
}