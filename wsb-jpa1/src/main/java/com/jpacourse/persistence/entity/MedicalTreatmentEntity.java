package com.jpacourse.persistence.entity;

import com.jpacourse.persistence.enums.TreatmentType;

import javax.persistence.*;

@Entity
@Table(name = "medicaltreatment")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(
		nullable = false,
		length = 50
	)
	@Enumerated(EnumType.STRING)
	private TreatmentType type;

	//Relacja od strony dziecka, MedicalTreatment to dizecko
	@ManyToOne
	@JoinColumn(
		name = "visit_id",
		foreignKey = @ForeignKey(name = "fk_treatment_visit"),
		nullable = false
	)
	private VisitEntity visit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

    public VisitEntity getVisit() {
        return visit;
    }

    public void setVisit(VisitEntity visit) {
        this.visit = visit;
    }
}
