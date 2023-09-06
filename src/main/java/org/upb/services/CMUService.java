package org.upb.services;

import org.upb.interfaces.CMUServeur;
import org.upb.model.DossierMedical;
import org.upb.model.Patient;
import org.upb.Connections.DataBaseConnection;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebService
public class CMUService implements CMUServeur {

    @WebMethod(operationName = "creerOuModifierPatient")
    @Override
    public boolean creerOuModifierPatient(Patient patient) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DataBaseConnection.getConnection(); // Utilisation de la classe DataBaseConnection pour obtenir la connexion

            if (patient.getId() == null) {
                // Créer un nouveau patient
                stmt = conn.prepareStatement("INSERT INTO patient (nom, prenoms, age) VALUES (?, ?, ?)");
                stmt.setString(1, patient.getNom());
                stmt.setString(2, patient.getPrenoms());
                stmt.setInt(3, patient.getAge());
            } else {
                // Mettre à jour un patient existant
                stmt = conn.prepareStatement("UPDATE patient SET nom = ?, prenoms = ?, age = ? WHERE id = ?");
                stmt.setString(1, patient.getNom());
                stmt.setString(2, patient.getPrenoms());
                stmt.setInt(3, patient.getAge());
                stmt.setLong(4, patient.getId());
            }

            int rowsAffected = stmt.executeUpdate();

            // Si une ligne a été modifiée, retournez true (opération réussie)
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En cas d'erreur
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @WebMethod(operationName = "supprimerPatient")
    @Override
    public boolean supprimerPatient(Long patientId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DataBaseConnection.getConnection(); // Utilisation de la classe DataBaseConnection pour obtenir la connexion

            // Supprimer le patient en fonction de son ID
            stmt = conn.prepareStatement("DELETE FROM patient WHERE id = ?");
            stmt.setLong(1, patientId);

            int rowsAffected = stmt.executeUpdate();

            // Si une ligne a été supprimée, retournez true 
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En cas d'erreur
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @WebMethod(operationName = "creerOuMettreAJourDossierMedical")
    @Override
    public boolean creerOuMettreAJourDossierMedical(DossierMedical dossierMedical) {
        // Implémentation la logique pour créer ou mettre à jour un dossier médical ici
        return false;
    }

    @WebMethod(operationName = "supprimerDossierMedical")
    @Override
    public boolean supprimerDossierMedical(Long dossierMedicalId) {
        // Implémentation la logique pour supprimer un dossier médical ici
        return false;
    }

    @WebMethod(operationName = "recupererDossierMedical")
    @Override
    public DossierMedical recupererDossierMedical(Long patientId) {
        // Implémentation la logique pour récupérer un dossier médical en fonction de l'ID du patient ici
        return null;
    }

    @WebMethod(operationName = "recupererPatient")
    @Override
    public Patient recupererPatient(Long patientId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DataBaseConnection.getConnection(); 

            // Récupérer le patient en fonction de son ID
            stmt = conn.prepareStatement("SELECT * FROM patient WHERE id = ?");
            stmt.setLong(1, patientId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Créer un objet Patient à partir des données de la base de données
                Patient patient = new Patient();
                patient.setId(rs.getLong("id"));
                patient.setNom(rs.getString("nom"));
                patient.setPrenoms(rs.getString("prenoms"));
                patient.setAge(rs.getInt("age"));
                return patient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // En cas d'erreur ou si le patient n'a pas été trouvé
    }

 

}
