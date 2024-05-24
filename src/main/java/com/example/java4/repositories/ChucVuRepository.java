package com.example.java4.repositories;

import com.example.java4.entities.ChucVu;
import com.example.java4.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,String> {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<ChucVu> findByTrangThai(int trangThai, Pageable pageable);
}