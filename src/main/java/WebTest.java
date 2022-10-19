import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {
	
	public static void main(String[] args) {
		ArrayList<Persona> listaNombres = new ArrayList<Persona>();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jesus\\OneDrive\\Documentos\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.pino.mx/act23/lista.php");
		
		WebElement txtNombre;
		WebElement txtApellido;
		WebElement txtNombreRegistro;
		WebElement txtApellidoRegistro;
		WebElement txtCodigoConfirmacion;
		WebElement btnEnviar;
		String nombre;
		String apellido;
		String codigoConfirmacion;
		
		int aux = 1;
		int i = 0;
		Persona auxPersona;
		
		do
		{
			
			txtNombre = driver.findElement(By.id("nom_" + aux));
			nombre = txtNombre.getAttribute("value");
			
			txtApellido = driver.findElement(By.id("ap_"+aux));
			apellido = txtApellido.getAttribute("value");
			
			auxPersona = new Persona(nombre, apellido);
			auxPersona.setContadorPersona(aux);
			
			listaNombres.add(auxPersona);
			
			aux++;
			i++;
		} while(i != 16);
		
		i = 0;
		do
		{
			driver.get("http://www.pino.mx/act23/registro01.php");
			
			txtNombreRegistro = driver.findElement(By.id("nombre"));
			txtNombreRegistro.sendKeys(listaNombres.get(i).getNombre());
			
			txtApellidoRegistro = driver.findElement(By.id("apellidos"));
			txtApellidoRegistro.sendKeys(listaNombres.get(i).getApellido());
			
			btnEnviar = driver.findElement(By.name("Enviar"));
			btnEnviar.submit();
			
			txtCodigoConfirmacion = driver.findElement(By.id("confirmacion"));
			codigoConfirmacion = txtCodigoConfirmacion.getAttribute("value");
			
			listaNombres.get(i).setCodigo(codigoConfirmacion);
			
			i++;
		} while(i != 16);
		
		driver.quit();
		
		for(Persona p : listaNombres)
			System.out.println(p);
		
	}
}