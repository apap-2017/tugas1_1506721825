package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.KecamatanModel;

@Mapper
public interface KecamatanMapper {
	
	@Select("select * from kecamatan where "
			+ "kecamatan.id = #{id}")
	@Results (value = {
			@Result(property="id", column="id"),
    		@Result(property="kode_kecamatan", column="kode_kecamatan"),
    		@Result(property="id_kota", column="id_kota"),
    		@Result(property="nama_kecamatan", column="nama_kecamatan"),
	})
	KecamatanModel selectKecamatanviaID (@Param("id") String id);

}
