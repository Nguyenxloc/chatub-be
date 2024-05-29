package com.example.java4.repositories;

import com.example.java4.entitiesLv1.QuanHuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuanHuyenRepository extends JpaRepository<QuanHuyen,String> {

}
