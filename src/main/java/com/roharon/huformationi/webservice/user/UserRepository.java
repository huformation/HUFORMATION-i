package com.roharon.huformationi.webservice.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByUserkey(String user_key);
}
