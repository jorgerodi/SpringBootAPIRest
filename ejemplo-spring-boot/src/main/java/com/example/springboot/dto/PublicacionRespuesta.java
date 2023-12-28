package com.example.springboot.dto;

import java.util.List;

public class PublicacionRespuesta {
    private List<PublicacionDTO> contenido;
    private int numeroPagina;
    private int medidaPagina;
    private long totalElementos;
    private int totalPaginas;
    private boolean ultima;

    public void setContenido(List<PublicacionDTO> contenido) {
        this.contenido = contenido;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public void setMedidaPagina(int medidaPagina) {
        this.medidaPagina = medidaPagina;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }

    public List<PublicacionDTO> getContenido() {
        return contenido;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public int getMedidaPagina() {
        return medidaPagina;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public boolean isUltima() {
        return ultima;
    }

    public PublicacionRespuesta() {
    }

}
