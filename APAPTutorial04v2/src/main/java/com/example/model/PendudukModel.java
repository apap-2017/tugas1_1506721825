package com.example.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author farhan.nurdaitama
 * 
 * kelas yang merpresentasikan Penduduk dan atributny
 * 
 *
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PendudukModel {
	
	private int id;
	private String nik;
	private String nama;
	private String tempat_lahir;
	private int jenis_kelamin;
	private int is_wni;
	private KeluargaModel keluarga;
	private int id_keluarga;
 	private String agama;
	private String pekerjaan;
	private String status_perkawinan;
	private String status_dalam_keluarga;
	private String golongan_darah;
	private String tanggal_lahir;
	private int is_wafat;
	
	public String kelurahan() throws Exception {
		if (keluarga == null) {
			throw new Exception("KELUARGA LU GA PUNYA");
		} else if (keluarga.getKelurahan() == null) {
			throw new Exception("KELURAHAN LU GA PUNYA");
		} else {
			return keluarga.getKelurahan().getNama_kelurahan();
		}
	}
	
	public String kecamatan() {
		return keluarga.getKelurahan().getKecamatan().getNama_kecamatan();
	}
	
	public String kota() {
		return keluarga.getKelurahan().getKecamatan().getKota().getNama_kota();
	}
	
	public String jenisKelamin() {
		return jenis_kelamin == 0 ? "Pria" : "Wanita";
	}
	
	public String kewarganegaraan() {
		return is_wni == 1 ? "Indonesia" : "Asing";
	}
	
	public String statusKematian() {
		return is_wafat == 1 ? "Wafat" : "Hidup";
	}
	
	public String tanggalLahir() throws Exception {
		//if (tanggal_lahir != null) throw new Exception(tanggal_lahir);
		String[] tanggals = tanggal_lahir.split("-");
		
		Map<String, String> map = new HashMap<>();
		map.put("01", "Januari");
		map.put("02", "Februari");
		map.put("03", "Maret");
		map.put("04", "April");
		map.put("05", "Mei");
		map.put("06", "Juni");
		map.put("07", "Juli");
		map.put("08", "Agustus");
		map.put("09", "September");
		map.put("10", "Oktober");
		map.put("11", "November");
		map.put("12", "Desember");
		
		return tanggals[2] + " " + map.get(tanggals[1]).toString() + " " + tanggals[0];
	}
	
}
