package com.example.java4.repositories;

import com.example.java4.entitiesLv1.ChucVu;
import com.example.java4.entitiesLv2.DiaChiKH;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DiaChiKHRepository extends JpaRepository<DiaChiKH,String> {
    int ACTIVE  = 1;
    int INACTIVE =0;
    @Query(value = "select dckh from DiaChiKH dckh ORDER BY dckh.ngayTao desc")
    Page<DiaChiKH> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select dckh from DiaChiKH dckh ORDER BY dckh.ngayTao desc")
    Page<DiaChiKH> findAllByPage(Pageable pageable);
    @Query("UPDATE DiaChiKH dckh SET dckh.trangThai = 1 WHERE dckh.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE DiaChiKH dckh SET dckh.trangThai = 0 WHERE dckh.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM diachikh",nativeQuery = true)
    Integer getCount();
    @Query(value = "SELECT COUNT(*) FROM diachikh where trangThai=1",nativeQuery = true)
    Integer getCountStt1();
    @Query(value = "SELECT COUNT(*) FROM diachikh where trangThai=0",nativeQuery = true)
    Integer getCountStt0();
}
