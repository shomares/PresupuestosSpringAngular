package org.upiicsa.presupuestos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upiicsa.dao.entidades.Actividad;
import org.upiicsa.dao.entidades.MateriaPrima;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.logica.ILogicaActividad;
import org.upiicsa.web.Resultado;
import org.upiicsa.web.model.ActividadView;

@Controller
public class ActividadController {

	@Autowired
	private ILogicaActividad logica;

	@RequestMapping(value = "/Actividad", method = RequestMethod.GET)
	public String index() {
		return "actividad/index";
	}

	@RequestMapping(value = "/Actividad/Editar", method = RequestMethod.GET)
	public String editor(@RequestParam(value = "id", required = false) Integer id) {
		return "actividad/editor";
	}

	@RequestMapping(value = "/Actividad/inserta", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Actividad> insertaProducto(@RequestBody ActividadView JSON) {
		Resultado<Actividad> result = new Resultado<Actividad>();

		Actividad pr = new Actividad();

		if (JSON.getId() != null)
			pr.setId(JSON.getId());

		pr.setNombre(JSON.getNombre());
		pr.setCargoIndirecto(JSON.getCargoIndirecto());
		pr.setDescripcion(JSON.getDescripcion());
		pr.setValesAlmacen(JSON.getValesAlmacen());
		pr.setValesMantenimiento(JSON.getValesMantenimiento());

		result.setObjeto(pr);
		try {

			if (JSON.getId() == null )
				logica.insertaActividad(pr);
			else
				logica.updateActividad(pr);

			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/Actividad/All", method = RequestMethod.POST)
	@ResponseBody
	public List<ActividadView> getAll() {
		try {
			List<Actividad> pr = logica.getActividades();
			List<ActividadView> pwd = new ArrayList<ActividadView>();

			for (Actividad actividad : pr) {
				ActividadView pv = new ActividadView();
				pv.setId(actividad.getId());
				pv.setNombre(actividad.getNombre());
				pv.setValesAlmacen(actividad.getValesAlmacen());
				pv.setValesMantenimiento(actividad.getValesMantenimiento());
				pwd.add(pv);
			}
			System.out.println(pwd.size());
			return pwd;
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/Actividad/Delete", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<MateriaPrima> deleteProducto(@RequestBody Integer id) {
		Resultado<MateriaPrima> result = new Resultado<MateriaPrima>();
		result.setObjeto(null);
		try {

			logica.borrarActividad(id);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

	@RequestMapping(value = "/Actividad/DeleteAll", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Producto> deleteAll(@RequestBody Integer[] ids) {
		Resultado<Producto> result = new Resultado<Producto>();
		result.setObjeto(null);
		try {

			for (Integer id : ids)
				logica.borrarActividad(id);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

	@RequestMapping(value = "/Actividad/Id", method = RequestMethod.POST)
	@ResponseBody
	public ActividadView getProductoPorId(@RequestBody Integer id) {
		ActividadView pv = logica.getById(id);
		return pv;
	}

}
