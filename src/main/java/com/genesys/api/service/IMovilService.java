package com.genesys.api.service;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.genesys.api.dao.entity.MovilEntity;


@Repository
public interface IMovilService {
	MovilEntity save(MovilEntity entity);
	List<MovilEntity> findAll();
}
