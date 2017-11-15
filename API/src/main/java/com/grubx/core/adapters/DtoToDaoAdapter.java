package com.grubx.core.adapters;

import java.util.Collection;
import java.util.List;

public interface DtoToDaoAdapter<Dto, Dao> {

    List<Dao> convertToDao(Collection<Dto> dto);

    Dao convertToDao(Dto dto);

}
