package com.example.java4.repositories;
import com.example.java4.entities.NhanVien;
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
public interface NhanVienRepository
        extends JpaRepository<NhanVien,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<NhanVien> findByTrangThai(int trangThai, Pageable pageable);
    public Optional<NhanVien> findById(String id);
    @Query("UPDATE NhanVien nv SET nv.trangThai = 1 WHERE nv.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE NhanVien nv SET nv.trangThai = 0 WHERE nv.id=:id")
    int disableStt(@Param("id")String id);
};
