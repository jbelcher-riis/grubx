package com.grubx.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grubx.core.Daos.MenuItemDao;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItemDao, Long> {

}
