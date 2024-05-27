package com.example.java4.repositories;

import com.example.java4.entities.GiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GiaohangRepository extends JpaRepository<GiaoHang,String> {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<GiaoHang> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE GiaoHang giaoHang SET giaoHang.trangThai = 1 WHERE giaoHang.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE DiaChi giaoHang SET giaohang.trangThai = 0 WHERE GiaoHang.id=:id")
    int disableStt(@Param("id")String id);
}
