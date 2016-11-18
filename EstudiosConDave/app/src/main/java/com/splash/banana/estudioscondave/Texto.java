package com.splash.banana.estudioscondave;

import android.text.Editable;

import java.io.Serializable;
import java.security.PublicKey;

/**
 * Created by fernando on 18/11/16.
 */

public class Texto implements Serializable{
    public String texto;

    public Texto(){
        this.texto="";
    }
    public Texto(String texto){
        this.texto=texto;
    }

}
