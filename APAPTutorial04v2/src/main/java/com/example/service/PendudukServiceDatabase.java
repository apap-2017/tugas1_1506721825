package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KeluargaMapper;
import com.example.dao.PendudukMapper;
import com.example.model.KeluargaModel;
import com.example.model.PendudukModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PendudukServiceDatabase implements PendudukService {
	
	@Autowired
	private PendudukMapper pendudukMapper;
	
	@Autowired
	private KeluargaMapper keluargaMapper;
	
	
//	@Select("select * from penduduk where"
//			+ "penduduk.nik = "
//			+ "#{nik}")
//	PendudukModel selectPendudukViaNIK (@Param("nik") String nik);	

	@Override
	public PendudukModel selectPendudukViaNIK(String nik) throws Exception {
		 log.info ("select student with npm {}", nik);
	     PendudukModel penduduk = pendudukMapper.selectPendudukViaNIK (nik);
	     return penduduk;
	}
	
	@Override
	public void addPenduduk(PendudukModel student) {
		log.info("add student to database");
		pendudukMapper.addPenduduk(student);
	}



	@Override
	public List<PendudukModel> selectPendudukviaIDKeluarga(int id) {
		log.info("select all students");
		return pendudukMapper.selectPendudukviaIDKeluarga(id); 
	}
	
	@Override
	public PendudukModel quickNIKCheck(String nik) {
		log.info("select id form penduduk");
		return pendudukMapper.quickNIKCheck(nik);
	}

	@Override
	public void updatePenduduk(PendudukModel pm) {
		log.info("update penduduk pm");
		pendudukMapper.updatePenduduk(pm);	
	}




	
	/*
	 *  implementasi service databse dengan ngemap terus
	 * 
	 * pokoknya inget2 dah itu si faris ngemeng apa tadi
	 * wkwkw
	 * 
	 * terus semangat, jangan lupa tugasnya dikerjain kwkwkw
	 */

}
