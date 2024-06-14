package com.example.java4.repositories;
import com.example.java4.entitiesLv1.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface ChatLieuRepository extends JpaRepository<ChatLieu,String> {
    int ACTIVE  = 1;
    int INACTIVE =0;
    Page<ChatLieu> findByTrangThai(int trangThai, Pageable pageable);
    @Query(value = "select *from chatlieu",nativeQuery = true)
    Page<ChatLieu> findAllByPage(Pageable pageable);
    @Query("UPDATE ChatLieu cl SET cl.trangThai = 1 WHERE cl.id=:id")
    int enableStt(@Param("id")String id);
    @Query("UPDATE ChatLieu cl SET cl.trangThai = 0 WHERE cl.id=:id")
    int disableStt(@Param("id")String id);
    @Query(value = "SELECT COUNT(*) FROM chatlieu",nativeQuery = true)
    Integer getCount();
}
