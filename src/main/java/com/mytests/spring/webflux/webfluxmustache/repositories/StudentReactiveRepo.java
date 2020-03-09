package com.mytests.spring.webflux.webfluxmustache.repositories;

import com.mytests.spring.webflux.webfluxmustache.data.Gender;
import com.mytests.spring.webflux.webfluxmustache.data.Student;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * *******************************
 * Created by irina on 3/9/2020.
 * Project: webflux-mustache
 * *******************************
 */
@Repository
public class StudentReactiveRepo {
    
    private static final List<Student> list = new ArrayList<>();
    static {
         list.add(new Student("masha", "petrova", 18, Gender.FEMALE, 123));
         list.add(new Student("masha", "ivanova", 19, Gender.FEMALE, 223));
         list.add(new Student("masha", "sidorova", 18, Gender.FEMALE, 123));
         list.add(new Student("vasya", "petrov", 18, Gender.MALE, 123));
         list.add(new Student("sasha", "petrov", 19, Gender.MALE, 223));
         list.add(new Student("sasha", "bukov", 18, Gender.MALE, 123));
         list.add(new Student("pasha", "pavlov", 19, Gender.MALE, 223));
         list.add(new Student("dasha", "sidorova", 19, Gender.FEMALE, 223));
         list.add(new Student("katya", "smirnova", 18, Gender.FEMALE, 123));
         list.add(new Student("natasha", "smirnova", 19, Gender.FEMALE, 223));
         list.add(new Student("anon", "anonymous", 25, Gender.UNDEFINED, 223));
         list.add(new Student("joe", "sidorenko", 18, Gender.DIFFERENT, 123));
         list.add(new Student("lesha", "smirnov", 19, Gender.MALE, 223));
        
    }
   public Flux<Student> getAllStudents(){
        return Flux.fromIterable(list);
   }
    public Flux<Student> getAllStudentsWithLastName(String lastname){
        List<Student>  rez = new ArrayList<>();
        for (Student student : list) {
            if (student.getLastName().contains(lastname)){
                rez.add(student);
            }
        }
        return Flux.fromIterable(rez);
    }
    public Flux<Student> getAllStudentsWithGender(Gender gender){
        List<Student>  rez = new ArrayList<>();
        for (Student student : list) {
            if (student.getGender().equals(gender)){
                rez.add(student);
            }
        }
        return Flux.fromIterable(rez);
    }

    public Flux<Student> getAllStudentsInGroup(int gr) {
        List<Student> rez = new ArrayList<>();
        for (Student student : list) {
            if (student.getGroup() == gr) {
                rez.add(student);
            }
        }
        return Flux.fromIterable(rez);
    }

    public Flux<Student> getAllStudentsWithComplexGender() {
        List<Student> rez = new ArrayList<>();
        for (Student student : list) {
            if (!(student.getGender().equals(Gender.FEMALE) || student.getGender().equals(Gender.MALE))) {

                rez.add(student);
            }
        }
        return Flux.fromIterable(rez);
    }
}
