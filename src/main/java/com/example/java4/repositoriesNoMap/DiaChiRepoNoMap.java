package com.example.java4.repositoriesNoMap;
import com.example.java4.entitiesNoMap.DiaChiNoMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaChiRepoNoMap extends JpaRepository<DiaChiNoMap,String> {
    public static final int ACTIVE  = 1;
    public static final int INACTIVE =0;
    public Page<DiaChiNoMap> findByTrangThai(int trangThai, Pageable pageable);
}
