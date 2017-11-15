package com.grubx.core.adapters;

import java.util.Collection;
import java.util.List;

public interface DaoToDtoAdapter<Dao, Dto> {

    List<Dto> convertToDto(Collection<Dao> dao);

    Dto convertToDto(Dao dao);

}
