package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Lesson {
    private Long id;
    private LocalDate date;
    private int number;
    private Long groupId;
    private Long professorId;
    private Long subjectId;

    public LocalDate getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public Lesson(Long id, LocalDate date, int number, Long groupId, Long professorId, Long subjectId) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.groupId = groupId;
        this.professorId = professorId;
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return number == lesson.number && Objects.equals(id, lesson.id) && Objects.equals(date, lesson.date) && Objects.equals(groupId, lesson.groupId) && Objects.equals(professorId, lesson.professorId) && Objects.equals(subjectId, lesson.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, number, groupId, professorId, subjectId);
    }
}
