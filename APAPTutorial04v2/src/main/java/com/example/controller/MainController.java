package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.KecamatanModel;
import com.example.model.KeluargaModel;
import com.example.model.KelurahanModel;
import com.example.model.KotaModel;
import com.example.model.PendudukModel;
import com.example.service.KecamatanService;
import com.example.service.KeluargaService;
import com.example.service.KelurahanService;
import com.example.service.KotaService;
import com.example.service.PendudukService;

@Controller
public class MainController {
	@Autowired
	PendudukService pendudukDAO;
	@Autowired
	KeluargaService keluargaDAO;
	@Autowired
	KelurahanService kelurahanDAO;
	@Autowired
	KecamatanService kecamatanDAO;
	@Autowired
	KotaService kotaDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/penduduk")
	public String viewPendudukViaNIK(Model model, @RequestParam(value = "nik", required = false) String nik)
			throws Exception {

		PendudukModel penduduk = pendudukDAO.selectPendudukViaNIK(nik);
		KeluargaModel keluarga = keluargaDAO.selectKeluargaviaID(penduduk.getId_keluarga());
		KelurahanModel kelurahan = kelurahanDAO.selectKelurahanviaID(keluarga.getId_kelurahan());
		KecamatanModel kecamatan = kecamatanDAO.selectKecamatanviaID(kelurahan.getId_kecamatan());
		KotaModel kota = kotaDAO.selectKotaviaID(kecamatan.getId_kota());

		kecamatan.setKota(kota);
		kelurahan.setKecamatan(kecamatan);
		keluarga.setKelurahan(kelurahan);
		penduduk.setKeluarga(keluarga);

		model.addAttribute("penduduk", penduduk);

		return "penduduk-info";
	}

	// @RequestMapping("/student/viewall")
	// public String view (Model model)
	// {
	// List<StudentModel> students = studentDAO.selectAllStudents ();
	// model.addAttribute ("students", students);
	//
	// return "viewall";
	// }

	@RequestMapping("keluarga")
	public String viewKeluarga(Model model, @RequestParam(value = "nkk", required = false) String nkk)
			throws Exception {
		KeluargaModel keluarga = keluargaDAO.selectKeluargaviaNKK(nkk);

		KelurahanModel kelurahan = kelurahanDAO.selectKelurahanviaID(keluarga.getId_kelurahan());
		KecamatanModel kecamatan = kecamatanDAO.selectKecamatanviaID(kelurahan.getId_kecamatan());
		KotaModel kota = kotaDAO.selectKotaviaID(kecamatan.getId_kota());

		kecamatan.setKota(kota);
		kelurahan.setKecamatan(kecamatan);
		keluarga.setKelurahan(kelurahan);

		List<PendudukModel> penduduks = pendudukDAO.selectPendudukviaIDKeluarga(keluarga.getId());
		model.addAttribute("penduduks", penduduks);
		model.addAttribute("keluarga", keluarga);
		return "keluarga-info";
	}

	@RequestMapping("/penduduk/tambah")
	public String addPendudukviaKeluarga(@RequestParam(value = "flag", required = false) String flag,
			@RequestParam(value = "nama", required = false) String nama,
			@RequestParam(value = "tempat_lahir", required = false) String tempat_lahir,
			@RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
			@RequestParam(value = "status_perkawinan", required = false) String status_perkawinan,
			@RequestParam(value = "agama", required = false) String agama,
			@RequestParam(value = "jenis_kelamin", required = false) Integer jenis_kelamin,
			@RequestParam(value = "golongan_darah", required = false) String golongan_darah,
			@RequestParam(value = "pekerjaan", required = false) String pekerjaan,
			@RequestParam(value = "kewarganegaraan", required = false) Integer is_wni,
			@RequestParam(value = "id_keluarga", required = false) Integer id_keluarga,
			@RequestParam(value = "status_kematian", required = false) Integer is_wafat,
			@RequestParam(value = "status_dalam_keluarga", required = false) String status_dalam_keluarga, Model model)
			throws Exception {

		if (flag == null)
			return "form-add-penduduk";

		String nik = generateNIKFrom(id_keluarga, jenis_kelamin, tanggal_lahir);

		PendudukModel pm = new PendudukModel(0, nik.toString(), nama, tempat_lahir, jenis_kelamin, is_wni, null,
				id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, tanggal_lahir,
				is_wafat);

		pendudukDAO.addPenduduk(pm);
		model.addAttribute("nik", nik.toString());
		model.addAttribute("entitas", "Penduduk");
		model.addAttribute("judul", "NIK");
		return "add-success";
	}

