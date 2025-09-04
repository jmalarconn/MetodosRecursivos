import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Marco miMarco = new Marco();
        miMarco.setTitle("Métodos Recursivos");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Marco extends JFrame {
    public Marco() {
        setBounds(200, 200, 800, 400);
        Lamina miLamina = new Lamina();
        add(miLamina);
        setVisible(true);
    }
}

class Lamina extends JPanel {
    int x, y;
    String T;
    metodosrecursivos metodosRecursivos = new metodosrecursivos();

    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;

    public Lamina() {
        boton1 = new JButton("Factorial");
        boton2 = new JButton("Torres de Hanoi");
        boton3 = new JButton("Búsqueda binaria");
        boton4 = new JButton("Números primos");
        boton5 = new JButton("Sucesión de Collatz");
        boton6 = new JButton("Cuenta regresiva");
        boton7 = new JButton("Potencia rápida");
        boton8 = new JButton("Suma de arreglo");

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        add(boton6);
        add(boton7);
        add(boton8);

        boton1.addActionListener(new GestionEventos());
        boton2.addActionListener(new GestionEventos());
        boton3.addActionListener(new GestionEventos());
        boton4.addActionListener(new GestionEventos());
        boton5.addActionListener(new GestionEventos());
        boton6.addActionListener(new GestionEventos());
        boton7.addActionListener(new GestionEventos());
        boton8.addActionListener(new GestionEventos());
    }

    private class GestionEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton1) {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número para calcular su factorial: "));
                JOptionPane.showMessageDialog(null, "Factorial(" + x + ") = " + metodosRecursivos.factorial(x));

            } else if (e.getSource() == boton2) {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de discos para Torres de Hanoi: "));
                String resultado = metodosRecursivos.torresHanoi(x, 'A', 'C', 'B');
                JOptionPane.showMessageDialog(null, "Soluciones para Torres de Hanoi con " + x + " discos:\n" + resultado);

            } else if (e.getSource() == boton3) {
                int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo: "));
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(JOptionPane.showInputDialog("Elemento " + (i + 1) + " (ordenado ascendentemente): "));
                }
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a buscar: "));
                int posicion = metodosRecursivos.busquedaBinaria(arr, x, 0, arr.length - 1);
                if (posicion != -1) {
                    JOptionPane.showMessageDialog(null, "El valor " + x + " se encuentra en la posición: " + posicion);
                } else {
                    JOptionPane.showMessageDialog(null, "El valor " + x + " no se encuentra en el arreglo");
                }

            } else if (e.getSource() == boton4) {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número para verificar si es primo: "));
                boolean esPrimo = metodosRecursivos.esPrimo(x, 2);
                JOptionPane.showMessageDialog(null, "¿" + x + " es primo? " + (esPrimo ? "Sí" : "No"));

            } else if (e.getSource() == boton5) {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número para la sucesión de Collatz: "));
                String resultado = metodosRecursivos.collatz(x);
                JOptionPane.showMessageDialog(null, "Sucesión de Collatz para " + x + ":\n" + resultado);

            } else if (e.getSource() == boton6) {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número para la cuenta regresiva: "));
                JOptionPane.showMessageDialog(null, "Cuenta regresiva:\n" + metodosRecursivos.cuentaRegresiva(x));

            } else if (e.getSource() == boton7) {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la base: "));
                y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente: "));
                JOptionPane.showMessageDialog(null, x + "^" + y + " = " + metodosRecursivos.potenciaRapida(x, y));

            } else if (e.getSource() == boton8) {
                int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de elementos del arreglo: "));
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(JOptionPane.showInputDialog("Elemento " + (i + 1) + ": "));
                }
                JOptionPane.showMessageDialog(null, "La suma de los elementos del arreglo es: " + metodosRecursivos.sumaArreglo(arr, arr.length));
            }
        }
    }
}