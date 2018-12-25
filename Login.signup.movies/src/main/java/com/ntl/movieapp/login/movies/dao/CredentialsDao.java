package com.ntl.movieapp.login.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntl.movieapp.login.movies.model.CredentialsBean;

@Repository
public interface CredentialsDao extends JpaRepository<CredentialsBean, String> {

}
