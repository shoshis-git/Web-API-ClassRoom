package com.example.projectshoshifruchter.controllers;


import com.example.projectshoshifruchter.entities.ClassRoom;
import com.example.projectshoshifruchter.services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;
    @GetMapping
    public List<ClassRoom> getClassRoom(){return classRoomService.getClassRooms();}

    @GetMapping("/{roomNumber}")
    public ClassRoom getClassByRoomNumber(@PathVariable int roomNumber){
        return classRoomService.getClasRoomById(roomNumber);}





    @PostMapping
    public void AddClass(@RequestBody ClassRoom classRoom){


        classRoomService.addClass(classRoom);

    }
    @PutMapping("/{roomNumber}")
    public void updateClass(@PathVariable int roomNumber,@RequestBody ClassRoom classRoom){
       classRoomService.updateClassRoom(roomNumber,classRoom);

    }
    @DeleteMapping
    public void deleteClass(@PathVariable int roomNumber){classRoomService.deleteClassRoom(roomNumber);}
}
