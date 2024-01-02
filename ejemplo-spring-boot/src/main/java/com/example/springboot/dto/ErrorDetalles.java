package com.example.springboot.dto;
 import java.util.Date;

public class ErrorDetalles {
     private Date marcaDeTiempo;
    private String mensaje;
    private String detalles;
    
    
    public ErrorDetalles(Date marcaDeTiempo, String mensaje, String detalles) {
        this.marcaDeTiempo = marcaDeTiempo;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }
    public Date getMarcaDeTiempo() {
        return marcaDeTiempo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public String getDetalles() {
        return detalles;
    }
    public void setMarcaDeTiempo(Date marcaDeTiempo) {
        this.marcaDeTiempo = marcaDeTiempo;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

   
}
