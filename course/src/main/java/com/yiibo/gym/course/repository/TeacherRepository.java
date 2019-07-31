package com.yiibo.gym.course.repository;

import com.yiibo.gym.course.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * ClassName: TeacherRepository
 * Description:
 * date: 2019/6/19 7:56 PM
 *
 * @author zihan.chen
 *         Copyright (c) 2019. xiaocaobank.com All Rights Reserved.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "teacher", path = "teacher")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
