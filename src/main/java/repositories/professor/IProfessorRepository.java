package repositories.professor;

import entities.Professor;
import exceptions.RepositoryException;

import java.util.List;

public interface IProfessorRepository {

    void editProfessor(Professor professor) throws RepositoryException;

    List<Professor> getProfessorsByPosition(String position) throws RepositoryException;
}
