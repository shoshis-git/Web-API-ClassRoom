package com.example.projectshoshifruchter.services;

import com.example.projectshoshifruchter.dto.ClassRoomRequestDTO;
import com.example.projectshoshifruchter.dto.ClassRoomResponseDTO;

import java.util.List;

public interface ClassRoomServiceInterface {
    List<ClassRoomResponseDTO> getClassRooms();
    ClassRoomResponseDTO getClassRoomById(int id);
    ClassRoomResponseDTO getClassRoomByClassNumber(char classNumber);
    void addClass(ClassRoomRequestDTO dto);
    void updateClassRoom(int id, ClassRoomRequestDTO dto);
    void deleteClassRoom(int id);
}
