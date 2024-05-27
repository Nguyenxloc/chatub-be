package com.example.java4.repositories;

import com.example.java4.entities.HinhAnh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HinhAnhRepository extends JpaRepository<HinhAnh,String> {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<HinhAnhRepository> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE HinhAnh hinhAnh SET hinhAnh.trangThai = 1 WHERE hinhAnh.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE HinhAnh hinhAnh SET hinhAnh.trangThai = 0 WHERE hinhAnh.id=:id")
    int disableStt(@Param("id")String id);
}
