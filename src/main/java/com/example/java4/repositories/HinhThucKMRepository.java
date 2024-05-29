package com.example.java4.repositories;

import com.example.java4.entitiesLv1.HinhThucKM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HinhThucKMRepository extends JpaRepository<HinhThucKM,String> {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<HinhThucKMRepository> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE HinhThucKM htkm SET htkm.trangThai = 1 WHERE htkm.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE HinhThucKM htkm SET htkm.trangThai = 0 WHERE htkm.id=:id")
    int disableStt(@Param("id")String id);
}
