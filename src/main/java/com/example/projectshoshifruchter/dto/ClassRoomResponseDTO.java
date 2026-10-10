package com.example.projectshoshifruchter.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * מה שה-API מחזיר ללקוח.
 * אפשר להוסיף/להסיר שדות בלי לגעת ב-Entity שב-DB.
 */
@Schema(description = "פרטי הכיתה המוחזרים")
public class ClassRoomResponseDTO {

    @Schema(description = "מספר החדר", example = "101")
    private int roomNumber;

    @Schema(description = "אות הכיתה", example = "A")
    private char classNumber;

    @Schema(description = "שם המורה האחראי", example = "ישראל ישראלי")
    private String teacher;

    @Schema(description = "מספר תלמידים בכיתה", example = "30")
    private int amountPupil;

    public ClassRoomResponseDTO() {}

    public ClassRoomResponseDTO(int roomNumber, char classNumber, String teacher, int amountPupil) {
        this.roomNumber = roomNumber;
        this.classNumber = classNumber;
        this.teacher = teacher;
        this.amountPupil = amountPupil;
    }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public char getClassNumber() { return classNumber; }
    public void setClassNumber(char classNumber) { this.classNumber = classNumber; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public int getAmountPupil() { return amountPupil; }
    public void setAmountPupil(int amountPupil) { this.amountPupil = amountPupil; }
}
