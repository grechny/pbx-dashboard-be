package by.sysadmins.dashboard.services;

import java.util.List;

import by.sysadmins.dashboard.dto.InboundRouteDto;

public interface InboundRoutesService {

    List<InboundRouteDto> getAllInboundRoutes(String username);

}
