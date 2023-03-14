package com.tsoft.usersdemo.repositories;

import com.tsoft.usersdemo.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,String> {
}
