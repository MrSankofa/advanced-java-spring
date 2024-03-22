/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.querydsl.repository;

import com.codingnomads.springdata.example.querydsl.models.Route;
import com.codingnomads.springdata.example.querydsl.models.SearchQuery;
import java.util.List;

public interface RouteCustomRepository {

    List<Route> findAllRoutesBySearchQuery(SearchQuery searchQuery);
}
