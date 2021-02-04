package com.ego14t.gateway.entity;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author wangfx
 * @date 2020/10/23 9:50
 */
public class RoutesEntity implements Serializable{

    private static final long serialVersionUID = -1363816741818214675L;

    private int id;

    @NotEmpty(message = "不能为空")
    private String routeId;

    private String uri;

    private int order;

    private String predicates;

    private String filters;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPredicates() {
        return predicates;
    }

    public void setPredicates(String predicates) {
        this.predicates = predicates;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
