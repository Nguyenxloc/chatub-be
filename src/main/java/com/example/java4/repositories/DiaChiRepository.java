package com.example.java4.repositories;
import com.example.java4.entitiesLv2.DiaChi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DiaChiRepository extends JpaRepository<DiaChi,String> {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<DiaChi> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE DiaChi diaChi SET diaChi.trangThai = 1 WHERE diaChi.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE DiaChi diaChi SET diaChi.trangThai = 1 WHERE diaChi.id=:id")
    int disableStt(@Param("id")String id);
}
