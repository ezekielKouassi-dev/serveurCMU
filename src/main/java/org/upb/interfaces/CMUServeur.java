package org.upb.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.upb.model.DossierMedical;
import org.upb.model.Patient;

@WebService
public interface CMUServeur {
	// Dossier Médical
	@WebMethod(operationName = "creerOuModifierDossierMedical")
	public boolean creerOuMettreAJour(DossierMedical dossierMedical);

	@WebMethod(operationName = "supprimerDossierMedical")
	public boolean supprimerDossierMedical(Long dossierMedicalId);

	@WebMethod(operationName = "recupererDossierMedical")
	public DossierMedical recupererDossierMedical(Long patientId);

	// Patient
	public boolean creerOuModifierPatient(Patient patient);
	public boolean supprimerPatient(Long patientId);

}
