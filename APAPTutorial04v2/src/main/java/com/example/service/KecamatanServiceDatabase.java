package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KecamatanMapper;
import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KecamatanServiceDatabase implements KecamatanService {

	@Autowired
	private KecamatanMapper kecamatanMapper;
		
	@Override
	public KecamatanModel selectKecamatanviaID(String id) throws Exception {
		log.info ("select kecamatan with id{}", id);
		KecamatanModel kecamatan = kecamatanMapper.selectKecamatanviaID(id);	
		return kecamatan;
	}

}
