package cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.lopezriba.carlos.s05.t01.n01.model.services.SucursalService;

@CrossOrigin(origins = "http://localhost:9001")
@Controller
@RequestMapping("/sucursal")
public class SucursalController {
		
		@Autowired
		SucursalService sucursalService;
		
	    @GetMapping({"", "/getAll"})
	    public String viewHomePage(Model model) {
	        model.addAttribute("llistaSucursal", sucursalService.findAllSucursal());
	        return "index";
	    }

	    @GetMapping("/showNewSucursalForm")
	    public String showNewSucursalForm(Model model) {
	        SucursalDTO sucursal = new SucursalDTO();
	        model.addAttribute("sucursal", sucursal);
	        return "new_sucursal";
	    }

	    @PostMapping("/add")
	    public String saveSucursal(@ModelAttribute("sucursal") SucursalDTO sucursal) {
	    	sucursalService.saveSucursal(sucursal);
	        return "redirect:/sucursal";
	    }

	    @GetMapping("/update/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
	    	SucursalDTO sucursal = sucursalService.findSucursalById(id);
	        model.addAttribute("sucursal", sucursal);
	        return "update_sucursal";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteSucursal(@PathVariable(value = "id") long id) {
	        this.sucursalService.deleteSucursalById(id);
	        return "redirect:/sucursal";
	    }
	    
	    @GetMapping("/getOne/{id}")
	    public String getOneSucursal(@PathVariable(value = "id") long id, Model model) {
	    	SucursalDTO sucursal = sucursalService.findSucursalById(id);
	    	model.addAttribute("sucursal", sucursal);
	    	return "get_sucursal";
	    }
	    
	    @GetMapping("/page/{pageNo}")
		public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
				@RequestParam("sortField") String sortField,
				@RequestParam("sortDir") String sortDir,
				Model model) {
			int pageSize = 5;
			
			Page<SucursalDTO> page = sucursalService.findPaginated(pageNo, pageSize, sortField, sortDir);
			List<SucursalDTO> llistaSucursal = page.getContent();
			
			model.addAttribute("currentPage", pageNo);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());
			
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
			
			model.addAttribute("llistaSucursal", llistaSucursal);
			return "index";
		}
		
	}
