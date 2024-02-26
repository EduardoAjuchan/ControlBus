package matricescine;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MatricesBus {

    /**
     * Control de asientos de un autobus
     */
    public static void main(String[] args) {
        String cine[][];
        String butacas[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "K"};
        int fila, columna, filas, columnas, opcion, cualFila = -1, cualColumna = -1;
        JTextArea hoja = new JTextArea();
        String salida = "", cualBoleto, filaAsiento, columnaAsiento;
        boolean salir = false, encontrado = false, devolucion = false;

        do {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas (entre 5 y 9)"));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas ( entre 5 y 9)"));
            if (filas < 5 || filas > 9) {
                JOptionPane.showMessageDialog(null, "Error. Ingrese un valor de filas correcto");
            } else if (columnas < 5 || columnas > 9) {
                JOptionPane.showMessageDialog(null, "Error. Ingrese un valor de columnas correcto");
            }
        } while ((filas < 5 || filas > 9) || (columnas < 5 || columnas > 9));
        cine = new String[filas][columnas];

        for (fila = 0; fila < filas; fila++) {
            for (columna = 0; columna < columnas; columna++) {
                cine[fila][columna] = butacas[fila] + (columna + 1);
            }
        }

        while (!salir) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea\n1. Ver Autobus\n2. Comprar boleto\n3. Devolucion de boleto\n4. Cambio de asiento"));
            if (opcion == 1) { // ver sala
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                hoja.setText(salida);
                JOptionPane.showMessageDialog(null, hoja);
            } else if (opcion == 2) { //comprar boleto
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                salida += "\nIngrese el asiento que desea comprar";
                hoja.setText(salida);
                cualBoleto = JOptionPane.showInputDialog(hoja).toUpperCase();

                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        if (cualBoleto.equals(cine[fila][columna])) {
                            cualFila = fila;
                            cualColumna = columna;
                            encontrado = true;
                        }
                    }
                }

                if (encontrado) {
                    JOptionPane.showMessageDialog(null, "Asiento #" + cualBoleto + " Asignado. que disfrute su viaje");
                    cine[cualFila][cualColumna] = "X";
                    encontrado = false;
                } else {
                    JOptionPane.showMessageDialog(null, "El asiento colocado, no se encunetra en el autobus o ya se encuentra ocupado");
                }

            } else if (opcion == 3) {
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                salida += "\nIngrese el asiento que desea devolver";
                hoja.setText(salida);
                cualBoleto = JOptionPane.showInputDialog(hoja).toUpperCase();
                filaAsiento = String.valueOf(cualBoleto.charAt(0));
                columnaAsiento = String.valueOf(cualBoleto.charAt(1));

                for (fila = 0; fila < filas; fila++) {
                    if (filaAsiento.equals(butacas[fila])) {
                        cualFila = fila;
                    }
                }

                if (cine[cualFila][cualColumna].equals("X")) {
                    JOptionPane.showMessageDialog(null, "Procesando devolucion del asiento " + filaAsiento + columnaAsiento);
                    cine[cualFila][cualColumna] = cualBoleto;
                } else {
                    JOptionPane.showMessageDialog(null, "El asiento" + cualBoleto + " No fue encontrado, o no se encuentra ocupado");
                }

            } else if (opcion == 4) {
                devolucion = false;
                cualBoleto = "";
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                salida += "\nIngrese el asiento que desea cambiar";
                hoja.setText(salida);
                cualBoleto = JOptionPane.showInputDialog(hoja).toUpperCase();
                filaAsiento = String.valueOf(cualBoleto.charAt(0));
                columnaAsiento = String.valueOf(cualBoleto.charAt(1));

                for (fila = 0; fila < filas; fila++) {
                    if (filaAsiento.equals(butacas[fila])) {
                        cualFila = fila;
                        cualColumna = Integer.parseInt(columnaAsiento) - 1;
                    }
                }
                System.out.println(cualFila);
                System.out.println(cualColumna);

                if (cualFila >= filas || cualColumna >= columnas) {
                    JOptionPane.showMessageDialog(null, "El asiento #" + cualBoleto + " No se encuentra en la sala");
                } else if(!cine[cualFila][cualColumna].equals("X")){
                    JOptionPane.showMessageDialog(null, "El asiento #"+cualBoleto+" se encuentra vacio");
                }else{
                    if (cine[cualFila][cualColumna].equals("X")) {
                        JOptionPane.showMessageDialog(null, "Procesando devolucion del asiento " + filaAsiento + columnaAsiento + "\n Preparese para cambiar de asiento");
                        cine[cualFila][cualColumna] = cualBoleto;
                        while (!devolucion) {
                            salida = "";
                            salida += "\t\tPANTALLA\n\t====================================\n\n";
                            for (fila = 0; fila < filas; fila++) {
                                for (columna = 0; columna < columnas; columna++) {
                                    salida += cine[fila][columna] + "\t";
                                }
                                salida += "\n";
                            }
                            salida += "\nIngrese el asiento que desea";
                            hoja.setText(salida);
                            cualBoleto = JOptionPane.showInputDialog(hoja).toUpperCase();

                            for (fila = 0; fila < filas; fila++) {
                                for (columna = 0; columna < columnas; columna++) {
                                    if (cualBoleto.equals(cine[fila][columna])) {
                                        cualFila = fila;
                                        cualColumna = columna;
                                        encontrado = true;
                                    }
                                }
                            }

                            if (encontrado) {
                                JOptionPane.showMessageDialog(null, "Asiento #" + cualBoleto + " Asignado. que disfrute su viaje");
                                cine[cualFila][cualColumna] = "X";
                                encontrado = false;
                                devolucion = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "El asiento colocado, no se encuentra en el Autobus o ya se encuentra ocupado");
                            }
                        }
                    }
                }

            } else {
                salir = true;
            }
        }

    }

}
