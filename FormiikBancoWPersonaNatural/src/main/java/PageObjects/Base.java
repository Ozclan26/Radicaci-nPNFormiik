package PageObjects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public Properties config = new Properties();

	// ARCHIVO DE CONFIGURACION
	public void loadConfig() throws FileNotFoundException {
		InputStream configInput = null;
		try {
			configInput = new FileInputStream("config.properties");
			config.load(configInput);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// ESTABLECIENDO DRIVER CON LIBRERIA WEBDRIVER MANAGER
	public WebDriver driverManagerInstall() {
		// WebDriverManager.chromedriver().proxy("10.250.80.254:8080").version("79.0").setup();
		WebDriverManager.chromedriver().clearCache();
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		opt.addArguments("incognito");
		driver = new ChromeDriver(opt);
		return driver;
	}

	public void cambiarDeElementoaOtro(By localizador1, By localizador2) {
		WebElement elemento1 = driver.findElement(localizador1);
		WebElement elemento2 = driver.findElement(localizador2);
		Actions action = new Actions(driver);
		action.moveToElement(elemento1).moveToElement(elemento2).click().build().perform();
	}

	// METODO QUE RETORNA UNA LISTA DE ELEMENTOS POR LOCALIZADOR
	public String opcionAleatoria(By localizador, By localizador2) {
		WebElement element = driver.findElement(localizador);
		List<WebElement> elementos = element.findElements(localizador2);
		int valor = (int) (Math.random() * elementos.size() + 1);
		return String.valueOf(valor);
	}


	public void clearCache(WebDriver midriver) throws InterruptedException {
		midriver.manage().deleteAllCookies();
		Thread.sleep(7000);// ESPERA 7 SEGUNDOS MIENTRAS SE ELIMINAN TODAS LAS COOKIES
	}

	// METODO QUE ESTABLE LA CONEXION CON EL DRIVER DE CHROME
	public WebDriver ChromeDriverConexion() throws FileNotFoundException {
		loadConfig();
		System.setProperty("webdriver.chrome.driver", config.getProperty("rutaDriver"));
		ChromeOptions opt = new ChromeOptions();
		opt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		opt.addArguments("incognito");
		driver = new ChromeDriver(opt);
		return driver;
	}

	// METODO QUE ENCUENTRA UN ELEMENTO POR LOCALIZADOR
	public WebElement findElement(By localizador) {
		return driver.findElement(localizador);
	}

	// METODO QUE RETORNA UNA LISTA DE ELEMENTOS POR LOCALIZADOR
	public List<WebElement> findElements(By localizador) {
		return driver.findElements(localizador);
	}

	// METODO QUE RETORNA UNA LISTA DE ELEMENTOS POR LOCALIZADOR
	public List<WebElement> findElementsOfElement(By localizador, By localizador2) {
		WebElement element = driver.findElement(localizador);
		List<WebElement> elementos = element.findElements(localizador2);
		return elementos;
	}

	// METODO QUE RETORNA UNA LISTA DE ELEMENTOS POR LOCALIZADOR
	public List<WebElement> findElementsOfElementTest(By localizador, By localizador2) {
		WebElement element = driver.findElement(localizador);
		List<WebElement> elementos = element.findElements(localizador2);
		for (WebElement webElement : elementos) {
			System.out.println(webElement.getText());
		}
		return elementos;
	}

	// RETORNA LISTA DE ELEMENTOS HIJOS DE UN ELEMENTO WEB
	public List<WebElement> findElements(WebElement element, By localizador) {
		return element.findElements(localizador);
	}

	// METODO QUE HACE CLIC EN UN ELEMENTO RECIBIENDO LOCALIZADOR
	public void hacerClic(By localizador) {
		driver.findElement(localizador).click();
	}

	// METODO QUE HACE CLIC EN UN ELEMENTO RECIBIENDO ELEMENTO WEB
	public void hacerClic(WebElement element) {
		element.click();
	}

	// METODO QUE LIMPIA EL TEXTO DE UN ELEMENTO RECIBIENDO LOCALIZADOR
	public void cleanTest(By localizador) {
		driver.findElement(localizador).clear();
	}

	// METODO QUE LIMPIA EL TEXTO DE UN ELEMENTO RECIBIENDO ELEMENTO WEB
	public void cleanTest(WebElement element) {
		element.clear();
	}

	// METODO PARA ESCRIBIR TEXTO EN UN ELEMENTO, RECIBIENDO LOCALIZADOR
	public void escribirTexto(By localizador, String texto) {
		driver.findElement(localizador).sendKeys(texto);
	}

	// METODO PARA ESCRIBIR TEXTO EN UN ELEMENTO, RECIBIENDO ELEMENTO
	public void escribirTexto(WebElement element, String texto) {
		element.sendKeys(texto);
	}

	// METODO QUE OBTIENE TEXTO DE UN ELEMENTO
	public String obtenerTexto(WebElement elemento) {
		return elemento.getText();
	}

	// METODO QUE OBTIENE TEXTO DE UN ELEMENTO POR LOCALIZADOR
	public String obtenerTexto(By localizador) {
		String solicitud = driver.findElement(localizador).getText();
		return solicitud;
	}

	// METODO QUE OBTIENE innerHTML DE UN ELEMENTO POR LOCALIZADOR
	public int obtenerInnerHtml(By localizador) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(localizador);
		String text = (String) jse.executeScript("return arguments[0].value;", element);
		if (text.equals("")) {
			text = "0";
		}
		int numero = Integer.parseInt(text);
		return numero;
	}

	public String getInnerHtml(By localizador) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(localizador);
		String text = (String) jse.executeScript("return arguments[0].value;", element);
		return text;
	}

	// METODO QUE VERIFICA SI UN RADIO BUTTON ESTA CHEQUEADO
	public boolean isChecked(By localizador) {
		WebElement element = driver.findElement(localizador);
		Boolean chequec = element.isSelected();
		if (chequec == true) {
			return true;
		} else {
			return false;
		}
	}

	// METODO QUE PERMITE NAVEGAR EN UNA URL ESPECIFICA
	public void accesoUrl(String url) {
		driver.get(url);
	}

	// PASAR A OTRO MARCO DE TRABAJO RECIBIENDO NOMBRE DEL IFRAME
	public void cambioIframe(String nameIframe) {
		driver.switchTo().frame(nameIframe);
	}

	// PASAR A OTRO MARCO DE TRABAJO RECIBIENDO ID DEL IFRAME
	public void cambioIframeById(String idIframe) {
		driver.switchTo().frame(driver.findElement(By.id(idIframe)));
	}

	// PASAR A EL MARCO POR DEFECTO
	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

	// ACEPTAR UNA ALERTA
	public void aceptarAlerta() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// EJECUTAR SCRIPTS
	public void quitarAtributo(By localizador) {
		WebElement elementName = driver.findElement(localizador);
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", elementName);
	}

	// SCRIPT PARA MOVERSE HACIA UN ELEMENTO
	public void scrollIntoView(By localizador) {
		WebElement element = driver.findElement(localizador);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	// ESPERA VISIBILIDAD DE ELEMENTO USANDO COMO PARAMETRO EL ELEMENTO
	public void elementoVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("El elemento " + element.getAttribute("text") + " es visible");
		} catch (Exception e) {
			System.out.println("El elemento " + element.getAttribute("text") + " no aparecio");
		}
	}

	// ESPERA QUE UN ELEMENTO SEA VISIBLE, USANDO COMO PARAMETRO UN LOCALIZADOR
	public void elementoVisible(By localizador) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = driver.findElement(localizador);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(localizador));
			System.out.println("El elemento " + element.getAttribute("text") + " es visble");
		} catch (Exception e) {
			System.out.println("El elemento " + element.getAttribute("text") + " no aparecio");
		}
	}

	// ESPERA QUE UN ELEMENTO SEA INVISIBLE, USANDO COMO PARAMETRO UN LOCALIZADOR
	public void elementoInvisible(By localizador) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(localizador));
			System.out.println("Elemento ya no es visible");
		} catch (Exception e) {
			System.out.println("ya no aparecio");
		}
	}

	// ESPERA A QUE UN ELEMENTO SEA CLICQUEABLE, USANDO COMO PARAMETRO EL ELEMENTO
	public void elementoClickeable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("El elemento " + element.getAttribute("text") + " es Cliqueable");
		} catch (Exception e) {
			System.out.println("El elemento " + element.getAttribute("text") + " no es Cliqueable");
		}
	}

	// ESPERA A QUE UN ELEMENTO SEA CLICQUEABLE, USANDO COMO PARAMETRO UN
	// LOCALIZADOR
	public void elementoClickeable(By localizador) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = driver.findElement(localizador);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(localizador));
			System.out.println("El elemento " + element.getAttribute("text") + " es Cliqueable");
		} catch (Exception e) {
			System.out.println("El elemento no " + element.getAttribute("text") + " es Cliqueable");
		}
	}

	public void isDisplayed(By localizador) {
		Boolean existe = false;
		while (existe == false) {
			try {
				WebElement element = driver.findElement(localizador);
				if (element.isDisplayed() == true) {
					existe = true;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void waitOpcionesLista(By localizador, By localizador2, String opcion) {
		Boolean existe = false;
		while (existe == false) {
			try {
				WebElement element = driver.findElement(localizador);
				List<WebElement> elements = element.findElements(localizador2);
				for (WebElement webElement : elements) {
					if (webElement.getText().contains(opcion)) {
						existe = true;
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	// SUBIR FOTO
	public void subirFoto(By localizador) throws FileNotFoundException {
		loadConfig();
		WebElement element = driver.findElement(localizador);
		// String ruta =
		// "C:\\Users\\Luis1026\\Desktop\\Automatizacion_Formiik\\user.png";
		String ruta = config.getProperty("rutaFoto");
		element.sendKeys(ruta);
	}

	// METODO PARA EXPORTAR SOLICITUDES
	public void exportarSolicitudes(String solicitud, String producto, String restructuracion, String desicion,
			String perfil) {
		try {
			loadConfig();
			Date date = new Date();
			SimpleDateFormat objSDF = new SimpleDateFormat("hh: mm: ss a dd-MMM-yyyy");
			System.out.println(objSDF.format(date));
			String fecha = objSDF.format(date).toString();
			// String ruta = "src/test/resources/Solicitudes/SolicitudesRadicadas.txt";
			String ruta = config.getProperty("rutaSolicitudesRadicadas");
			File file = new File(ruta);
			if (file.exists() == false) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (perfil.contains("analista")) {
				if (restructuracion.contains("Si")) {
					if (desicion.contains("Aprobar")) {
						bw.write("\n" + fecha + " - " + solicitud + " - " + producto + " - " + "Restructurado" + " - "
								+ "Aprobada en Campo" + "\n");
					} else {
						bw.write("\n" + fecha + " - " + solicitud + " - " + producto + " - " + "Restructurado"
								+ " - Calificada" + "\n");
					}
				} else {
					if (desicion.contains("Aprobar")) {
						bw.write("\n" + fecha + " - " + solicitud + " - " + producto + " - " + "Aprobada en Campo"
								+ "\n");
					} else {
						bw.write("\n" + fecha + " - " + solicitud + " - " + producto + " - " + "Calificada" + "\n");
					}
				}
			}
			if (perfil.contains("asesor") || perfil.contains("contact")) {
				bw.write("\n" + fecha + " - " + solicitud + " - " + producto + " - " + "Radicada" + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// EXPORTAR EXCEL
	public void escribir(String identificacion, String solicitud, String tipoSol, String user, String perfil,
			String producto, String monto, String plazo, String restructuracion, String voySeg, String familia,
			String excequial, String hogar) throws FileNotFoundException {
		loadConfig();
		String ruta = config.getProperty("rutaExcel");
		String hoja = "solicitudes";
		Date date = new Date();
		SimpleDateFormat objSDF = new SimpleDateFormat("hh: mm: ss a dd-MMM-yyyy");
		String fecha = objSDF.format(date).toString();
		try {
			FileInputStream stream = new FileInputStream(ruta);
			Workbook workbook = WorkbookFactory.create(stream);
			Sheet h = workbook.getSheet(hoja);
			int rowcount = h.getLastRowNum();
			Row fila = h.createRow(rowcount + 1);
			CellStyle style = workbook.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);
			Cell cellFecha = fila.createCell(0);
			Cell cellIde = fila.createCell(1);
			Cell cellSoli = fila.createCell(2);
			Cell cellTipoSoli = fila.createCell(3);
			Cell cellUser = fila.createCell(4);
			Cell cellPerfil = fila.createCell(5);
			Cell cellProducto = fila.createCell(6);
			Cell cellMonto = fila.createCell(7);
			Cell cellPlazo = fila.createCell(8);
			Cell cellRestruc = fila.createCell(9);
			Cell cellVoySeg = fila.createCell(10);
			Cell cellFamilia = fila.createCell(11);
			Cell cellExequial = fila.createCell(12);
			Cell cellHogar = fila.createCell(13);
			cellFecha.setCellValue(fecha);
			cellFecha.setCellStyle(style);
			cellIde.setCellValue(identificacion);
			cellIde.setCellStyle(style);
			cellSoli.setCellValue(solicitud);
			cellSoli.setCellStyle(style);
			cellTipoSoli.setCellValue(tipoSol);
			cellTipoSoli.setCellStyle(style);
			cellUser.setCellValue(user);
			cellUser.setCellStyle(style);
			cellPerfil.setCellValue(perfil);
			cellPerfil.setCellStyle(style);
			cellProducto.setCellValue(producto);
			cellProducto.setCellStyle(style);
			cellMonto.setCellValue(monto);
			cellMonto.setCellStyle(style);
			cellPlazo.setCellValue(plazo);
			cellPlazo.setCellStyle(style);
			cellRestruc.setCellValue(restructuracion);
			cellRestruc.setCellStyle(style);
			cellVoySeg.setCellValue(voySeg);
			cellVoySeg.setCellStyle(style);
			cellFamilia.setCellValue(familia);
			cellFamilia.setCellStyle(style);
			cellExequial.setCellValue(excequial);
			cellExequial.setCellStyle(style);
			cellHogar.setCellValue(hogar);
			cellHogar.setCellStyle(style);
			stream.close();
			FileOutputStream salida = new FileOutputStream(ruta);
			workbook.write(salida);
			salida.close();
		} catch (Exception e) {
			String mensaje = "El archivo posiblemente esta en uso";
			System.out.println(mensaje);
		}
	}

	// MOVER MOUSE HACIA UN ELEMENTO
	public void moverMouse(By localizador) {
		Actions accion = new Actions(driver);
		accion.moveToElement(driver.findElement(localizador)).perform();
	}

	// HIJOS TABLA REFERENCIAS
	public void hijosTabla(By localizador, By localizador2) {
		WebElement div = driver.findElement(localizador);
		List<WebElement> btnsDelete = div.findElements(localizador2);
		if (btnsDelete.size() > 3) {
			btnsDelete.get(0).click();
		}
	}

	// RETORNA CANTIDAD DE REFERENCIAS Y GEOREFERENCIAS DE UN CLIENTE
	public int cantidadGeoyReferencias(By localizador, By localizador2) {
		WebElement div = driver.findElement(localizador);
		List<WebElement> deletes = div.findElements(localizador2);
		int cantidad = deletes.size();
		return cantidad;
	}

	// ESTE METODO SE HIZO CON EL FIN DE ELIMINAR REFERENCIAS DE UN CLIENTE, PERO SE
	// OBSERVO QUE NO ERA NECESARIO ELIMINAR REFERENCIAS
	// SE DEJA EL METODO PARA USAR EN UN FUTURO SI SE REQUIERE.
	public void trsReferencias(By localizador, By localizador2) {
		WebElement div = driver.findElement(localizador);
		List<WebElement> trs = div.findElements(localizador2);
		int cantidad = trs.size();
		if (cantidad > 3) {
			for (WebElement webElement : trs) {
				List<WebElement> btnsDelete = webElement.findElements(By.className("btnColDel"));
				if (btnsDelete.size() > 0) {
					btnsDelete.get(0).click();
				}
			}
		}
	}

	// ESTE METODO SE HACE CON EL FIN DE VALIDAR LA EXISTENCIA DE UN ELEMENTO
	public boolean validarExistencia(By localizador) {
		try {
			return driver.findElement(localizador).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// CREAR DIRECTORIO DE LAS EVIDENCIAS
	public void crearDirectorio(String idecaso) throws FileNotFoundException {
		// String ruta = "D:\\Evidencias\\" + idecaso;
		loadConfig();
		String ruta = config.getProperty("rutaEvidencias") + idecaso;
		File directorio = new File(ruta);
		if (directorio.exists() == false) {
			directorio.mkdirs();
		}
	}

	// CAPTURAS QUE PERTENECEN A LAS EVIDENCIAS
	public void tomarCaptura(String idecaso, String nombreCaptura) throws IOException {
		loadConfig();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// AQUI SE GUARDAN LAS EVIDENCIAS EN LA RUTA DE DESTINO
			// FileUtils.copyFile(src, new File("D:\\Evidencias\\" +
			// idecaso,nombreCaptura+".png"));
			FileUtils.copyFile(src, new File(config.getProperty("rutaEvidencias") + idecaso, nombreCaptura + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// METODO PARA CONSULTA DE SOLICITUDES
	public void resultadoConsulta(By tabla, By tr, By btnNext, String solicitud) {
		Boolean solicitudEncontrada = false;
		while (solicitudEncontrada == false) {
			try {
				WebElement table = driver.findElement(tabla);
				List<WebElement> trs = table.findElements(tr);
				for (WebElement webElement : trs) {
					String texto = webElement.getText();
					System.out.println(texto);
					if (texto.contains(solicitud)) {
						List<WebElement> botones = webElement.findElements(By.className("gridToolTip"));
						int cantidad = botones.size();
						if (cantidad > 0) {
							botones.get(2).click();
							solicitudEncontrada = true;
							break;
						}
					}
				}
				if (solicitudEncontrada == false) {
					WebElement siguiente = driver.findElement(btnNext);
					siguiente.click();
				}
			} catch (Exception e) {
				System.out.println("No esta la solicitud");
			}
		}
	}
}
