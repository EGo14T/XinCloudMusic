package com.ego14t.gateway.mapper;

import com.ego14t.gateway.entity.RoutesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangfx
 * @date 2020/10/23 9:33
 */

@Mapper
public interface GatewayMapper {

    List<RoutesEntity> queryAllRoutes();

    int create(RoutesEntity entity);

    int deleteByRouteId(String routeId);

    int updateRouteById(RoutesEntity entity);
}
