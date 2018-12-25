package com.ntl.movieapp.login.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntl.movieapp.login.movies.model.ProfileBean;

@Repository
public interface ProfileDao extends JpaRepository<ProfileBean, String> {

}
