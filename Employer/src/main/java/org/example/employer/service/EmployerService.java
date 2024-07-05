package org.example.employer.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.employer.model.Departement;
import org.example.employer.model.Employer;
import org.example.employer.model.Poste;
import org.example.employer.repository.EmployerRepository;

import java.util.List;
@ApplicationScoped
public class EmployerService {

    private EmployerRepository employerRepository = new EmployerRepository();

    public Employer add(String name, Poste poste, int departement) {
        Employer employer = new Employer();
        employer.setName(name);
        employer.setPoste(poste);
        employer.setDepartement(departement);
        return employerRepository.add(employer);
    }

    public Employer update(long id, String name, Poste poste, int departement) {
        Employer employer = employerRepository.finfById(id);
        if (employer != null) {
            employer.setName(name);
            employer.setPoste(poste);
            employer.setDepartement(departement);
            return employerRepository.update(employer);
        } else {
            return null;
        }
    }

    public boolean delete(int id) {
        Employer employer = employerRepository.finfById(id);
        Boolean resultat = false;
        if (employer != null) {
            employerRepository.delete(employer);
            resultat =  true;
        }
        return resultat;
    }

    public Employer findById(long id) {
        return employerRepository.finfById(id);
    }

    public List<Employer> findAll() {
        return employerRepository.findALl();
    }
}