	@RequestMapping("/penduduk/ubah/{nik}")
	public String ubahPendudukviaNIK(Model model, @PathVariable(value = "nik") String nik,
			@RequestParam(value = "flag", required = false) String flag,
			@RequestParam(value = "nama", required = false) String nama,
			@RequestParam(value = "tempat_lahir", required = false) String tempat_lahir,
			@RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
			@RequestParam(value = "status_perkawinan", required = false) String status_perkawinan,
			@RequestParam(value = "agama", required = false) String agama,
			@RequestParam(value = "jenis_kelamin", required = false) Integer jenis_kelamin,
			@RequestParam(value = "golongan_darah", required = false) String golongan_darah,
			@RequestParam(value = "pekerjaan", required = false) String pekerjaan,
			@RequestParam(value = "kewarganegaraan", required = false) Integer is_wni,
			@RequestParam(value = "id_keluarga", required = false) Integer id_keluarga,
			@RequestParam(value = "status_kematian", required = false) Integer is_wafat,
			@RequestParam(value = "status_dalam_keluarga", required = false) String status_dalam_keluarga) throws Exception {
		
		//if(true) throw new Exception(flag == null ? "true" : "nope");
		PendudukModel pendudukOld = pendudukDAO.selectPendudukViaNIK(nik);
		if (flag == null) {
			model.addAttribute("penduduk", pendudukOld);
			model.addAttribute("nik", nik);
			return "form-ubah-penduduk";
			
		}
			
		String newNIK = generateNIKFrom(id_keluarga, jenis_kelamin, tanggal_lahir);
		
		PendudukModel pendudukNew = new PendudukModel(pendudukOld.getId(), newNIK, nama, tempat_lahir, jenis_kelamin, is_wni, null,
				id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, tanggal_lahir,
				is_wafat);

		pendudukDAO.updatePenduduk(pendudukNew);
		model.addAttribute("nik", nik);
		
		return "success-update";
	}

	private String generateNIKFrom(Integer id_keluarga, Integer jenis_kelamin, String tanggal_lahir) throws Exception {

		KeluargaModel keluarga = keluargaDAO.selectKeluargaviaID(id_keluarga);
		KelurahanModel kelurahan = kelurahanDAO.selectKelurahanviaID(keluarga.getId_kelurahan());
		KecamatanModel kecamatan = kecamatanDAO.selectKecamatanviaID(kelurahan.getId_kecamatan());

		String[] tanggals = tanggal_lahir.split("-");
		if (jenis_kelamin == 1) {
			tanggals[2] = (new Integer(tanggals[2]) + 40) + "";
		}

		StringBuilder nik = new StringBuilder();
		nik.append(kecamatan.getKode_kecamatan().substring(0, 6));
		// String str = nik.toString();
		nik.append(tanggals[2]).append(tanggals[1]).append(new Integer(tanggals[0]) % 100);
		// String str2 = nik.toString();
		for (int i = 1; i < 10000; i++) {
			StringBuilder testedNIK = new StringBuilder().append(nik.toString());
			if (i < 10) {
				testedNIK.append("000" + i);
			} else if (i < 100) { // i>=10
				testedNIK.append("00" + i);
			} else if (i < 1000) { // i >= 100
				testedNIK.append("0" + i);
			} else { // i >= 1000
				testedNIK.append(i);
			}
			PendudukModel pm = pendudukDAO.quickNIKCheck(testedNIK.toString());
			if (pm == null) {
				nik = testedNIK;
				break;
			}

		}
		// throw new Exception(nik.toString());
		return nik.toString();
	}

	@RequestMapping("/keluarga/tambah")
	public String addKeluarga(@RequestParam(value = "flag", required = false) String flag,
			@RequestParam(value = "alamat", required = false) String alamat,
			@RequestParam(value = "rt", required = false) String rt,
			@RequestParam(value = "rw", required = false) String rw,
			@RequestParam(value = "id_kelurahan", required = false) String id_kelurahan, Model model)
			throws Exception {
		if(flag == null) return "form-add-keluarga";
		
		String nkk = generateNKKFrom(id_kelurahan);
		
		KeluargaModel km = new KeluargaModel(0, nkk, alamat, rt, rw, null, id_kelurahan, 0, null);
		
		keluargaDAO.addKeluarga(km);
		model.addAttribute("nik", nkk);
		model.addAttribute("entitas", "Keluarga");
		model.addAttribute("judul", "NKK");
		return "add-success";
	}

	private String generateNKKFrom(String id_kelurahan) throws Exception {
		
		KelurahanModel kelurahan = kelurahanDAO.selectKelurahanviaID(id_kelurahan);
		KecamatanModel kecamatan = kecamatanDAO.selectKecamatanviaID(kelurahan.getId_kecamatan());

		StringBuilder sb = new StringBuilder();
		sb.append(kecamatan.getKode_kecamatan().substring(0, 6));
		String today = new SimpleDateFormat("ddMMyy").format(new Date());
		sb.append(today);
		
		for (int i = 1; i < 10000; i++) {
			StringBuilder testedNIK = new StringBuilder().append(sb.toString());
			if (i < 10) {
				testedNIK.append("000" + i);
			} else if (i < 100) { // i>=10
				testedNIK.append("00" + i);
			} else if (i < 1000) { // i >= 100
				testedNIK.append("0" + i);
			} else { // i >= 1000
				testedNIK.append(i);
			}
			KeluargaModel km = keluargaDAO.quickNKKCheck(testedNIK.toString());
			if (km == null) {
				sb = testedNIK;
				break;
			}

		}
		return sb.toString();
	}

