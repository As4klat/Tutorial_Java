package com.mycompany.ejercicio1;

public enum enumNumero {
    AS("As"), DOS("Dos"), TRES("Tres"), CUATRO("Cuatro"), CINCO("Cinco"),
    SEIS("Seis"), SIETE("Siete"), SOTA("Sota"), CABALLO("Caballo"), REY("Rey");
    
    private String nombreBien;
    
    private enumNumero(String nombreBien){
        this.nombreBien = nombreBien;
    }
    
    public String getNombreBien(){
        return this.nombreBien;
    }
}
