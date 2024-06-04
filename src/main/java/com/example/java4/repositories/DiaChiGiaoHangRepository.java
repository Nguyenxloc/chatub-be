package com.example.java4.repositories;

import com.example.java4.entitiesLv1.ChucVu;
import com.example.java4.entitiesLv2.DiaChiGiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiaChiGiaoHangRepository extends JpaRepository<DiaChiGiaoHang,String> {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<DiaChiGiaoHang> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE DiaChiGiaoHang dcgh SET dcgh.trangThai = 1 WHERE dcgh.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE DiaChiGiaoHang dcgh SET dcgh.trangThai = 0 WHERE dcgh.id=:id")
    int disableStt(@Param("id")String id);
}



