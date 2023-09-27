package com.insurance.insuranceCompany.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.insuranceCompany.contract.InsurancePackageRepository;
import com.insurance.insuranceCompany.model.Categories;
import com.insurance.insuranceCompany.model.DiseaseDetails;
import com.insurance.insuranceCompany.model.InsurancePackage;

@Controller
public class InsurancePackageController {

	private final InsurancePackageRepository insurancePackageRepository;

	@Autowired
	public InsurancePackageController(InsurancePackageRepository insurancePackageRepository) {
		this.insurancePackageRepository = insurancePackageRepository;
	}

	@GetMapping("/list")
	public String getAllInsurancePackages(Model model) {
		// Retrieve data from the repository
		List<InsurancePackage> insurancePackages = insurancePackageRepository.getAllInsurancePackages();
		model.addAttribute("insurancePackages", insurancePackages);

		return "packages";
	}

	@GetMapping("/diseasedetails/{discId}")
	public String viewDiseseDetails(@PathVariable int discId, Model model) {
		DiseaseDetails dd = insurancePackageRepository.getDiseaseDetailsById(discId);
		model.addAttribute("diseasedetails", dd);
		System.out.println("age1");
		return "diseasedetails";

	}

	@RequestMapping(value = "/start")
	public String packages() {
		return "redirect:/list";

	}

	@GetMapping("/filteredpackages")
	public String getFilteredPackages(@RequestParam("status") String status, @RequestParam("age") String age,
			Model model) {
		System.out.println(status);
		if ("ALL".equals(status) && age.equals("")) {
			System.out.println("if");
			List<InsurancePackage> insurancePackages = insurancePackageRepository.getAllInsurancePackages();

			// Add the data to the model for rendering in the Thymeleaf template
			System.out.println(insurancePackages);
			model.addAttribute("insurancePackages", insurancePackages);

			// Return the name of the Thymeleaf template to render
			return "packages";
		} else if ("ALL".equals(status) && !age.equals("")) {
			System.out.println("if");
			List<InsurancePackage> insurancePackages = insurancePackageRepository
					.getAllInsurancePackagesByAge(Integer.parseInt(age));

			// Add the data to the model for rendering in the Thymeleaf template
			System.out.println(insurancePackages);
			model.addAttribute("insurancePackages", insurancePackages);

			// Return the name of the Thymeleaf template to render
			return "packages";
		} else {

			if (age.equals("")) {
				List<InsurancePackage> insurancePackages = insurancePackageRepository.getPackagesByStatus(status);
				model.addAttribute("insurancePackages", insurancePackages);
				return "packages";
			} else {
				List<InsurancePackage> packages = insurancePackageRepository.getFilteredPackages(status,
						Integer.parseInt(age));
				model.addAttribute("insurancePackages", packages);
				System.out.println(packages);
				System.out.println(age);

				return "packages";

			}
		}

	}

