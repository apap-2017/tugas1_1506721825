package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KotaMapper;
import com.example.model.KotaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KotaServiceDatabase implements KotaService {

	@Autowired
	private KotaMapper kotaMapper;
		
	@Override
	public KotaModel selectKotaviaID(String id) throws Exception {
		log.info ("select student with npm {}", id);
		KotaModel kota = kotaMapper.selectKotaviaID(id);	
		return kota;
	}

}
