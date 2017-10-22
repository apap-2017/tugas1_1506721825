package com.example.service;

import com.example.model.KotaModel;

/**
 * 
 * @author user
 * interface service buat penduduk
 */
public interface KotaService {
	
	KotaModel selectKotaviaID (String id) throws Exception;
	
}
