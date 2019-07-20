package AirportShedule;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Vuelo {
    String numeroDeVuelo;
    String horaDeDespege;
    String horaDeAterrisage;
    String remarksDespege;
    String remarksAterrisage;

    public Vuelo(String numeroDeVuelo, String horaDeDespege, String horaDeAterrisage ,String remarksDespege,String remarksAterrisage) {
        this.numeroDeVuelo = numeroDeVuelo;
        this.horaDeDespege = horaDeDespege;
        this.horaDeAterrisage = horaDeAterrisage;
        this.remarksDespege = remarksDespege;
        this.remarksAterrisage = remarksAterrisage;
    }
    public Vuelo() {
        this.numeroDeVuelo = "";
        this.horaDeDespege = "";
        this.horaDeAterrisage = "";
        this.remarksDespege = "";
        this.remarksAterrisage="";
    }

    public String getRemarksDespege() {
        return remarksDespege;
    }

    public void setRemarksDespege(String remarksDespege) {
        this.remarksDespege = remarksDespege;
    }

    public String getRemarksAterrisage() {
        return remarksAterrisage;
    }

    public void setRemarksAterrisage(String remarksAterrisage) {
        this.remarksAterrisage = remarksAterrisage;
    }

    public String getNumeroDeVuelo() {
        return numeroDeVuelo;
    }

    public void setNumeroDeVuelo(String numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    public String getHoraDeDespege() {
        return horaDeDespege;
    }

    public void setHoraDeDespege(String horaDeDespege) {
        this.horaDeDespege = horaDeDespege;
    }

    public String getHoraDeAterrisage() {
        return horaDeAterrisage;
    }

    public void setHoraDeAterrisage(String horaDeAterrisage) {
        this.horaDeAterrisage = horaDeAterrisage;
    }
    @Override
    public String toString() {
        return
                "Numero De Vuelo : " + numeroDeVuelo +
                        "\n Hora De Despege : " + horaDeDespege +
                        "\n Hora De Aterrisage : " + horaDeAterrisage+
                        "\n Remarks Departures : " + remarksDespege+
                        "\n Remarks Arrivings : "+ remarksAterrisage;
    }
    /*public void guardar(Queue vuelos )throws  Exception{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Vuelos.txt"))){
            for (int i = 0; i <vuelos.size() ; i++) {
                bw.write(vuelos.get(i).toString());
                bw.newLine();
            }

        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"No se encuentra el archivo");
        }
    }
    public Queue<Vuelo> recuperar(){
        Queue<Vuelo>colombianos = new Queue<>();
        Vuelo vuelo = new Vuelo();
        try(BufferedReader br = new BufferedReader(new FileReader("Vuelos.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                if(s.length()==0){
                }else {

                }
            }
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"No se encuentra el archivo");
        }
        return colombianos;
    }*/


}
