package com.example.projectshoshifruchter.services;

import com.example.projectshoshifruchter.entities.ClassRoom;

import java.util.List;

public interface ClassRoomServiceInterface {
    List<ClassRoom> getClassRooms();
    ClassRoom getClassRoomById(int id);
    ClassRoom getClassRoomByClassNumber(char classNumber);
    void addClass(ClassRoom classRoom);
    void updateClassRoom(int id, ClassRoom classRoom);
    void deleteClassRoom(int id);
}
