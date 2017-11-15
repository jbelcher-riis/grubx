package com.grubx.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grubx.core.Daos.UserDao;

@Repository
public interface UserRepository extends CrudRepository<UserDao, Long> {
    UserDao findOneByEmail(String email);
}
