package com.grubx.core.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grubx.core.Daos.CompanyDao;
import com.grubx.core.Daos.LocationDao;

@Repository
public interface LocationRepository extends CrudRepository<LocationDao, Long> {

    List<LocationDao> findAllByCompany(CompanyDao company);
}
