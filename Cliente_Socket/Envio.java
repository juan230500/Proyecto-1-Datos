/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Socket;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

/**
 *
 * @author reds
 */
public class Envio {
    private int xy1;
    private int xy2;
    private boolean inicio;
    private String User;
    private String dibujo;
    private String ip; 

    public String getDibujo() {
        return dibujo;
    }

    public void setDibujo(String dibujo) {
        this.dibujo = dibujo;
    }
    
    

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
	
    public int getXy1() {
		return xy1;
	}
	public void setXy1(int xy1) {
		this.xy1 = xy1;
	}
	public int getXy2() {
		return xy2;
	}
	public void setXy2(int xy2) {
		this.xy2 = xy2;
	}
	public boolean isInicio() {
		return inicio;
	}
	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	 public String Shipout(Envio e) throws JsonProcessingException{
			ObjectMapper mapper = new ObjectMapper();
			String json;
				json = mapper.writeValueAsString(e);
			return json;
		}
	 public void Shipin(String json) throws JsonParseException, JsonMappingException, IOException {
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY);
			Envio e = mapper.readValue(json, Envio.class);
			this.xy1 = e.getXy1();
			this.xy2 = e.getXy2();
			this.inicio = e.inicio;
			this.User = e.User;
			
}
}