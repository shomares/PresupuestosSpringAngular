package org.upiicsa.presupuestos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Usuarios;
import org.upiicsa.web.Resultado;

@Controller
@Transactional
public class UsuarioController {

	@Autowired
	@Qualifier("daoUsuarios")
	private IDao<Usuarios> daoUsuario;

	@RequestMapping(value = "/Usuario", method = RequestMethod.GET)
	public String index() {
		return "usuarios/index";
	}

	@RequestMapping(value = "/Usuario/Editar", method = RequestMethod.GET)
	public String editor(@RequestParam(value = "id", required = false) Integer id) {
		return "usuarios/editor";
	}

	@RequestMapping(value = "/Usuario/inserta", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Usuarios> insertaUsuario(@RequestBody Usuarios JSON) {
		Resultado<Usuarios> result = new Resultado<Usuarios>();

		result.setObjeto(JSON);
		try {
			daoUsuario.insertorUpdate(JSON);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/Usuario/All", method = RequestMethod.POST)
	@ResponseBody
	public List<Usuarios> getUsuarios() {
		try {
			return daoUsuario.getAll();
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/Usuario/Delete", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Usuarios> deleteProducto(@RequestBody Integer id) {
		Resultado<Usuarios> result = new Resultado<Usuarios>();
		result.setObjeto(null);
		try {

			Usuarios user = daoUsuario.getById(id);
			if (user != null)
				daoUsuario.delete(user);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

	@RequestMapping(value = "/Usuario/DeleteAll", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Usuarios> deleteAll(@RequestBody Integer[] ids) {
		Resultado<Usuarios> result = new Resultado<Usuarios>();
		result.setObjeto(null);
		try {

			for (Integer id : ids) {
				Usuarios user = daoUsuario.getById(id);
				if (user != null)
					daoUsuario.delete(user);
			}
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

	@RequestMapping(value = "/Usuario/Id", method = RequestMethod.POST)
	@ResponseBody
	public Usuarios getUsuarioPorId(@RequestBody Integer id) {
			return daoUsuario.getById(id);
	}

}
