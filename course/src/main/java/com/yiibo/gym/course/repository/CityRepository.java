package com.yiibo.gym.course.repository;

import com.yiibo.gym.course.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * ClassName: CityRepository
 * Description:
 * date: 2019/6/19 7:56 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface CityRepository extends JpaRepository<City, Long> {
}
