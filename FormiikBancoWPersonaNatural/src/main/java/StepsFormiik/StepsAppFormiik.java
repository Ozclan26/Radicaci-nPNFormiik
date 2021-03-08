package StepsFormiik;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import PageObjects.analisisCrédito;
import PageObjects.desicionSolicitud;
import PageObjects.loguinFormiik;
import PageObjects.productoRadicacion;
import PageObjects.radicarSolicitud;
import net.thucydides.core.annotations.Step;

public class StepsAppFormiik {
	
	loguinFormiik inicio;
	radicarSolicitud radicacion;
	analisisCrédito analisis;
	productoRadicacion prod;
	desicionSolicitud des;
	WebDriver driver;
	@Step
	public void setup() throws FileNotFoundException, InterruptedException {
		inicio = new loguinFormiik(driver);
		driver = inicio.driverManagerInstall();
		//driver = inicio.ChromeDriverConexion();
		driver.manage().window().maximize();
		inicio.clearCache(driver);
		inicio.accesoUrl("https://app.formiik.com/Login/wwbtst");	
		//inicio.accesoUrl("https://app.formiik.com/Login/wwbdes");
	}
	
	@Step
	public void inicioSesion(String idecaso,String usuario, String password, String tipoSolicitud, String perfil) throws IOException {
		inicio.loguin(idecaso, usuario, password);
		inicio.crearNuevaOrden(idecaso,tipoSolicitud, perfil);
		//driver.navigate().to(driver.getCurrentUrl());
	}
	
	@Step
	public void consultaCliente(String idecaso,String tipoDoc, String identificacion, String apellido, String nombre, String perfil) throws IOException, InterruptedException {
		inicio.consultaCliente(idecaso,tipoDoc, identificacion, apellido, nombre,perfil);
	}
	
	@Step
	public void radicacionSolicitud(String apellido, String nombre,String idecaso,String barrio, String codigoBarrio, String estrato,String pep, String actividadRiesgosa,String perfil) throws IOException{
		radicacion = new radicarSolicitud(driver);
		radicacion.realizarRadicacion(apellido,nombre,idecaso,barrio, codigoBarrio, estrato,pep,actividadRiesgosa,perfil);
	}
	
	@Step
	public void seleccionMenuRadicacion() {
		radicacion.clicMenuRadicacion();
	}
	
	@Step
	public void datosDelCredito(String idecaso,String tipoCredito, String producto, String monto, String plazo, String frecuencia,String restructuracion) throws IOException, InterruptedException {
		radicacion.datosCredito(idecaso,tipoCredito, producto, monto, plazo, frecuencia,restructuracion);
	}
	
	@Step
	public void selecAnalista(String idecaso,String agencia, String analista, String producto, String perfil) throws IOException {
		radicacion.seleccionAnalista(idecaso,agencia, analista, producto, perfil);
	}
	
	@Step 
	public void efectuarRadicacionSolicitud(String idecaso,String producto, String perfil,String restructuracion,String desicion) throws IOException {
		radicacion.efectuarRadicacion(idecaso,producto, perfil,restructuracion,desicion);
	}
	
	@Step
	public void analisisDelCredito(String idecaso,String barrio, String codigoBarrio, String totalVentas,String perfil) throws InterruptedException, IOException {
		analisis = new analisisCrédito(driver);
		analisis.analisisCaracter(idecaso,barrio,codigoBarrio,perfil);
		analisis.infoFinanciera(idecaso,totalVentas,perfil);
		analisis.declaracionRenta(idecaso);
	}
	
	@Step
	public void productCredito(String idecaso,String producto,String monto, String plazo, String frecuencia,String fechaDes, String fechaCuo,String tipoCredito, String restructuracion,String voySeguro, String familia, String exequial, String hogar,String recogerCreditos,String desemCuenta) throws IOException, InterruptedException {
		prod = new productoRadicacion(driver);
		prod.dataProducto(idecaso,producto,monto, plazo, frecuencia,fechaDes,fechaCuo,tipoCredito,restructuracion,voySeguro,familia,exequial,hogar,recogerCreditos,desemCuenta);
	}
	
	@Step
	public void desicionAnalista(String idecaso,String desicionAna,String foto) throws IOException {
		des = new desicionSolicitud(driver);
		des.desicionSoli(idecaso,desicionAna,foto);
	}
	
	@Step
	public void searchSolicitud(String idecaso,String usuario, String password,String tipoSolicitud, String solicitud) throws IOException {
		inicio.loguin(idecaso, usuario, password);
		inicio.filtroSolicitud(tipoSolicitud, solicitud);
		//radicacion.clienteConsultado();
	}
	
	@Step 
	public void excel(String identificacion,String solConsulta,String tipoSol, String user, String perfil, 
			String producto, String monto, String plazo, String restructuracion, String voySeg, String familia, String excequial, String hogar) throws EncryptedDocumentException, IOException {
		radicacion.exportarSolicitudes(identificacion, solConsulta, tipoSol, user, perfil, producto, monto, plazo, restructuracion, voySeg, familia, excequial, hogar);
	}
	
	@Step
	public void finish() {
		driver.close();
	}
}
