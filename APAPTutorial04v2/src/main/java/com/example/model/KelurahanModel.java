package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author farhan.nurdaitama
 * 
 * kelas yang merpresentasikan kota
 *
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class KelurahanModel {
	
	private int id;
	private KecamatanModel kecamatan;
	private String id_kecamatan;
	private String kode_kelurahan;
	private String nama_kelurahan;
	private String kode_pos;
	private List<KeluargaModel> keluargas;

}
