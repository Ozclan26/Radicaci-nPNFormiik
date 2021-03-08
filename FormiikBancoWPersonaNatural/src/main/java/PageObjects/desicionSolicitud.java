package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class desicionSolicitud extends Base {

	public desicionSolicitud(WebDriver driver) {
		super(driver);
	}
  
	// INSTANCIA DE LOS LOCALIZADORES WEB
	By conceptoAnalista = By.id("ConAprAna");
	By adjuntarImagen = By.id("btnShowIFrame_UrlImaCli");
	By iframeImagen = By.id("ifrm_UrlImaCli");	
	By subirFoto = By.id("ajaxUploadButton");
	By seleccionFoto = By.id("fiUpload");
	By desicion = By.id("IdeDesCN");
	By desAprobacionCampo = By.id("IdeDesACN");
	By btnGuardar = By.id("btnSubmit");
	By alertaDatosGuardar = By.xpath("//p[contains(text(),'Los datos serán guardados. ¿Continuar?')]");
	By btnAceptar = By.xpath("//span[contains(text(),'Aceptar')]");
	By alertaDatosGuardados = By.xpath("//td[contains(text(),'Los datos fueron guardados')]");
	
	public void desicionSoli(String idecaso,String desicionAna,String foto) throws IOException {
		isDisplayed(conceptoAnalista);
		elementoVisible(conceptoAnalista);
		moverMouse(conceptoAnalista);
		elementoClickeable(conceptoAnalista);
		hacerClic(conceptoAnalista);
		cleanTest(conceptoAnalista);
		escribirTexto(conceptoAnalista, "Ok");
		if (foto.contains("Si")) {
			isDisplayed(adjuntarImagen);
			elementoVisible(adjuntarImagen);
			moverMouse(adjuntarImagen);
			elementoClickeable(adjuntarImagen);
			hacerClic(adjuntarImagen);
			isDisplayed(iframeImagen);
			elementoVisible(iframeImagen);
			cambioIframeById("ifrm_UrlImaCli");
			isDisplayed(seleccionFoto);
			elementoVisible(seleccionFoto);
			elementoClickeable(seleccionFoto);
			subirFoto(seleccionFoto);
			isDisplayed(subirFoto);
			elementoVisible(subirFoto);
			elementoClickeable(subirFoto);
			hacerClic(subirFoto);
			defaultContent();
		}
		Boolean existe = validarExistencia(desAprobacionCampo);
		if (existe == true) {
			isDisplayed(desAprobacionCampo);
			elementoVisible(desAprobacionCampo);
			moverMouse(desAprobacionCampo);
			elementoClickeable(desAprobacionCampo);
			waitOpcionesLista(desAprobacionCampo, By.tagName("option"), desicionAna);
			Select listDesicion = new Select(findElement(desAprobacionCampo));
			listDesicion.selectByVisibleText(desicionAna);
		}
		else {
			isDisplayed(desicion);
			elementoVisible(desicion);
			moverMouse(desicion);
			elementoClickeable(desicion);
			waitOpcionesLista(desicion, By.tagName("option"), "Calificar");
			Select listDesicion = new Select(findElement(desicion));
			listDesicion.selectByVisibleText("Calificar");
		}
		tomarCaptura(idecaso, "23-DesicionAnalista");
		isDisplayed(btnGuardar);
		elementoVisible(btnGuardar);
		elementoClickeable(btnGuardar);
		hacerClic(btnGuardar);
		isDisplayed(alertaDatosGuardar);
		elementoVisible(alertaDatosGuardar);
		isDisplayed(btnAceptar);
		elementoVisible(btnAceptar);
		elementoClickeable(btnAceptar);
		hacerClic(btnAceptar);
		isDisplayed(alertaDatosGuardados);
		elementoVisible(alertaDatosGuardados);
		tomarCaptura(idecaso, "24-SolicitudGuardada");
		isDisplayed(btnAceptar);
		elementoVisible(btnAceptar);
		elementoClickeable(btnAceptar);
		hacerClic(btnAceptar);
	}
}
