package com.insware.appremises.interfaz;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

import com.insware.appremises.R;
import com.insware.appremises.dao.MovilDAO;
import com.insware.appremises.modelo.Movil;

import java.util.Iterator;
import java.util.List;

public class Configuracion extends PreferenceActivity{
	
	MovilDAO movilDao;
	List<Movil> moviles;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.app_preferencias);
		ListPreference listPref = (ListPreference) findPreference("remis");

		
		//Llenamos el listpreference con los numeros de remises
		movilDao = new MovilDAO(this);
		moviles = movilDao.obtenerMoviles();
		Iterator<Movil> iMovil = moviles.iterator();
		String[] entries = new String[moviles.size()];
		int i=0;
		Movil m = null;
		while (iMovil.hasNext()) {
			m = iMovil.next();
			entries[i] = Integer.toString(m.getNumero()); 
		}
		
		listPref.setEntries(entries);
		listPref.setEntryValues(entries);
	
		
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	

}
