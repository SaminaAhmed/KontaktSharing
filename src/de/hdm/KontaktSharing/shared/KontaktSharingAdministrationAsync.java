package de.hdm.KontaktSharing.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.KontaktSharing.shared.bo.*;

public interface KontaktSharingAdministrationAsync {

	void setNutzer(Nutzer nutzer, AsyncCallback<Void> callback);

	void init(AsyncCallback<Void> callback);
	
	void getAllKontaktByNutzer(int id, AsyncCallback<Vector<Kontakt>> callback);

	void createKontakt(Kontakt k, AsyncCallback<Kontakt> callback);

	void createEigenschaft(Kontakt k, AsyncCallback<Eigenschaft> callback);

	void createEigenschaftauspraegung(Eigenschaftauspraegung e, AsyncCallback<Eigenschaftauspraegung> callback);

	void createKontaktliste(Nutzer n, AsyncCallback<Kontaktliste> callback);

	void delete(Kontakt k, AsyncCallback<Void> callback);

	void delete(Eigenschaft e, AsyncCallback<Void> callback);

	void delete(Kontaktliste kl, AsyncCallback<Void> callback);

	void delete(Eigenschaftauspraegung ea, AsyncCallback<Void> callback);

	void update(Eigenschaft e, AsyncCallback<Void> callback);

	void update(Eigenschaftauspraegung ea, AsyncCallback<Void> callback);

	void update(Kontaktliste kl, AsyncCallback<Void> callback);

	void update(Kontakt k, AsyncCallback<Void> callback);

	void getEigenschaftauspraegungOf(Eigenschaftauspraegung e,
			AsyncCallback<ArrayList<Eigenschaftauspraegung>> callback);

	void getEigenschaftOf(Kontakt k, AsyncCallback<List<Eigenschaftauspraegung>> callback);

	void getKontaktOf(Kontaktliste kl, AsyncCallback<List<Kontakt>> callback);

	void getNutzerByEmail(String mail, AsyncCallback<Nutzer> callback);

	void getNutzer(AsyncCallback<Nutzer> callback);
	
	void getAllEigenschaft(AsyncCallback<Vector<Eigenschaft>> callback);

	void getAllEigenschaftauspraegungByKontakt(Kontakt kontakt, AsyncCallback<Vector<Eigenschaftauspraegung>> callback);

	void createEigenschaftauspraegungen(Vector<Eigenschaftauspraegung> auspraegungen, AsyncCallback<Void> callback);

	void getAllKontaktlisten(AsyncCallback<Vector<Kontaktliste>> callback);
	
	void getAllKontaktlistenWithUserCountForNutzer(int idNutzer, AsyncCallback<Vector<Kontaktliste>> callback);
	
	void getKontaktlisteWithUserinformation(int idKontaktliste, AsyncCallback<Kontaktliste> callback);

	void getAllKontaktWithNameByNutzer(int id, AsyncCallback<Vector<Kontakt>> callback);

	void createKontaktlisteForNutzer(int idNutzer, String name, List<Integer> idsKontakte, AsyncCallback<Void> callback);

	void updateKontaktliste(int id, String name, List<Integer> idsKontakte,
			AsyncCallback<Void> callback);

	void setCurrentNutzerId(int id, AsyncCallback<Void> callback);

	void checkNutzer(String mail, AsyncCallback<Nutzer> callback);

	void getNutzerByMailOrCreate(String email, AsyncCallback<Nutzer> callback);
	
	void shareListe(int idNutzer,int idListe, List<String> mails, AsyncCallback<Void> callback);
	
	void getSharedKontaktlistenForUser(int idNutzer, AsyncCallback<Vector<TeilhaberschaftKontaktliste>> callback);
	
	void getAllNutzerWithoutCurrent(int idNutzer, AsyncCallback<Vector<Nutzer>> callback);
	
	void getAllNutzerInTeilhaberschaft(int idTeilhaberschaft, AsyncCallback<Vector<Nutzer>> callback);
	
	void deleteTeilhaberschaft(int idTeilhaberschaft, AsyncCallback<Void> callback);
	
	void updateTeilhaberschaftListe(int idTeilhaberschaft, List<String> mails, AsyncCallback<Void> callback);
	

	
}
