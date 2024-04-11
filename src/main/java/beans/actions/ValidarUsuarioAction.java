package beans.actions;

import static com.opensymphony.xwork2.Action.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;
import org.apache.struts2.convention.annotation.*;

@Results({
    @Result(name="success", location="/WEB-INF/content/bienvenido.jsp"),
    @Result(name="input", location = "/WEB-INF/content/login.jsp" )
})
public class ValidarUsuarioAction extends ActionSupport {

    Logger log = LogManager.getLogger(LoginAction.class);

    private String persona;
    private String clave;

  
    @Action("validarUsuario")
    public String execute() {
        if ("admin".equals(this.persona)) {
            addActionMessage(getText("usuario.valido")); //es para aegregar un mensaje 
            return SUCCESS;
        } else {
            return INPUT;
        }
    }
    @Override
    public void validate(){
        if(this.persona == null || "".equals(this.persona.trim())){  //Validaciones en el login si es null o tiene una cadena vacia
           addFieldError("persona",getText("val.usuario")); //Este metodo lanza un error con una clave que es el usuari o un mensaje establecivo en un archivo properties
        }
        else if(!usuarioValido()){
            addActionError(getText("usuario.invalido"));
        }
        
        if(this.clave == null || "".equals(this.clave.trim())){
            addFieldError("clave",getText("val.password"));
        }
        else if(this.clave.length()<3){
            addFieldError("clave", getText("val.pass.min.lenght"));
        }
    }
    
    private boolean usuarioValido(){
        return "admin".equals(this.persona);
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
