package com.example.java4.repositories;
import com.example.java4.entitiesLv1.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface KhachHangRepository
        extends JpaRepository<KhachHang,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<KhachHang> findByTrangThai(int trangThai, Pageable pageable);
    public Optional<KhachHang> findById(String id);
    @Query("UPDATE KhachHang kh SET kh.trangThai = 1 WHERE kh.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE KhachHang kh SET kh.trangThai = 0 WHERE kh.id=:id")
    int disableStt(@Param("id")String id);
};
