package org.upiicsa.presupuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upiicsa.logica.IUsoMateriaPrima;
import org.upiicsa.web.Resultado;
import org.upiicsa.web.model.UsoMateriaPorProductoView;

@Controller
public class UsoMateriaPrimaProductoController {

	@Autowired
	private IUsoMateriaPrima logica;

	@RequestMapping(value = "/UsoMateriaPrima", method = RequestMethod.GET)
	public String index() {
		return "usoMateriaPrima/index";
	}

	@RequestMapping(value = "/UsoMateriaPrima/Editar", method = RequestMethod.GET)
	public String editor(@RequestParam(value = "id", required = false) Integer id) {
		return "usoMateriaPrima/editor";
	}

	@RequestMapping(value = "/UsoMateriaPrima/inserta", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<UsoMateriaPorProductoView> insertaProducto(@RequestBody UsoMateriaPorProductoView JSON) {
		Resultado<UsoMateriaPorProductoView> result = new Resultado<UsoMateriaPorProductoView>();
		try {
			logica.insertaUsoProducto(JSON);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/UsoMateriaPrima/GetIdAll", method = RequestMethod.POST)
	@ResponseBody
	public UsoMateriaPorProductoView getUsoPorProducto(@RequestBody Integer id) {
		try {
			UsoMateriaPorProductoView uso = logica.getByIdProducto(id);
			return uso;

		} catch (Exception ex) {
			return null;
		}
	}

}
