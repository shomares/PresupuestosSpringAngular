package org.upiicsa.presupuestos;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upiicsa.logica.Presupuesto.Presupuestos;
import org.upiicsa.web.Resultado;
import org.upiicsa.web.model.AvanceView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Controller
public class PresupuestoController {

	@Autowired
	private Presupuestos logica;

	@RequestMapping(value = "/Presupuesto", method = RequestMethod.GET)
	public String index() {
		return "presupuesto/index";
	}

	@RequestMapping(value = "/Presupuesto/Calcular", method = RequestMethod.GET)
	@ResponseBody
	public Resultado<String> calcular(@RequestParam(value = "id", required = false) Integer id) {
		Resultado<String> res = new Resultado<String>();
		Thread th = new Thread(logica);
		logica.setEx(null);
		if (!logica.isBusy()) {
			th.start();
		}
		return res;
	}

	@RequestMapping(value = "/Presupuesto/GetAvance", method = RequestMethod.GET)
	@ResponseBody
	public Resultado<String> getAvance() {
		Resultado<String> avance = new Resultado<String>();

		if (logica.getEx() == null) {
			if (logica.isBusy())
				avance.setResultado("NO");
			else
				avance.setResultado("OK");
		}else
			avance.setResultado(logica.getEx().toString());
		return avance;
	}

	@RequestMapping(value = "/Presupuesto/GetPresupuesto", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPDF() {

		if (!logica.isBusy()) {
			try {
				Path path = Paths.get(logica.getArchivo());
				byte[] data = Files.readAllBytes(path);
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.parseMediaType("application/zip"));
				String filename = "presupuesto.zip";
				headers.setContentDispositionFormData(filename, filename);
				headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
				ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
				return response;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
