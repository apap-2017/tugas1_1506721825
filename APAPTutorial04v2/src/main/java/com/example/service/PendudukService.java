package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.PendudukModel;
import com.example.model.StudentModel;

/**
 * 
 * @author user
 * interface service buat penduduk
 */
public interface PendudukService {
	
	List<PendudukModel> selectPendudukviaIDKeluarga (int id); 
	
	PendudukModel selectPendudukViaNIK (String nik) throws Exception;
	
	 void addPenduduk (PendudukModel student);
	 
	PendudukModel quickNIKCheck(@Param("nik") String nik);

	void updatePenduduk(PendudukModel pm);


	

}
