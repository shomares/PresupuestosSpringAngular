package org.upiicsa.logica.Presupuesto;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.eneas.util.ZipFiles;

public class Presupuestos implements Runnable {

	private Float avance;
	private Map<String, String> salida;
	private String actual;

	private Exception ex;
	private String archivo;

	private List<IPresupuestoLogica> lista;
	private boolean busy;

	public Map<String, String> getSalida() {
		return salida;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Exception getEx() {
		return ex;
	}

	public void setEx(Exception ex) {
		this.ex = ex;
	}

	public Presupuestos() {
		// TODO Auto-generated constructor stub
		salida = new HashMap<String, String>();
		this.busy = false;
		avance = 0.0f;
		archivo = "";
	}

	public Float getAvance() {
		synchronized (avance) {
			return avance;
		}
	}

	public List<IPresupuestoLogica> getLista() {
		return lista;
	}

	public void setLista(List<IPresupuestoLogica> lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			this.busy = true;
			
			final VelocityEngine ve = new VelocityEngine();

			ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
					"org.apache.velocity.runtime.log.Log4JLogChute");
			ve.setProperty("runtime.log.logsystem.log4j.logger", "LOGGER_NAME");
			ve.setProperty("class.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

			ve.setProperty("resource.loader", "class");

			ve.init();
			for (final IPresupuestoLogica presi : lista) {
				presi.addHandlerAvance(new INotificaEvento() {

					@Override
					public void notifica(Object id) {
						// TODO Auto-generated method stub
						synchronized (avance) {
							avance = (Float) id / lista.size();
						}

					}
				});
				presi.addHandlerFin(new INotificaEvento() {

					@Override
					public void notifica(Object salidaE) {
						// TODO Auto-generated method stub
						synchronized (avance) {
							// Creo el reporte
							VelocityContext context = new VelocityContext();
							context.put("presupuesto", salidaE);
							Template t = ve.getTemplate(presi.getPlantilla());
							StringWriter writer = new StringWriter();
							t.merge(context, writer);
							System.out.println(writer.toString());
							salida.put(presi.getNombre(), writer.toString());
						}
					}
				});
				this.actual = presi.getNombre();
				presi.calcular();

			}
			generaPDF();
			this.busy = false;
		} catch (Exception ex) {
			this.ex = ex;
			this.busy = false;
		}

	}

	public void generaPDF() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Integer i = 0;
		try {
			String actual="C:\\Users\\walmart hp\\Desktop\\TEMP\\" + dateFormat.format(new Date());
			synchronized (archivo) {
				archivo = actual+ ".zip";
			}

			PrintWriter out = null;
			String carpetaT = actual;
			File carpeta = new File(carpetaT);
			FileOutputStream f;
			ZipOutputStream zip = null;

			if (!carpeta.exists())
				carpeta.mkdirs();

			try {
				for (String aux : this.getSalida().values()) {
					String filep = carpetaT + "\\" + "presupuesto" + i + ".html";
					File archivo = new File(filep);
					if (!archivo.exists())
						archivo.createNewFile();
					out = new PrintWriter(filep);
					out.println(aux);
					out.close();
					i++;
				}
				ZipFiles.zipDirectory(carpeta, archivo);

			} catch (IOException e) {
				// System.err.println("error is: "+e.getMessage());
				e.printStackTrace(); // *** this is more informative ***
			} finally {
				if (out != null) {
					out.close(); // **** closing it flushes it and reclaims
				}
				if (zip != null)
					zip.close();
				if (out != null)
					out.close();
			}
		} catch (Exception ex) {

		}

	}

	public String getActual() {
		return actual;
	}

	public boolean isBusy() {
		// TODO Auto-generated method stub
		return this.busy;
	}

}