	@RequestMapping("/keluarga/ubah/{nkk}")
	public String ubahKeluarga(Model model, @PathVariable(value = "nkk") String nkk,
			@RequestParam(value = "flag", required = false) String flag,
			@RequestParam(value = "alamat", required = false) String alamat,
			@RequestParam(value = "rt", required = false) String rt,
			@RequestParam(value = "rw", required = false) String rw,
			@RequestParam(value = "id_kelurahan", required = false) String id_kelurahan)
					throws Exception {
		
		//if(true) throw new Exception(flag == null ? "true" : "nope");
		KeluargaModel keluargaOld = keluargaDAO.selectKeluargaviaNKK(nkk);
		//if(true )throw new Exception(keluargaOld == null? "shide" : "nope");
		if (flag == null) {
			model.addAttribute("keluarga", keluargaOld);
			model.addAttribute("nkk", nkk);
			return "form-ubah-keluarga";
			
		}
			
		String newNKK = generateNKKFrom(id_kelurahan);
		
		KeluargaModel keluargaNew = new KeluargaModel(keluargaOld.getId(), newNKK,
				alamat, rt, rw, null, id_kelurahan, 0, null);

		keluargaDAO.updateKeluarga(keluargaNew);
		model.addAttribute("nik", nkk);
		model.addAttribute("entitas", "Keluarga");
		model.addAttribute("judul", "NKK");
		
		return "success-update";
	}

	@RequestMapping("/penduduk/mati")
	public String kill(@RequestParam(value = "nik") String nik, Model model) throws Exception {
		
		PendudukModel pm = pendudukDAO.selectPendudukViaNIK(nik);
		pm.setIs_wafat(1);
		pendudukDAO.updatePenduduk(pm);
		
		
		List<PendudukModel> family = pendudukDAO.selectPendudukviaIDKeluarga(pm.getId_keluarga());
		
		boolean kill = true;
		for (PendudukModel pmd : family) {
			if (pmd.getIs_wafat() == 0) kill = false;
		}
		
		if (kill) {
			KeluargaModel keluarga = keluargaDAO.selectKeluargaviaID(pm.getId_keluarga());
			keluarga.setIs_tidak_berlaku(1);
			keluargaDAO.updateKeluarga(keluarga);
		}
		model.addAttribute("nik", nik);
		
		return "kill";
	}
	// @RequestMapping("/student/add")
	// public String add ()
	// {
	// return "form-add";
	// }
	//
	//
	// @RequestMapping("/student/add/submit")
	// public String addSubmit (
	// @RequestParam(value = "npm", required = false) String npm,
	// @RequestParam(value = "name", required = false) String name,
	// @RequestParam(value = "gpa", required = false) double gpa)
	// {
	// StudentModel student = new StudentModel (npm, name, gpa, null);
	// studentDAO.addStudent (student);
	//
	// return "success-add";
	// }
	//
	//
	// @RequestMapping("/student/view")
	// public String view (Model model,
	// @RequestParam(value = "npm", required = false) String npm)
	// {
	// StudentModel student = studentDAO.selectStudent (npm);
	//
	// if (student != null) {
	// model.addAttribute ("student", student);
	// return "view";
	// } else {
	// model.addAttribute ("npm", npm);
	// return "not-found";
	// }
	// }
	//
	//
	// @RequestMapping("/student/view/{npm}")
	// public String viewPath (Model model,
	// @PathVariable(value = "npm") String npm)
	// {
	// if(npm.contains("CS")) {
	// //CourseModel course = studentDAO.select
	// }
	// StudentModel student = studentDAO.selectStudent (npm);
	//
	// if (student != null) {
	// model.addAttribute ("student", student);
	// return "view";
	// } else {
	// model.addAttribute ("npm", npm);
	// return "not-found";
	// }
	// }
	//
	//

	//
	//
	// @RequestMapping("/student/update/{npm}")
	// public String update (Model model, @PathVariable(value = "npm") String npm) {
	// StudentModel std = studentDAO.selectStudent(npm);
	// if (std == null) {
	// return "not-found";
	// }
	// model.addAttribute("student", std);
	// return "form-update";
	// }
	//
	//
	// @PostMapping(value = "student/update/submit")
	// public String updateSubmit(@ModelAttribute StudentModel student) {
	//
	// studentDAO.updateStudent(student);
	//
	// return "success-update";
	// }
	//
	// @RequestMapping("/student/delete/{npm}")
	// public String delete (Model model, @PathVariable(value = "npm") String npm)
	// {
	// StudentModel student = studentDAO.selectStudent (npm);
	//
	// if (student == null) {
	// return "not-found";
	// }
	//
	// studentDAO.deleteStudent (npm);
	//
	// return "delete";
	// }

}
