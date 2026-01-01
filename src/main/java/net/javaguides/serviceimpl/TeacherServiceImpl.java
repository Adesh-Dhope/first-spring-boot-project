package net.javaguides.serviceimpl;

import java.util.List;
import net.javaguides.service.EmailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.model.Teacher;
import net.javaguides.repository.TeacherRepository;
import net.javaguides.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private EmailService emailService;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
//        return teacherRepository.save(teacher);
        Teacher savedTeacher = teacherRepository.save(teacher);

        // Send Email after successful save
        emailService.sendTeacherWelcomeMail(
                savedTeacher.getTeacherEmail(),
                savedTeacher.getTeacherName(),
                savedTeacher.getTeacherSubject()
        );

        return savedTeacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}

