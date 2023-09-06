package org.upb.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.upb.model.DossierMedical;
import org.upb.model.Patient;

@WebService
public interface CMUServeur {
    // Dossier Médical
    @WebMethod(operationName = "creerOuMettreAJourDossierMedical")
    public boolean creerOuMettreAJourDossierMedical(DossierMedical dossierMedical);

    @WebMethod(operationName = "supprimerDossierMedical")
    public boolean supprimerDossierMedical(Long dossierMedicalId);

    @WebMethod(operationName = "recupererDossierMedical")
    public DossierMedical recupererDossierMedical(Long patientId);

    // Patient
    @WebMethod(operationName = "creerOuModifierPatient")
    public boolean creerOuModifierPatient(Patient patient);

    @WebMethod(operationName = "supprimerPatient")
    public boolean supprimerPatient(Long patientId);
}
