/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.querydsl.repository;

import com.codingnomads.springdata.example.querydsl.models.Area;
import com.codingnomads.springdata.example.querydsl.models.QArea;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class AreaCustomRepositoryImpl extends QuerydslRepositorySupport implements AreaCustomRepository {

    public AreaCustomRepositoryImpl() {
        super(Area.class);
    }

    @Override
    public Area findByCode(String code) {
        QArea area = QArea.area;
        return from(area).where(area.code.eq(code)).fetchOne();
    }
}
