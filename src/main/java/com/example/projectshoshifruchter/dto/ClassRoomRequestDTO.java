package com.example.projectshoshifruchter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * מה שהלקוח שולח ב-POST / PUT.
 * ה-Entity עצמה לא נחשפת החוצה — רק ה-DTO הזה.
 */
@Schema(description = "פרטי הכיתה לשליחה")
public class ClassRoomRequestDTO {

    @Schema(description = "מספר החדר", example = "101", minimum = "1")
    @Min(value = 1, message = "Room number must be at least 1")
    private int roomNumber;

    @Schema(description = "אות הכיתה", example = "A")
    @NotNull(message = "Class number is required")
    private Character classNumber;

    @Schema(description = "שם המורה האחראי", example = "ישראל ישראלי")
    @NotBlank(message = "Teacher name is required")
    private String teacher;

    @Schema(description = "מספר תלמידים בכיתה", example = "30", minimum = "0", maximum = "50")
    @Min(value = 0, message = "Amount of pupils cannot be negative")
    @Max(value = 50, message = "Amount of pupils cannot exceed 50")
    private int amountPupil;

    public ClassRoomRequestDTO() {}

    public ClassRoomRequestDTO(int roomNumber, Character classNumber, String teacher, int amountPupil) {
        this.roomNumber = roomNumber;
        this.classNumber = classNumber;
        this.teacher = teacher;
        this.amountPupil = amountPupil;
    }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public Character getClassNumber() { return classNumber; }
    public void setClassNumber(Character classNumber) { this.classNumber = classNumber; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public int getAmountPupil() { return amountPupil; }
    public void setAmountPupil(int amountPupil) { this.amountPupil = amountPupil; }
}
