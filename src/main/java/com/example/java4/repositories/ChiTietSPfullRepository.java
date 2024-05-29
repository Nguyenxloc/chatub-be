package com.example.java4.repositories;
import com.example.java4.entitiesLv2.ChiTietSP;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChiTietSPfullRepository
        extends JpaRepository<ChiTietSP,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<ChiTietSP> findByTrangThai(int trangThai, Pageable pageable);
    @Query("UPDATE ChiTietSP ctsp SET ctsp.trangThai = 1 WHERE ctsp.id=:id")
    public  Boolean setStt(@Param("id")String id);
};
