package com.example.java4.repositories;
import com.example.java4.entities.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MauSacRepository
        extends JpaRepository<MauSac,Integer>
{

} ;