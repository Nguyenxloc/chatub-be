package com.example.java4.repositories;
import com.example.java4.entities.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HoaDonRepository
        extends JpaRepository<HoaDon,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<HoaDon> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "SELECT TOP 5 * FROM HoaDonChiTiet ORDER BY ID DESC",
           nativeQuery = true)
    public List<HoaDon> findByTrangThai(int trangThai);
    @Query("UPDATE HoaDon hoaDon SET hoaDon.trangThai = 1 WHERE hoaDon.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE HoaDon hoaDon SET hoaDon.trangThai = 0 WHERE hoaDon.id=:id")
    int disableStt(@Param("id")String id);
};
