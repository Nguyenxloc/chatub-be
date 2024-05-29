package com.example.java4.repositories;
import com.example.java4.entitiesLv1.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface KichThuocRepository
        extends JpaRepository<KichThuoc,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<KichThuoc> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE KichThuoc kt SET kt.trangThai = 1 WHERE kt.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE KichThuoc kt SET kt.trangThai = 0 WHERE kt.id=:id")
    int disableStt(@Param("id")String id);
};
