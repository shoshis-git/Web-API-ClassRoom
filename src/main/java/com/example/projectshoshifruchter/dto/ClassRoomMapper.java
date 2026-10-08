package com.example.projectshoshifruchter.dto;

import com.example.projectshoshifruchter.entities.ClassRoom;

/**
 * אחראי על כל ההמרות בין Entity ל-DTO ובחזרה.
 * כל הלוגיקה של המיפוי נמצאת במקום אחד —
 * אם משהו משתנה ב-Entity או ב-DTO, רק הקובץ הזה צריך להשתנות.
 */
public class ClassRoomMapper {

    // מניעת instantiation — כל המתודות static
    private ClassRoomMapper() {}

    /**
     * Entity → ResponseDTO (לשליחה ללקוח)
     */
    public static ClassRoomResponseDTO toResponseDTO(ClassRoom classRoom) {
        return new ClassRoomResponseDTO(
                classRoom.getRoomNumber(),
                classRoom.getClassNumber(),
                classRoom.getTeacher(),
                classRoom.getAmountPupil()
        );
    }

    /**
     * RequestDTO → Entity (לשמירה ב-DB)
     */
    public static ClassRoom toEntity(ClassRoomRequestDTO dto) {
        return new ClassRoom(
                dto.getRoomNumber(),
                dto.getClassNumber(),
                dto.getTeacher(),
                dto.getAmountPupil()
        );
    }

    /**
     * עדכון Entity קיימת מ-RequestDTO — לא יוצרים אובייקט חדש,
     * רק מעדכנים את השדות כדי ש-JPA ישמור אותה עם אותו ID
     */
    public static void updateEntityFromDTO(ClassRoomRequestDTO dto, ClassRoom classRoom) {
        classRoom.setClassNumber(dto.getClassNumber());
        classRoom.setTeacher(dto.getTeacher());
        classRoom.setAmountPupil(dto.getAmountPupil());
    }
}
