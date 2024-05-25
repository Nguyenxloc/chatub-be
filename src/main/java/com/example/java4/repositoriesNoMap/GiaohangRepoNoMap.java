package com.example.java4.repositoriesNoMap;

import com.example.java4.entitiesNoMap.GiaoHangNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaohangRepoNoMap extends JpaRepository<GiaoHangNoMap,String> {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<GiaoHangNoMap> findByTrangThai(int trangThai, Pageable pageable);
}
