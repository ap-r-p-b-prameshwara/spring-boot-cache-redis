package com.raymondsugiarto.springbootcacheredis.controller;

import com.raymondsugiarto.springbootcacheredis.entity.cache.Room;
import com.raymondsugiarto.springbootcacheredis.entity.cache.Student;
import com.raymondsugiarto.springbootcacheredis.repository.StudentRepository;
import com.raymondsugiarto.springbootcacheredis.service.RoomService;
import com.raymondsugiarto.springbootcacheredis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raymond on 26/02/23
 */
@RestController
@RequiredArgsConstructor
public class DataController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private final RoomService roomService;

    @GetMapping("/room")
    public Room getRoom() {
//        return roomService.getRoom(2L);
        return getRoom2(2L);
    }

    // if call like this, not work. Why not works ?
    @Cacheable(value = "room", key = "#id")
    public Room getRoom2(Long id) {
        return Room.builder().id(1L).name("Java").build();
    }

    @GetMapping("/student-insert")
    public Student createStudent() {
        return studentService.createStudent();
    }


    @GetMapping("/student")
    public Student getStudent() {
        return studentService.getStudentById(1L);
    }


    // example for lock
    @GetMapping("/transaction")
    public String transactionLock() {
        return roomService.startTransaction();
    }

}
