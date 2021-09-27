package com.mycompany.ejercicio1;

public enum enumPalo {
    OROS("Oros"), COPAS("Copas"), ESPADAS("Espadas"), BASTOS("Bastos");
    
    private String paloBien;
    
    private enumPalo(String paloBien){
        this.paloBien = paloBien;
    }
    
    public String getPaloBien(){
        return this.paloBien;
    }
}
