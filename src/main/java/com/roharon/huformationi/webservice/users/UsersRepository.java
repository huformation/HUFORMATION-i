package com.roharon.huformationi.webservice.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    public List<Users> findByUserkey(String user_key);
}
