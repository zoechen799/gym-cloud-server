package com.yiibo.gym.course.repository;

import com.yiibo.gym.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * ClassName: CourseRepository
 * Description:
 * date: 2019/6/18 1:56 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseRepository extends JpaRepository<Course, Long>{

}
