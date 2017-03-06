package com.softgroup.common.database.repository;

import com.softgroup.common.database.model.UserProfile;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zigza on 06.03.2017.
 */
public interface CommonOperationsRepository<T,ID extends Serializable> extends CrudRepository<T,ID> {
    public List<T> findAll();
    public List<T> findByIdIn(List<ID> items);
}
