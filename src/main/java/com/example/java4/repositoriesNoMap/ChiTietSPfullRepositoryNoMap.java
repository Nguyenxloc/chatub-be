package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesNoMap.ChiTietSPNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChiTietSPfullRepositoryNoMap
        extends JpaRepository<ChiTietSPNoMap,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<ChiTietSPNoMap> findByTrangThai(int trangThai, Pageable pageable);
};
