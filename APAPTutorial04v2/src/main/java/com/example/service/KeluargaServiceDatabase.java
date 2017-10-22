package com.example.service;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KeluargaMapper;
import com.example.dao.KelurahanMapper;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KeluargaServiceDatabase implements KeluargaService {

	@Autowired
	private KeluargaMapper keluargaMapper;
		
	@Override
	public KeluargaModel selectKeluargaviaID(int id) throws Exception {
		log.info ("select student with npm {}", id);
		KeluargaModel keluarga = keluargaMapper.selectKeluargaviaID(id);	
		return keluarga;
	}

	@Override
	public KeluargaModel selectKeluargaviaNKK(String nkk) throws Exception {
		log.info("select keluarga via NKK");
		return keluargaMapper.selectKeluargaviaNKK(nkk);
	}

	@Override
	public void addKeluarga(KeluargaModel km) {
		log.info("add keluarga");
		keluargaMapper.addKeluarga(km);
		
	}

	@Override
	public KeluargaModel quickNKKCheck(String nkk) {
		log.info("quick NKK checker");
		return keluargaMapper.quickNKKCheck(nkk);
	}

	@Override
	public void updateKeluarga(KeluargaModel keluargaNew) {
		log.info("update keluarga to new");
		keluargaMapper.updateKeluarga(keluargaNew);
		
	}

}
