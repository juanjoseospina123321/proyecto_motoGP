/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import java.io.Serializable;

/**
 *
 * @author Juan Jose Ospina B
 */
public class ListaSE implements Serializable
{
    private Nodo cabeza;

    public ListaSE() 
    {
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
     
    public void adicionarNodo(Piloto piloto)
    {
        if(cabeza ==null)
        {
            cabeza=new Nodo(piloto);
        }
        else
        {
            Nodo temp=cabeza;
            while(temp.getSiguiente()!=null)
            {
                temp=temp.getSiguiente();
                
            }
            temp.setSiguiente(new Nodo (piloto));
        }
     }
    
    public void adicionarNodoAlInicio(Piloto piloto)
    {
       if(cabeza ==null)
        {
            cabeza=new Nodo(piloto);
         }
       else
       {
           Nodo temp=new Nodo(piloto);
           temp.setSiguiente(cabeza);
           cabeza=temp;
       }
     }
    
    public short contarNodos()
    {
       if(cabeza==null)
       {
           return 0;
           
       }
           
       else
       {
            //llamar a mi ayudante
           Nodo temp=cabeza;
           short cont=1;
           while(temp.getSiguiente()!=null)
           {
               temp=temp.getSiguiente();
               cont++;
           }
       return cont;
       }
       
    }
    

    
    
    
    
    

    
    
    
    
    
    
}
