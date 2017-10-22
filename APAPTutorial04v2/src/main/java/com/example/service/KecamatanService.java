package com.example.service;

import com.example.model.KecamatanModel;

/**
 * 
 * @author user
 * interface service buat penduduk
 */
public interface KecamatanService {
	
	KecamatanModel selectKecamatanviaID (String id) throws Exception;
	

}
