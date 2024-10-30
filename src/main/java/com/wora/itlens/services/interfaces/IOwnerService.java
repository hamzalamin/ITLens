package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.OwnerDto;
import com.wora.itlens.models.dtos.owners.UpdateOwnerDto;
import com.wora.itlens.services.GenericService;

public interface IOwnerService extends GenericService<CreateOwnerDto, UpdateOwnerDto, OwnerDto, Long> {
}
