INSERT INTO Address (id, city, addressLine1, addressLine2, postalCode)
VALUES (1, 'Warszawa', 'Marszałkowska 123', 'Mieszkanie 45', '00-001'),
       (2, 'Kraków', 'Floriańska 7', NULL, '31-019');

INSERT INTO Doctor (id, firstName, lastName, telephoneNumber, email, doctorNumber, specialization)
VALUES (1, 'Anna', 'Kowalska', '123456789', 'anna.kowalska@example.com', 'DOC001', 'Kardiologia'),
       (2, 'Jan', 'Nowak', '987654321', 'jan.nowak@example.com', 'DOC002', 'Ortopedia');

INSERT INTO Patient (id, firstName, lastName, telephoneNumber, email, patientNumber, dateOfBirth, address_id)
VALUES (1, 'Tomasz', 'Wiśniewski', '123123123', 'tomasz.wisniewski@example.com', 'PAT001', '1980-03-15', 1),
       (2, 'Ewa', 'Zielińska', '321321321', 'ewa.zielinska@example.com', 'PAT002', '1992-07-23', 2);

INSERT INTO Visit (id, description, time, doctor_id, patient_id)
VALUES (1, 'Wizyta kontrolna serca', '2024-10-01 10:00:00', 1, 1),
       (2, 'Konsultacja ortopedyczna', '2024-10-02 14:30:00', 2, 2);

INSERT INTO MedicalTreatment (id, description, type, visit_id)
VALUES (1, 'Podanie leków na nadciśnienie', 'Farmakoterapia', 1),
       (2, 'Ćwiczenia rehabilitacyjne', 'Rehabilitacja', 2);
