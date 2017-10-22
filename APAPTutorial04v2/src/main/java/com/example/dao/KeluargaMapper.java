package com.example.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.KeluargaModel;

@Mapper
public interface KeluargaMapper {
	
	@Select("select * from keluarga where "
			+ "keluarga.id= "
			+ "#{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="nomor_kk", column="nomor_kk"),
			@Result(property="rw", column="rw"),
			@Result(property="id_kelurahan", column="id_kelurahan"),
			@Result(property="is_tidak_berlaku", column="is_tidak_berlaku")
	})
	KeluargaModel selectKeluargaviaID (@Param("id") int id);
	
	@Select("select * from keluarga where "
			+ "nomor_kk="
			+ "#{nkk}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="nomor_kk", column="nomor_kk"),
			@Result(property="rw", column="rw"),
			@Result(property="rt", column="rt"),
			@Result(property="id_kelurahan", column="id_kelurahan"),
			@Result(property="is_tidak_berlaku", column="is_tidak_berlaku")
	})
	KeluargaModel selectKeluargaviaNKK (@Param("nkk") String nkk);

//	@Insert("INSERT INTO `penduduk`(`nik`, `nama`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`,"
//			+ " `is_wni`, `id_keluarga`, `agama`, `pekerjaan`, `status_perkawinan`, `status_dalam_keluarga`,"
//			+ " `golongan_darah`, `is_wafat`) VALUES (#{nik}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}"
//			+ ", #{jenis_kelamin}, #{is_wni}, #{id_keluarga}, #{agama}, #{pekerjaan}, #{status_perka"
//			+ "winan}, #{status_dalam_keluarga}, #{golongan_darah}, #{is_wafat})")
	@Insert("INSERT INTO `keluarga`(`nomor_kk`, `alamat`, `RT`, `RW`, `id_kelurahan`, `is_tidak_berlaku`)"
			+ " VALUES (#{nomor_kk},#{alamat},#{rt},#{rw},#{id_kelurahan},#{is_tidak_berlaku})")
	void addKeluarga(KeluargaModel km);

	
	
	@Select("select id from keluarga where nomor_kk=#{nkk}")
	@Results(value = { @Result(property="id", column = "id")})
	KeluargaModel quickNKKCheck(@Param("nkk") String nkk);

	@Update("UPDATE `keluarga` SET `id`=#{id},`nomor_kk`=#{nomor_kk},`alamat`=#{alamat},"
			+ "`RT`=#{rt},`RW`=#{rw},`id_kelurahan`=#{id_kelurahan},`is_tidak_berlaku`=#{is_tidak_berlaku}"
			+ " WHERE id=#{id}")
	void updateKeluarga(KeluargaModel keluargaNew);
	
	
	
	

}
