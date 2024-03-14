package services.professor;

import entities.Professor;
import exceptions.ServiceException;

import java.util.List;

public interface IProfessorService {

    void editProfessor(Professor professor) throws ServiceException;

    List<Professor> getProfessorsByPosition(String position) throws ServiceException;
}
