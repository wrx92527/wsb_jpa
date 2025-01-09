INSERT INTO
    Address (ID, CITY, ADDRESS_LINE1, ADDRESS_LINE2, POSTAL_CODE)
VALUES
    (1, 'Warszawa', 'Marszałkowska 123', 'Mieszkanie 45', '62-030')
  , (2, 'Kraków', 'Floriańska 7', NULL, '31-019')
  , (3, 'Gdańsk', 'Długa 33', 'Mieszkanie 12', '80-831');

INSERT INTO
    Doctor (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, SPECIALIZATION)
VALUES
    (1, 'Anna', 'Kowalska', '123456789', 'anna.kowalska@example.com', 'DOC001', 'SURGEON')
  , (2, 'Jan', 'Nowak', '987654321', 'jan.nowak@example.com', 'DOC002', 'DERMATOLOGIST');

INSERT INTO
    Patient (ID, FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, DATE_OF_BIRTH, ADDRESS_ID, INSURED)
VALUES
    (1, 'Tomasz', 'Wiśniewski', '123123123', 'tomasz.wisniewski@example.com', 'PAT001', '1980-03-15', 1, TRUE)
  , (2, 'Ewa', 'Zielińska', '321321321', 'ewa.zielinska@example.com', 'PAT002', '1992-07-23', 2, FALSE)
  , (3, 'Adam', 'Nowakowski', '444555666', 'adam.nowakowski@example.com', 'PAT003', '1985-12-01', 3, TRUE);

INSERT INTO Visit (ID, DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID)
VALUES
    (1, 'Wizyta kontrolna serca', '2024-10-01 10:00:00', 1, 1)
  , (2, 'Konsultacja ortopedyczna', '2024-10-02 14:30:00', 2, 2)
  , (3, 'Badanie EKG', '2024-11-15 09:30:00', 1, 1)
  , (4, 'Porada dermatologiczna', '2024-11-16 12:00:00', 2, 3);

INSERT INTO MedicalTreatment (ID, DESCRIPTION, TYPE, VISIT_ID)
VALUES
    (1, 'Podanie leków na nadciśnienie', 'USG', 1)
  , (2, 'Ćwiczenia rehabilitacyjne', 'EKG', 2)
  , (3, 'Badanie ciśnienia', 'USG', 3)
  , (4, 'Aplikacja maści dermatologicznej', 'EKG', 4);