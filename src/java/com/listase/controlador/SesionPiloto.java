/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listase.modelo.ListaSE;
import com.listase.modelo.Piloto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Juan Jose Ospina B
 */
@Named(value = "sesionPiloto")
@SessionScoped
public class SesionPiloto implements Serializable {

    private ListaSE listaPiloto;
    private Piloto piloto;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    /**
     * Creates a new instance of SesionInfante
     */
    public SesionPiloto() 
    {
    }


    
    @PostConstruct
    private void inicializar()
    {
        listaPiloto=new ListaSE();
        //instancia del objeto vacio 
        
        //aqui se llena la base de datos
        listaPiloto.adicionarNodo(new Piloto("juan jose", "yamaha",(short) 2,(byte) 19));
        listaPiloto.adicionarNodo(new Piloto("juan daiego", "honda",(short) 1,(byte) 32));
        listaPiloto.adicionarNodo(new Piloto("juan carlos", "suzuki",(short) 3,(byte) 31));
        listaPiloto.adicionarNodo(new Piloto("juan martin", "yamaha",(short) 4,(byte) 37));
        piloto=listaPiloto.getCabeza().getDato();
    }

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

   
    
    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }

    
    
    public ListaSE getListaPiloto() {
        return listaPiloto;
    }

    public void setListaPiloto(ListaSE listaPiloto) {
        this.listaPiloto = listaPiloto;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    
    
    
    
    public void guardarPiloto()
    {
        piloto.setCodigo((short)(listaPiloto.contarNodos()+1));
      if(alInicio.compareTo("1")==0)
      {
          
         listaPiloto.adicionarNodoAlInicio(piloto);
      }
        
      else
      {
         listaPiloto.adicionarNodo(piloto);
      }
        piloto=new Piloto();
                
    }
    
    
    public void habilitarFomulario()
    {
        deshabilitarFormulario=false;
        piloto= new Piloto();
    }
    
}
