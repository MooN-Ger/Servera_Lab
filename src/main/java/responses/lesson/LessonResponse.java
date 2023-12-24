package responses.lesson;

import entities.Group;
import entities.Professor;
import entities.Subject;

import java.time.LocalDate;

public class LessonResponse {
    private long id;
    private LocalDate date;
    private int number;
    private Group group;
    private Professor professor;
    private Subject subject;

    public long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public Group getGroup() {
        return group;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Subject getSubject() {
        return subject;
    }

    public LessonResponse(long id, LocalDate date, int number, Group group, Professor professor, Subject subject) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.group = group;
        this.professor = professor;
        this.subject = subject;
    }
}
