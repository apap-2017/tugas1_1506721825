package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.PendudukModel;

@Mapper
public interface PendudukMapper {

	@Select("select * from penduduk where " + " penduduk.nik=" + "#{nik}")
	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "nama", column = "nama"),
			@Result(property = "nik", column = "nik"), @Result(property = "tempat_lahir", column = "tempat_lahir"),
			@Result(property = "is_wni", column = "is_wni"),
			@Result(property = "jenis_kelamin", column = "jenis_kelamin"),
			@Result(property = "agama", column = "agama"), @Result(property = "id_keluarga", column = "id_keluarga"),
			@Result(property = "pekerjaan", column = "pekerjaan"),
			@Result(property = "status_perkawinan", column = "status_perkawinan"),
			@Result(property = "status_dalam_keluarga", column = "status_dalam_keluarga"),

	})
	PendudukModel selectPendudukViaNIK(@Param("nik") String nik);

	@Select("select * from penduduk where id_keluarga=#{id}")
	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "nama", column = "nama"),
			@Result(property = "nik", column = "nik"), @Result(property = "tempat_lahir", column = "tempat_lahir"),
			@Result(property = "is_wni", column = "is_wni"),
			@Result(property = "jenis_kelamin", column = "jenis_kelamin"),
			@Result(property = "agama", column = "agama"), @Result(property = "id_keluarga", column = "id_keluarga"),
			@Result(property = "pekerjaan", column = "pekerjaan"),
			@Result(property = "tanggal_lahir", column = "tanggal_lahir"),
			@Result(property = "status_perkawinan", column = "status_perkawinan"),
			@Result(property = "status_dalam_keluarga", column = "status_dalam_keluarga"),

	})
	List<PendudukModel> selectPendudukviaIDKeluarga(@Param("id") int id);

	@Select("select id from penduduk where nik=#{nik}")
	@Results(value = { @Result(property = "id", column = "id") })
	PendudukModel quickNIKCheck(@Param("nik") String nik);

	// @Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name},
	// #{gpa})")
	@Insert("INSERT INTO `penduduk`(`nik`, `nama`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`,"
			+ " `is_wni`, `id_keluarga`, `agama`, `pekerjaan`, `status_perkawinan`, `status_dalam_keluarga`,"
			+ " `golongan_darah`, `is_wafat`) VALUES (#{nik}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}"
			+ ", #{jenis_kelamin}, #{is_wni}, #{id_keluarga}, #{agama}, #{pekerjaan}, #{status_perka"
			+ "winan}, #{status_dalam_keluarga}, #{golongan_darah}, #{is_wafat})")
	void addPenduduk(PendudukModel student);

	// @Insert("VALUES (#{nik}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}"
	// + ", #{jenis_kelamin}, #{is_wni}, #{id_keluarga}, #{agama}, #{pekerjaan},
	// #{status_perka"
	// + "winan}, #{status_dalam_keluarga}, #{golongan_darah}, #{is_wafat})")
	@Update("UPDATE `penduduk` SET `nik`=#{nik},`nama`=#{nama},"
			+ "`tempat_lahir`=#{tempat_lahir},`tanggal_lahir`=#{tanggal_lahir},"
			+ "`jenis_kelamin`=#{jenis_kelamin},`is_wni`=#{is_wni},`id_keluarga`=#{id_keluarga},"
			+ "`agama`=#{agama},`pekerjaan`=#{pekerjaan},`status_perkawinan`=#{status_perkawinan},"
			+ "`status_dalam_keluarga`= #{status_dalam_keluarga},"
			+ "`golongan_darah`=#{golongan_darah},`is_wafat`=#{is_wafat} WHERE id = #{id}")
	void updatePenduduk(PendudukModel pm);

}
