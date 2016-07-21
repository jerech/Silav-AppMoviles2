/*
* @Aplicación: Silav App Remises
 * @(#)TabPasaje.java 0.1 28/07/14
 *
/**
 *
 * @autor Jeremías Chaparro
 * @version 0.1, 28/07/14
 * 
 **
 * @Modificaciones relevantes:
 * 
 *
 */

package com.insware.appremises.interfaz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.insware.appremises.R;
import com.insware.appremises.adaptadores.PasajesAdapter;
import com.insware.appremises.dao.PasajeDAO;
import com.insware.appremises.modelo.Pasaje;

import java.util.List;


public class TabPasaje extends Fragment {
	private ListView listaPasajes;
	private EditText editBusquedaPasajes;
	private PasajeDAO p;
	private List<Pasaje> pasajes;
	private PasajesAdapter adaptadorPasajes;
	
	public View onCreateView(LayoutInflater inflater, 
	        ViewGroup container, Bundle savedInstanceState){
		
		View viewRoot=inflater.inflate(R.layout.tab_pasajes, container, false);
		listaPasajes = (ListView) viewRoot.findViewById(R.id.listaPasajes);
		editBusquedaPasajes = (EditText) viewRoot.findViewById(R.id.txt_busqueda_pasajes);
		p = new PasajeDAO(getActivity().getApplicationContext());
		pasajes = p.obtenerPasajes();
		adaptadorPasajes = new PasajesAdapter(getActivity().getBaseContext(), pasajes);
		adaptadorPasajes.updatePasajes(pasajes);
		listaPasajes.setAdapter(adaptadorPasajes);
		registerForContextMenu(listaPasajes);
		
		return viewRoot;
	}
}
