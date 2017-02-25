package by.sysadmins.dashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import by.sysadmins.dashboard.dao.FreePbxDaoFactory;
import by.sysadmins.dashboard.dao.FreePbxDaoFactory.FreePBX;
import by.sysadmins.dashboard.dao.freepbx.FreePbxDao;
import by.sysadmins.dashboard.dao.freepbx.connectivity.InboundRoutesDao;
import by.sysadmins.dashboard.dto.InboundRouteDto;
import by.sysadmins.dashboard.services.InboundRoutesService;

@Service
public class InboundRoutesServiceImpl implements InboundRoutesService {

    private final FreePbxDaoFactory freePbxDaoFactory;

    @Autowired
    public InboundRoutesServiceImpl(FreePbxDaoFactory freePbxDaoFactory) {
        this.freePbxDaoFactory = freePbxDaoFactory;
    }

    @Override
    public List<InboundRouteDto> getAllInboundRoutes(String username) {
        FreePbxDao freePbxDao = freePbxDaoFactory.getDaoFactory(FreePBX.V12);
        InboundRoutesDao inboundRoutesDao = freePbxDao.getInboundRoutesDao(username);
        return inboundRoutesDao.findAll();
    }
}
