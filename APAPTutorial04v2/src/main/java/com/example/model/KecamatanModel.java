package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author farhan.nurdaitama
 * 
 * kelas yang merpresentasikan kota, yey
 *
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class KecamatanModel {
	
	private int id;
	private KotaModel kota;
	private String kode_kecamatan;
	private String nama_kecamatan;
	private String id_kota;

}
