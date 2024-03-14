package repositories.professor;

import entities.Professor;
import entities.Student;
import exceptions.RepositoryException;
import repositories.DataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ProfessorRepository implements IProfessorRepository {
    private final DataBase db;
    private long counter;

    public ProfessorRepository(DataBase db) {
        this.db = db;
        counter = 0;
    }

    @Override
    public void editProfessor(Professor professor) throws RepositoryException {
        if (db.getProfessorsTable().containsKey(professor.getId())) throw new RepositoryException("Not contains expected professor");
        db.getProfessorsTable().replace(professor.getId(), professor);
    }

    @Override
    public List<Professor> getProfessorsByPosition(String position) throws RepositoryException {
        return db.getProfessorsTable().values().stream().filter(v -> v.getPosition().equals(position))
                .collect(Collectors.toList());
    }
}
