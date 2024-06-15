/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package descargarsdn;

/**
 *
 * @author daveortega
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.text.SimpleDateFormat; 
import java.util.Date; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DescargarSDN extends JFrame {

//    JTextField txt;
//    JEditorPane txtfuente;
//    JButton btnobtener;

//    public DescargarSDN() {
//        txt = new JTextField(22);
//        txtfuente = new JEditorPane();
//        txtfuente.setPreferredSize(new Dimension(380, 300));
//        btnobtener = new JButton("Obtener");
//        btnobtener.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                txtfuente.setText(obtenerCodigoFuente(txt.getText()));
//            }
//        });
//        JPanel purl = new JPanel();
//        purl.add(new JLabel("URL: "));
//        purl.add(txt);
//        purl.add(btnobtener);
//        JPanel pfuente = new JPanel();
//        pfuente.add(new JScrollPane(txtfuente));
//
//        add(purl, BorderLayout.NORTH);
//        add(pfuente);
//    }
    
    public static void obtenerCodigoFuente(String url) {
        String linea;
        StringBuilder buffer = new StringBuilder();

        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
        String cadenaFecha = formato.format(fechaActual);
        
     //   System.out.println(cadenaFecha);
        
        File f;
        f = new File("./Temporal" + cadenaFecha + ".xml");
 
        try {
            URL urlpagina = new URL(url);
            InputStreamReader isr = new InputStreamReader(urlpagina.openStream());
            BufferedReader br = new BufferedReader(isr);
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            while ((linea = br.readLine()) != null) {
                buffer.append(linea);
                wr.write(linea + "\n");
            }
            br.close();
            isr.close();
            wr.close();
            bw.close();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Error en la url, ejemplo http://www.java-elrincondetucasa.blogspot.com");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
       // return buffer.toString();
    }

    public static void main(String arg[]) {
//        DescargarSDN p = new DescargarSDN();
//        p.setVisible(true);
//        p.setBounds(0, 0, 400, 400);
//        p.setLocationRelativeTo(null);
        String txt1 = "https://www.treasury.gov/ofac/downloads/sdn.xml";
        obtenerCodigoFuente(txt1);
   }
}
