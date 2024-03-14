package services.professor;

import entities.Professor;
import exceptions.ServiceException;
import repositories.professor.ProfessorRepository;

import java.util.List;

public class ProfessorService implements IProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void editProfessor(Professor professor) throws ServiceException {
        try {
            repository.editProfessor(professor);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Professor> getProfessorsByPosition(String position) throws ServiceException {
        try {
            return repository.getProfessorsByPosition(position);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
