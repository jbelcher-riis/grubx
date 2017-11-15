package com.grubx.core.repositories;

import org.springframework.data.repository.CrudRepository;

import com.grubx.core.Daos.CategoryDao;
import com.grubx.core.Daos.LocationCategoryDao;
import com.grubx.core.Daos.LocationDao;

public interface LocationCategoryRepository extends CrudRepository<LocationCategoryDao, Long> {
    LocationCategoryDao findOneByLocationAndCategory(LocationDao location, CategoryDao category);
}
