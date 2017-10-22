package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KecamatanMapper;
import com.example.dao.KelurahanMapper;
import com.example.model.KecamatanModel;
import com.example.model.KelurahanModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
class KelurahanServiceDatabase implements KelurahanService {

	@Autowired
	private KelurahanMapper kelurahanMapper;
	
	@Autowired
	private KecamatanMapper kecamatanMapper;
	
	@Override
	public KelurahanModel selectKelurahanviaID(String id) {
		log.info ("select penduduk with id {}", id);
		KelurahanModel kelurahan = kelurahanMapper.selectKelurahanviaID(id);
		return kelurahan;
	}

}
