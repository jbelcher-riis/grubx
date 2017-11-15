package com.grubx.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grubx.core.Daos.CompanyDao;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyDao, Long> {

}
