package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesNoMap.KichThuocNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepoNoMap
        extends JpaRepository<KichThuocNoMap,String>
{
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<KichThuocNoMap> findByTrangThai(int trangThai, Pageable pageable);
};
