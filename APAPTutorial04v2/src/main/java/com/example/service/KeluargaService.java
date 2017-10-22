package com.example.service;

import com.example.model.KeluargaModel;

/**
 * 
 * @author user
 * interface service buat penduduk
 */
public interface KeluargaService {
	
	KeluargaModel selectKeluargaviaID (int id) throws Exception;
	
	KeluargaModel selectKeluargaviaNKK (String nkk) throws Exception;

	void addKeluarga(KeluargaModel km);

	KeluargaModel quickNKKCheck(String string);

	void updateKeluarga(KeluargaModel keluargaNew);
	

}
