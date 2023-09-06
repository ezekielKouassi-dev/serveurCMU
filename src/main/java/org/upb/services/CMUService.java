package org.upb.services;

import org.upb.interfaces.CMUServeur;
import org.upb.model.DossierMedical;
import org.upb.model.Patient;

public class CMUService implements CMUServeur {
	@Override
	public boolean creerOuMettreAJour(DossierMedical dossierMedical) {
		return false;
	}

	@Override
	public boolean supprimerDossierMedical(Long dossierMedicalId) {
		return false;
	}

	@Override
	public DossierMedical recupererDossierMedical(Long patientId) {
		return null;
	}

	@Override
	public boolean creerOuModifierPatient(Patient patient) {
		return false;
	}

	@Override
	public boolean supprimerPatient(Long patientId) {
		return false;
	}
}
