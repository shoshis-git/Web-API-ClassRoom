package com.example.projectshoshifruchter.controllers;

import com.example.projectshoshifruchter.entities.ClassRoom;
import com.example.projectshoshifruchter.services.ClassRoomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {

    @Autowired
    private ClassRoomServiceInterface classRoomService;

    @GetMapping
    public ResponseEntity<List<ClassRoom>> getClassRooms() {
        return ResponseEntity.ok(classRoomService.getClassRooms());
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<ClassRoom> getClassByRoomNumber(@PathVariable int roomNumber) {
        ClassRoom classRoom = classRoomService.getClassRoomById(roomNumber);
        if (classRoom == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(classRoom);
    }

    @PostMapping
    public ResponseEntity<Void> addClass(@RequestBody ClassRoom classRoom) {
        classRoomService.addClass(classRoom);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{roomNumber}")
    public ResponseEntity<Void> updateClass(@PathVariable int roomNumber, @RequestBody ClassRoom classRoom) {
        if (classRoomService.getClassRoomById(roomNumber) == null) {
            return ResponseEntity.notFound().build();
        }
        classRoomService.updateClassRoom(roomNumber, classRoom);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<Void> deleteClass(@PathVariable int roomNumber) {
        if (classRoomService.getClassRoomById(roomNumber) == null) {
            return ResponseEntity.notFound().build();
        }
        classRoomService.deleteClassRoom(roomNumber);
        return ResponseEntity.noContent().build();
    }
}