	@RequestMapping(value = "/excel")
	public void downloadExcel(@RequestParam("status") String status, @RequestParam("age") String age,
			HttpServletResponse response) throws IOException {
		List<InsurancePackage> insurancePackages = new ArrayList<>();
		System.out.println(status + age);

		if ("ALL".equals(status) && age.equals("")) {
			System.out.println("if");
			insurancePackages = insurancePackageRepository.getAllInsurancePackages();

		} else if ("ALL".equals(status) && !age.equals("")) {
			System.out.println("if");
			insurancePackages = insurancePackageRepository.getAllInsurancePackagesByAge(Integer.parseInt(age));

			// Add the data to the model for rendering in the Thymeleaf template

		} else {

			if (age.equals("")) {
				insurancePackages = insurancePackageRepository.getPackagesByStatus(status);

			} else {
				insurancePackages = insurancePackageRepository.getFilteredPackages(status, Integer.parseInt(age));

			}
		}
		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Packages List");
		Row headerRow = sheet.createRow(0);

		// Define column headings
		headerRow.createCell(0).setCellValue("PackageId");
		headerRow.createCell(1).setCellValue("PackageTitle");
		headerRow.createCell(2).setCellValue("Discription");
		headerRow.createCell(3).setCellValue("Status");
		headerRow.createCell(4).setCellValue("Amount Start Range");
		headerRow.createCell(5).setCellValue("Amount End Range");
		headerRow.createCell(6).setCellValue("Age Limit Start");
		headerRow.createCell(7).setCellValue("Age Limit End");

		System.out.println(insurancePackages.size());

		int rowIdx = 1;
		for (InsurancePackage insurance : insurancePackages) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(insurance.getInspId());
			row.createCell(1).setCellValue(insurance.getInspTitle());
			row.createCell(2).setCellValue(insurance.getInspDescription());
			row.createCell(3).setCellValue(insurance.getInspStatus());
			row.createCell(4).setCellValue(insurance.getInspRangeStart());
			row.createCell(5).setCellValue(insurance.getInspRangeEnd());
			row.createCell(6).setCellValue(insurance.getInspAgeLimitStart());
			row.createCell(7).setCellValue(insurance.getInspAgeLimitEnd());

		}

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=packages.xlsx");
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.close();
	}

	@GetMapping(value = "/diseases/{inspId}/{inspTitle}")
	public String getDiseases(@PathVariable int inspId, @PathVariable String inspTitle, Model model) {
		List<DiseaseDetails> diseases = insurancePackageRepository.getDiseasesByPackageId(inspId);

		for (DiseaseDetails d : diseases) {
			System.out.println(d);
		}

		System.out.println("packId: " + inspId);

		model.addAttribute("inspId", inspId);
		model.addAttribute("inspTitle", inspTitle);
		model.addAttribute("diseases", diseases);
		return "diseasedetails";
	}

	@PostMapping("/addDiseaseBh")
	@ResponseBody
	public String addDisease(@RequestParam String name, String ICDCode, String Description, String inspId) {
		System.out.println("Bha ra" + inspId);
		int message = insurancePackageRepository.addDisease(name, ICDCode, Description, "Ac", Integer.parseInt(inspId));

		System.out.println(message);
		if (message == 1)
			return "record added successfully";
		else
			return "error occured while adding record";
	}

	@PostMapping("/deleteDiseaseBh")
	@ResponseBody
	public String deleteDisease(@RequestParam int did, int inspId) {
		System.out.println("Bha ra" + did);
		int message = insurancePackageRepository.deleteDisease(did, inspId);
		System.out.println("delete method");
		System.out.println(message);
		if (message == 1)
			return "record added successfully";
		else
			return "error occured while adding record";
	}

	@PostMapping("/editDiseaseBh")
	@ResponseBody
	public String editDisease(@RequestParam String name, String ICDCode, String Description, String Status, String Id,
			Model model) {
		String message = insurancePackageRepository.editDisease(name, ICDCode, Description, Status, Id);
		return message;
	}

	@GetMapping(value = "/categories/{inspId}/{inspTitle}")
	public String getCategories(@PathVariable int inspId, @PathVariable String inspTitle, Model model) {
		List<Categories> diseases = insurancePackageRepository.getCategoriesByPackageId(inspId);
		System.out.println("jhjhjh" + inspId);

		int insId = inspId;
		model.addAttribute("inspId", insId);
		model.addAttribute("inspTitle", inspTitle);
		model.addAttribute("categories", diseases);
		System.out.println(diseases);
		return "Categories";
	}

	@PostMapping("/deleteCategory")
	@ResponseBody
	public String deleteCategory(@RequestParam String cid, String inspId) {
		System.out.println("Bha ra" + cid);
		int message = insurancePackageRepository.deleteCategory(Integer.parseInt(cid), Integer.parseInt(inspId));
		System.out.println();

		System.out.println(message);
		if (message == 1)
			return "record added successfully";
		else
			return "error occured while adding record";
	}

	@PostMapping("/addCategory")
	@ResponseBody
	public String addCategory(@RequestParam String Title, String Description, String inspId) {
		System.out.println("Bha ra" + inspId);
		int message = insurancePackageRepository.addCategory("", Title, Description, "Ac", Integer.parseInt(inspId));

		System.out.println(message);
		if (message == 1)
			return "record added successfully";
		else
			return "error occured while adding record";
	}

	@PostMapping("/editCategory")
	@ResponseBody
	public String editCategory(@RequestParam String Title, String Description, String Status, String inspId,
			Model model) {
		String message = insurancePackageRepository.editCategory(Title, Description, Status);
		model.addAttribute("categories", insurancePackageRepository.getCategoriesByPackageId(Integer.parseInt(inspId)));
		return message;
	}

	@PostMapping("/deletePackagesBh")
	@ResponseBody
	public String deletePackages(@ModelAttribute("did") String insp) {

		int message = insurancePackageRepository.deletePackage(Integer.parseInt(insp));

		System.out.println("did" + insp);

		System.out.println(message);
		if (message == 1)
			return "record deleted successfully";
		else
			return "error occured while deleting record";
	}

	@PostMapping("/editPackageBh")
	@ResponseBody
	public String editPackage(@RequestParam String Id, String title, String Description, String status,
			String rangeStart, String rangeEnd, String ageLimitStrt, String ageLimitEnd, Model model) {
		String message = insurancePackageRepository.editPackage(Id, title, Description, status, rangeStart, rangeEnd,
				ageLimitStrt, ageLimitEnd);
		return message;
	}

	@PostMapping("/addPackageBh")
	@ResponseBody
	public String addPackage(@RequestBody InsurancePackage insurancePackage, Model model) {
		// Here, you can use the insurancePackage object which contains the JSON data
		// Do something with the data, e.g., save it to the database
		System.out.println(insurancePackage.toString());
		insurancePackageRepository.addPackage(insurancePackage);
		List<InsurancePackage> insurancePackages = insurancePackageRepository.getAllInsurancePackages();
		model.addAttribute("insurancePackages", insurancePackages);

		return "packages"; // You can return a response as needed
	}
}