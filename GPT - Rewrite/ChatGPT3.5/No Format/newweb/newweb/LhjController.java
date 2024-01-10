package com.newweb.controller.manager.model;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newweb.model.base.MaterialBrand;
import com.newweb.service.base.MaterialBrandService;

@Controller
public class LhjController {

	@Autowired
	private MaterialBrandService materialBrandService;

	/**
	 * Ajax request to get aluminum alloy brands as JSON.
	 *
	 * @param locale
	 * @param model
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return JSON representation of aluminum alloy brands
	 */
	@RequestMapping(value = "getLhjMaterialBrands.ajax")
	@ResponseBody
	public String getLhjMaterialBrands(Locale locale, Model model, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<MaterialBrand> materialBrands = materialBrandService.queryMaterialBrandsByType("lhj");

		String json = "{\"data\":[" +
				materialBrands.stream()
					.map(this::mapMaterialBrandToJSON)
					.collect(Collectors.joining(","))
				+ "]}";

		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Map MaterialBrand to JSON representation.
	 *
	 * @param materialBrand
	 * @return JSON representation of MaterialBrand
	 */
	private String mapMaterialBrandToJSON(MaterialBrand materialBrand) {
		return "{" +
				"\"name\":\"" + materialBrand.getName() + "\"" +
				",\"id\":\"" + materialBrand.getID() + "\"" +
				",\"py\":\"" + materialBrand.getPy() + "\"" +
				"}";
	}
}
