package com.inicio.helder.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {
    
    public static String converterDateParaDataEHora(Date data){
        
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatador.format(data);
    }
}
