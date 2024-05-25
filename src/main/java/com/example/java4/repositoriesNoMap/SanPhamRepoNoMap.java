package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesNoMap.SanPhamNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepoNoMap
        extends JpaRepository<SanPhamNoMap,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<SanPhamNoMap> findByTrangThai(int trangThai, Pageable pageable);
};
