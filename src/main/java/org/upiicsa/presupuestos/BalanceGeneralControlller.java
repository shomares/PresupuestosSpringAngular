package org.upiicsa.presupuestos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.BalanceGeneral;
import org.upiicsa.dao.entidades.Configuracion;
import org.upiicsa.web.Resultado;
import org.upiicsa.web.model.ConfiguracionView;

@Controller
public class BalanceGeneralControlller {

	@Autowired
	@Qualifier(value = "daoBalanceGeneral")
	private IDao<BalanceGeneral> dao;

	@RequestMapping(value = "/BalanceGeneral", method = RequestMethod.GET)
	public String index() {
		return "balanceGeneral/index";
	}
	@ResponseBody
	@RequestMapping(value = "/BalanceGeneral/Get", method = RequestMethod.POST)
	public BalanceGeneral getConfiguracion() {
		List<BalanceGeneral> conf = dao.getAll();
		BalanceGeneral config = new BalanceGeneral();
		if (conf.isEmpty()) {
			config = new BalanceGeneral();
			dao.insertorUpdate(config);
		} else
			config = conf.get(0);

		return config;
	}
	@RequestMapping(value = "/BalanceGeneral/inserta", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<BalanceGeneral> insert(@RequestBody BalanceGeneral config) {
		Resultado<BalanceGeneral> result = new Resultado<BalanceGeneral>();
		try {
			dao.insertorUpdate(config);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

}
