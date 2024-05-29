package com.example.java4.repositories;

import com.example.java4.entitiesLv1.TinhThanh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhThanhRepository extends JpaRepository<TinhThanh,String> {
}
