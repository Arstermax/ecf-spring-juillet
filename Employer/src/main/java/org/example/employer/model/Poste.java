package org.example.employer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "e_poste")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "e_poste_id")
    private long id;

    @OneToMany(mappedBy = "e_employer_poste_id")
    private List<Employer> employers = new ArrayList<>();

    @Column(name = "e_poste_name")
    private String name;

    @Column(name = "e_poste_salaire_type")
    private double salaireType;

    @Column(name = "e_poste_description")
    private String description;
}
