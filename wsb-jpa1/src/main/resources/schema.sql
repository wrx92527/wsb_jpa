CREATE TABLE Doctor
(
    id              INT PRIMARY KEY,
    firstName       VARCHAR(100) NOT NULL,
    lastName        VARCHAR(100) NOT NULL,
    telephoneNumber VARCHAR(15),
    email           VARCHAR(150),
    doctorNumber    VARCHAR(100) UNIQUE,
    specialization  VARCHAR(100)
);

CREATE TABLE Patient
(
    id              INT PRIMARY KEY,
    firstName       VARCHAR(100) NOT NULL,
    lastName        VARCHAR(100) NOT NULL,
    telephoneNumber VARCHAR(15),
    email           VARCHAR(150),
    patientNumber   VARCHAR(100) UNIQUE,
    dateOfBirth     DATE,
    address_id      INT,
    CONSTRAINT fk_patient_address FOREIGN KEY (address_id) REFERENCES Address (id)
        ON UPDATE CASCADE ON DELETE SET NULL
    -- One-to-One, Unidirectional from Parent (Patient) to Child (Address)
);

CREATE TABLE Address
(
    id           INT PRIMARY KEY,
    city         VARCHAR(100),
    addressLine1 VARCHAR(100),
    addressLine2 VARCHAR(100),
    postalCode   VARCHAR(10)
);

CREATE TABLE Visit
(
    id          INT PRIMARY KEY,
    description VARCHAR(255),
    time        TIMESTAMP,
    doctor_id   INT NOT NULL,
    patient_id  INT NOT NULL,
    CONSTRAINT fk_visit_doctor FOREIGN KEY (doctor_id) REFERENCES Doctor (id)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_visit_patient FOREIGN KEY (patient_id) REFERENCES Patient (id)
        ON UPDATE CASCADE ON DELETE RESTRICT
    -- Many-to-One with Doctor and Patient, Bidirectional
);

CREATE TABLE MedicalTreatment
(
    id          INT PRIMARY KEY,
    description VARCHAR(255),
    type        VARCHAR(50),
    visit_id    INT NOT NULL,
    CONSTRAINT fk_treatment_visit FOREIGN KEY (visit_id) REFERENCES Visit (id)
        ON UPDATE CASCADE ON DELETE RESTRICT
    -- Many-to-One with Visit, Unidirectional from Child (MedicalTreatment) to Parent (Visit)
);
