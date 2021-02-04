package com.ego14t.gateway.config;

import com.ego14t.gateway.entity.RoutesEntity;
import com.ego14t.gateway.mapper.GatewayMapper;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.util.*;

/**
 * @author wangfx
 * @date 2020/10/23 9:32
 */

@Component
public class DBARouteDefinitionRepository implements RouteDefinitionRepository {

    @Resource
    private GatewayMapper gatewayMapper;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> gatewayRouteEntityList = getRouteConfig();
        return Flux.fromIterable(gatewayRouteEntityList);
    }

    private List<RouteDefinition> getRouteConfig() {
        List<RoutesEntity> routesEntities = gatewayMapper.queryAllRoutes();

        List<RouteDefinition> definitions = new ArrayList<>();

        //组装RouteDefinition
        for (RoutesEntity entity : routesEntities) {
            RouteDefinition definition = new RouteDefinition();

            Map<String,String> predicateParams = new HashMap<>();
            PredicateDefinition predicate = new PredicateDefinition();

            URI uri = UriComponentsBuilder.fromUriString(entity.getUri()).build().toUri();

            predicate.setName("Path");
            predicateParams.put("pattern",entity.getPredicates());
            predicate.setArgs(predicateParams);

            //过滤暂时不写
            //filter.setName("StripPrefix");
            //TODO 动态过滤

            definition.setPredicates(Arrays.asList(predicate));
            //definition.setFilters();

            definition.setUri(uri);
            definition.setId(entity.getRouteId());

            definitions.add(definition);
        }

        return definitions;
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}
