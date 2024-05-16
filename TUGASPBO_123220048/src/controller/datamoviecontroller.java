/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import java.util.ArrayList;
import DAOdatamovie.datamovieDAO;
import DAOImplement.datamovieimplement;
import model.*;
import view.MainView;
/**
 *
 * @author ACER
 */
public class datamoviecontroller {
    MainView frame;
    datamovieimplement impldatamovie;
    List<datamovie> dtm;
    
    public datamoviecontroller(MainView frame){
        this.frame = frame;
        impldatamovie = new datamovieDAO();
        dtm = impldatamovie.getAll();
    }
    public void isitabel(){
        dtm = impldatamovie.getAll();
        modeltabeldatamovie mp = new modeltabeldatamovie(dtm);
        frame.getTabelDatamovie().setModel(mp);
    }
    
    public void insert(){
        datamovie dtm = new datamovie();
        dtm.setJudul(frame.getTJudul().getText());
        dtm.setAlur(Double.parseDouble(frame.getTAlur().getText()));
        dtm.setPenokohan(Double.parseDouble(frame.getTPenokohan().getText()));
        dtm.setAkting(Double.parseDouble(frame.getTAkting().getText()));
        dtm.setNilai(dtm.hitungNilai());
        impldatamovie.insert(dtm);  
    }
    
    public void update(){
    datamovie dtm = new datamovie();
    dtm.setJudul(frame.getTJudul().getText());
    dtm.setAlur(Double.parseDouble(frame.getTAlur().getText()));
    dtm.setPenokohan(Double.parseDouble(frame.getTPenokohan().getText()));
    dtm.setAkting(Double.parseDouble(frame.getTAkting().getText()));
    dtm.setNilai(dtm.hitungNilai());
    impldatamovie.update(dtm);
}
    
    public void delete(){
        String judul = frame.getTJudul().getText();
        impldatamovie.delete(judul);
    }
}    
    
