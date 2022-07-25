package com.nttdata.bootcamp.active.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericDao<Y, ID> extends ReactiveMongoRepository<Y, ID> {

}
