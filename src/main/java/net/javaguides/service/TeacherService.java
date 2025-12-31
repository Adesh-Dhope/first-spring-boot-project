package net.javaguides.service;

import java.util.List;
import net.javaguides.model.Teacher;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();
}

