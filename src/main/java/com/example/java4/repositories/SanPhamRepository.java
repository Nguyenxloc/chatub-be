package com.example.java4.repositories;
import com.example.java4.entitiesLv1.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SanPhamRepository
        extends JpaRepository<SanPham,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<SanPham> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE SanPham sp SET sp.trangThai = 1 WHERE sp.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE SanPham sp SET sp.trangThai = 0 WHERE sp.id=:id")
    int disableStt(@Param("id")String id);
};
