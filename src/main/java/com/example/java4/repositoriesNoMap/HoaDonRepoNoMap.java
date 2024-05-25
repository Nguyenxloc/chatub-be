package com.example.java4.repositoriesNoMap;

import com.example.java4.entities.HoaDon;
import com.example.java4.entitiesNoMap.HoaDonNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepoNoMap
        extends JpaRepository<HoaDonNoMap,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<HoaDon> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "SELECT TOP 5 * FROM HoaDonChiTiet ORDER BY ID DESC",
           nativeQuery = true)
    public List<HoaDonNoMap> findByTrangThai(int trangThai);
};
