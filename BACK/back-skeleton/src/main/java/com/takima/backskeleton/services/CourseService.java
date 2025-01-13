package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.CourseDao;
import com.takima.backskeleton.models.Course;
import com.takima.backskeleton.models.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseService {
    private final CourseDao courseDao;

    public List<Course> findAll() {
        return courseDao.findAll();
    }
}
