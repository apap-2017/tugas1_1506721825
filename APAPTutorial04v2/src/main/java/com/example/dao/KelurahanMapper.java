package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.KelurahanModel;

@Mapper
public interface KelurahanMapper {
	
	@Select("select * from kelurahan where "
			+ "kelurahan.id = #{id}")
	@Results (value = {
			@Result(property="id", column="id"),
    		@Result(property="id_kecamatan", column="id_kecamatan"),
    		@Result(property="kode_kelurahan", column="kode_kelurahan"),
    		@Result(property="nama_kelurahan", column="nama_kelurahan"),
    		@Result(property="kode_pos", column="kode_pos"),
	})
	KelurahanModel selectKelurahanviaID (@Param("id") String id);

}
