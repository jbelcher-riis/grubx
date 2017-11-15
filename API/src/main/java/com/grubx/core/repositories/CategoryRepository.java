package com.grubx.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grubx.core.Daos.CategoryDao;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryDao, Long> {

}
