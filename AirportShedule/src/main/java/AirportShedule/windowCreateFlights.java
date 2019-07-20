package AirportShedule;

import AirportShedule.Vuelo;
import Structures.Queue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class windowCreateFlights extends  JFrame implements ActionListener {
    private JPanel windowCreateFlights;
    private JTextField textFieldNumeroVuelo;
    private JButton registrarButton;
    private JButton regresarButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JTabbedPane tabbedPane1;
    private JPanel pnlTittle;
    private JLabel lblTittle;
    private JPanel pnlNewFlight;
    private JPanel pnlButtons;
    private JPanel flightsBoardDepartures;
    private JLabel flightlbl;
    private JLabel remarkslbl;
    private JLabel timelbl;
    private JTextArea timeTextAreaDepartures;
    private JTextArea remarksTextAreaDepartures;
    private JTextArea flightTextAreaDepartures;
    private JLabel lblImageDepartures;
    private JPanel flightsBoardArrivals;
    private JTextArea timeTeaxtAreaArrivals;
    private JTextArea remarksTextAreaArrivals;
    private JTextArea flightsTextAreaArrivals;
    private JLabel lblImageArrivals;
    Container container;
    //Variables
    Queue<Vuelo> vuelos = new Queue<>();

    //timer and timerTask
    Timer timer = new Timer();
    TimerTask Task;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

public windowCreateFlights(){
    final Date[] date = new Date[1];

    Task = new TimerTask() {
        @Override
        public void run() {
            cleantext();
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ((!vuelos.empty())) {
                date[0] = new Date();
                int tiempoActual = Integer.parseInt(format(simpleDateFormat.format(date[0])));
                try {
                    if(vuelos.size()!=0) {
                        int borrarVuelo = tiempoActual - Integer.parseInt(format(vuelos.get(vuelos.size() - 1).horaDeAterrisage));
                        if (borrarVuelo > 5) {
                            vuelos.dequeue();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                /*for (int i = 1; i <vuelos.size(); i++) {
                    try {
                        int distanciaVuelo = Integer.parseInt(format(vuelos.get(i-1).horaDeAterrisage)) - Integer.parseInt(format(vuelos.get(1).horaDeAterrisage));
                        if (distanciaVuelo < 5) {
                            int number = Integer.parseInt(format(vuelos.get(i).horaDeDespege))+5;
                            StringBuffer new_Deaprture_hour2 = new StringBuffer(String.valueOf(number));
                            new_Deaprture_hour2.insert(2,":");
                            new_Deaprture_hour2.insert(5,":");
                            String new_Deaprture_hour = String.valueOf(new_Deaprture_hour2);
                            number = Integer.parseInt(format(vuelos.get(i).horaDeAterrisage))+5;
                            new_Deaprture_hour2 = new StringBuffer(String.valueOf(number));
                            new_Deaprture_hour2.insert(2,":");
                            new_Deaprture_hour2.insert(5,":");
                            String new_Deaprture_hour3 = String.valueOf(new_Deaprture_hour2);
                            vuelos.get(i).setHoraDeDespege(new_Deaprture_hour);
                            vuelos.get(i).setHoraDeAterrisage(new_Deaprture_hour3);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }*/
                for (int i = vuelos.size()-1; i >= 0; i--) {
                    try {
                        if (tiempoActual == Integer.parseInt(format(vuelos.get(i).horaDeAterrisage))) {
                            for (int j = vuelos.size()-1; j >= 0; j--) {
                                if (tiempoActual == Integer.parseInt(format(vuelos.get(j).horaDeDespege))){
                                        int number = Integer.parseInt(format(plusSeconds(vuelos.get(j).horaDeDespege)));
                                        StringBuffer new_Deaprture_hour2 = new StringBuffer(String.valueOf(number));
                                        new_Deaprture_hour2.insert(2,":");
                                        new_Deaprture_hour2.insert(5,":");
                                        String new_Deaprture_hour = String.valueOf(new_Deaprture_hour2);
                                        number = Integer.parseInt(format(plusSeconds(vuelos.get(j).horaDeAterrisage)));

                                        new_Deaprture_hour2 = new StringBuffer(String.valueOf(number));
                                        new_Deaprture_hour2.insert(2,":");
                                        new_Deaprture_hour2.insert(5,":");
                                        String new_Deaprture_hour3 = String.valueOf(new_Deaprture_hour2);

                                        vuelos.get(j).setRemarksDespege("DELAY");
                                        vuelos.get(j).setRemarksAterrisage("DELAY");
                                        vuelos.get(j).setHoraDeDespege(new_Deaprture_hour);
                                        vuelos.get(j).setHoraDeAterrisage(new_Deaprture_hour3);
                                }

                            }
                        }else {
                            for (int j = vuelos.size()-1; j >= 0; j--) {
                                if(tiempoActual == Integer.parseInt(format(vuelos.get(j).horaDeDespege))){
                                    vuelos.get(j).setRemarksDespege("DEPARTED");
                                    vuelos.get(j).setRemarksAterrisage("FLIGHING");

                                }
                            }

                        }
                        if (tiempoActual == Integer.parseInt(format(vuelos.get(i).horaDeAterrisage))){
                            for (int j = vuelos.size()-1; j >= 0; j--) {
                                if(tiempoActual == Integer.parseInt(format(vuelos.get(j).horaDeAterrisage))){
                                    vuelos.get(j).setRemarksAterrisage("ARRIVING");

                                }
                            }
                        }

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("hola");
                }
                for (int i = vuelos.size()-1; i >= 0; i--) {
                    try {
                        flightTextAreaDepartures.setText(flightTextAreaDepartures.getText() + "\n" + vuelos.get(i).numeroDeVuelo);
                        timeTextAreaDepartures.setText(timeTextAreaDepartures.getText() + "\n" + vuelos.get(i).horaDeDespege);
                        remarksTextAreaDepartures.setText(remarksTextAreaDepartures.getText() + "\n" + vuelos.get(i).remarksDespege);
                        flightsTextAreaArrivals.setText(flightsTextAreaArrivals.getText() + "\n" + vuelos.get(i).numeroDeVuelo);
                        timeTeaxtAreaArrivals.setText(timeTeaxtAreaArrivals.getText() + "\n" + vuelos.get(i).horaDeAterrisage);
                        remarksTextAreaArrivals.setText(remarksTextAreaArrivals.getText() + "\n" + vuelos.get(i).remarksAterrisage);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }else {

            }
        }
    };

    timer.schedule(Task, 1000,1000);
    //Listeners
    registrarButton.addActionListener(this);

    container = getContentPane();
    container.add(windowCreateFlights);
    setExtendedState(MAXIMIZED_BOTH);
    setSize(400, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(true);

}
    @Override
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==registrarButton){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

            String numero_de_vuelo = textFieldNumeroVuelo.getText();
            numero_de_vuelo.replace(" ","");
            if (numero_de_vuelo.length()==0) {
            JOptionPane.showMessageDialog(null, "Por favor introduce el numero de vuelo");
                while (true) {
                    textFieldNumeroVuelo.requestFocusInWindow();
                    if (!(textFieldNumeroVuelo.equals("")))
                    break;
                }
            }
            else {
                String hora_de_despege = simpleDateFormat.format(spinner1.getValue());
                String hora_de_aterrizaje = simpleDateFormat.format(spinner2.getValue());
                Vuelo v = new Vuelo(numero_de_vuelo,hora_de_despege,hora_de_aterrizaje,"ON TIME","ON TIME");
                try {
                    if (!(validarVuelo(v))) {
                        JOptionPane.showMessageDialog(null, "Por favor introduce un numero de vuelo diferente");
                        while (true) {
                            textFieldNumeroVuelo.requestFocusInWindow();
                            if (!(textFieldNumeroVuelo.equals("")))
                                break;
                        }
                    }
                    else {
                         hora_de_despege = simpleDateFormat.format(spinner1.getValue());
                         hora_de_aterrizaje = simpleDateFormat.format(spinner2.getValue());
                         v = new Vuelo(numero_de_vuelo,hora_de_despege,hora_de_aterrizaje,"ON TIME","ON TIME");
                         vuelos.enqueue(v);
                    }
                }catch (Exception ex){
                    System.out.println("Mal manejo de cola");
                }
                try {
                    vuelos= ordenar(vuelos);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
    }else {
        for (int i = 0; i <vuelos.size() ; i++) {
            try {
                JOptionPane.showMessageDialog(null,vuelos.get(i));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    }
    public boolean validarVuelo(Vuelo vuelo)throws  Exception{
        for (int i = 0; i <this.vuelos.size() ; i++) {
            if(this.vuelos.get(i).numeroDeVuelo.equals(vuelo.getNumeroDeVuelo())){
                return false;
            }
            /*if(((this.vuelos.get(i).getHoraDeDespege())== vuelo.getHoraDeDespege() )||( this.vuelos.get(i).getHoraDeAterrisage()==(vuelo.getHoraDeAterrisage())||(this.vuelos.get(i).numeroDeVuelo==vuelo.getNumeroDeVuelo()))){
                return false;
            }*/
        }
        return true;
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        ImageIcon imageIcon = new ImageIcon("departures2.png");
        lblImageDepartures = new JLabel(imageIcon);
        ImageIcon imageIcon2 = new ImageIcon("arrivals2.png");
        lblImageArrivals = new JLabel(imageIcon2);
        Date date = new Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date,null,null, Calendar.HOUR_OF_DAY);
        spinner1 = new javax.swing.JSpinner(spinnerDateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner1,"HH:mm:ss");
        spinner1.setEditor(dateEditor);

        SpinnerDateModel spinnerDateModel2 = new SpinnerDateModel(date,null,null, Calendar.HOUR_OF_DAY);
        spinner2 = new javax.swing.JSpinner(spinnerDateModel2);
        JSpinner.DateEditor dateEditor2 = new JSpinner.DateEditor(spinner2,"HH:mm:ss");
        spinner2.setEditor(dateEditor2);
    }


    public static Queue ordenar(Queue<Vuelo> queue) throws Exception {
        Queue<Vuelo> al =  queue;
        for(int i=1; i<al.size(); i++) {
            Vuelo temp;
            if(Integer.parseInt(format(al.get(i-1).horaDeDespege))<Integer.parseInt( format(al.get(i).horaDeDespege))) {
                temp = al.get(i-1);
                al.set(i-1 ,al.get(i));
                al.set(i,temp);
                i=0;
            }
        }
        return al;
    }

    public  static  String format(String actual){
         actual = actual.replace(":","");
        return actual;
    }

    public  static String  plusSeconds (String s){
    String[] auxS = s.split(":");
    int Horas = Integer.parseInt(auxS[0]);
    int Minutos = Integer.parseInt(auxS[1]);
    int segundos = Integer.parseInt(auxS[2])+10;
    String saux = 0 + "" + segundos;
    if(segundos>60){
        Minutos++;
        segundos=segundos-60;
        saux = String.valueOf(segundos);
        if(segundos<10) {
            saux = 0 + "" + segundos;
        }
    }
    if(Minutos>60){
        Horas++;
        Minutos = 00;
    }
    if(Horas>24){
        Horas=00;
    }

    String nAux=Horas+":"+Minutos+":"+saux;
    return  nAux;
    }
    public void cleantext(){
        timeTextAreaDepartures.setText("");
        timeTeaxtAreaArrivals.setText("");
        flightsTextAreaArrivals.setText("");
        flightTextAreaDepartures.setText("");
        remarksTextAreaArrivals.setText("");
        remarksTextAreaDepartures.setText("");
    }
}
