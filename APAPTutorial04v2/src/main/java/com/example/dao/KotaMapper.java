package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.model.KotaModel;

@Mapper
public interface KotaMapper {
	
	@Select("select * from kota where "
			+ "kota.id = #{id}")
	@Results (value = {
			@Result(property="id", column="id"),
    		@Result(property="kode_kota", column="kode_kota"),
    		@Result(property="nama_kota", column="nama_kota"),
	})
	KotaModel selectKotaviaID (@Param("id") String id);

}
