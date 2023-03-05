package com.example.biblio.service.util;

import java.util.Date;

public class DateUtil {
    public static Date addDays(Date dateEmprunt , int nombreJourEmprunt){
        Long milliSecondeSum = dateEmprunt.getTime()+ nombreJourEmprunt*24*3600*1000 ;
        return new Date(milliSecondeSum);
    }
}
