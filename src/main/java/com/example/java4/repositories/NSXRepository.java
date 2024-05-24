package com.example.java4.repositories;
import com.example.java4.entities.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepository extends JpaRepository<NSX,String> {
}
