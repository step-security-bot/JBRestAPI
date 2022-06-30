package com.josebran.jbrestapi;

import static com.josebran.jbrestapi.Methods.*;

import android.util.Log;

import com.josebran.jbrestapi.Enumeraciones.contentType;
import com.josebran.jbrestapi.Enumeraciones.metodo;
import com.josebran.jbrestapi.Enumeraciones.typeAutentication;


class Executor extends Thread{


    private String url=null;
    private String data=null;
    private String credenciales=null;
    private typeAutentication typeautentication=null;
    private contentType contenttype=null;
    private metodo method=null;
    private String respuesta=null;

    public void run(){

        //Decide que tipo de metodo ejecuta
        Log.d("Metodo que será ejecutado: ", ""+getMethod());
        //Metodo Get
        if(getMethod() == metodo.GET){
            setRespuesta(Get(getUrl(), getData(), getCredenciales(),
                    getTypeautentication().getTipoAutenticacion(), getContenttype().getContentType()));
        }

        //Metodo Post
        if(getMethod() == metodo.POST){
            setRespuesta(Post(getUrl(), getData(), getCredenciales(),
                    getTypeautentication().getTipoAutenticacion(), getContenttype().getContentType()));
        }

        //Metodo Put
        if(getMethod() == metodo.PUT){
            setRespuesta(Put(getUrl(), getData(), getCredenciales(),
                    getTypeautentication().getTipoAutenticacion(), getContenttype().getContentType()));
        }

        //Metodo Delete
        if(getMethod() == metodo.DELETE){
            setRespuesta(Delete(getUrl(), getData(), getCredenciales(),
                    getTypeautentication().getTipoAutenticacion(), getContenttype().getContentType()));
        }

    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(String credenciales) {
        this.credenciales = credenciales;
    }

    public typeAutentication getTypeautentication() {
        return typeautentication;
    }

    public void setTypeautentication(typeAutentication typeautentication) {
        this.typeautentication = typeautentication;
    }

    public contentType getContenttype() {
        return contenttype;
    }

    public void setContenttype(contentType contenttype) {
        this.contenttype = contenttype;
    }


    public metodo getMethod() {
        return method;
    }

    public void setMethod(metodo method) {
        this.method = method;
    }


    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
