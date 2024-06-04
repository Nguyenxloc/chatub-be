package com.example.java4.repositories;
import com.example.java4.entitiesLv2.DiaChiGiaoHang;
import com.example.java4.entitiesLv2.DiaChiKH;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiaChiKHRepository extends JpaRepository<DiaChiKH, String > {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<DiaChiKH> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE DiaChiKH dckh SET dckh.trangThai = 1 WHERE dckh.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE DiaChiKH dckh SET dckh.trangThai = 0 WHERE dckh.id=:id")
    int disableStt(@Param("id")String id);
}
