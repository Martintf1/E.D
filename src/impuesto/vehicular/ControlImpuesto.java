/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impuesto.vehicular;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author M4rtin
 */
public class ControlImpuesto {

    Scanner in = new Scanner(System.in);
    int numMotor[]; //arreglo sin tamaño
    ArrayList vehiculos = new ArrayList(); //lista de vehiculos

    void registrar() {
        in.nextLine();
        System.out.println("...REGISTRO VEHICULO...");
        System.out.print("Digite el numero de placa: ");
        String placa = in.nextLine();
        in.nextLine();
        System.out.print("Digite el numero del motor: ");
        int numeroMotor = in.nextInt();
        System.out.print("Digite el valor a pagar: ");
        double valorPagar = in.nextDouble();
        System.out.print("Digite el nombre del propietario: ");
        in.nextLine();
        String propietario = in.nextLine();
        System.out.print("Digite el modelo del vehiculo: ");
        String modelo = in.nextLine();

        Vehiculo objeto = new Vehiculo(); //obj clase vehiculo 

        objeto.setPlaca(placa);
        objeto.setNumeroMotor(numeroMotor);
        objeto.setValorPagar(valorPagar);
        objeto.setPropietario(propietario);
        objeto.setModelo(modelo); // guardar datos ingresados 

        vehiculos.add(objeto); //agregar  los datos a la lista 

        System.out.println("VEHICULO REGISTRADO");

    }

    void buscarVehiculo() {
        in.nextLine();
        boolean bandera = false;

        System.out.println("...BUSCAR VEHICULO POR NUMERO DE PLACA...");
        System.out.print("Digite placa a buscar: ");
        String placaBuscar = in.nextLine();

        for (int i = 0; i < vehiculos.size(); i++) { //recorrer toda la lista, .size el tamaño de la lista vehiculo, lista dinamica
            Vehiculo recuperar = (Vehiculo) vehiculos.get(i);  // ----
            if (recuperar.getPlaca().equalsIgnoreCase(placaBuscar)) { //comparar ignorando may de min
                bandera = true;
                System.out.println("PLACA: " + recuperar.getPlaca() + "\nNUMERO DE MOTOR: " + recuperar.getNumeroMotor() + "\nVALOR A PAGAR:" + recuperar.getValorPagar() + "\nPROPIETARIO:" + recuperar.getPropietario() + "\nMODELO:" + recuperar.getModelo());
            }
        }

        if (bandera == false) {
            System.out.println("NO SE ENCONTRO NUMERO DE PLACA EN EL SISTEMA!");
        }
    }

    void buscarModelo() {
        in.nextLine();
        boolean bandera = false;

        System.out.println("...BUSCAR VEHICULO POR MODELO...");
        System.out.print("Digite modelo de vehiculo a buscar: ");
        String modeloBuscar = in.nextLine();

        for (int i = 0; i < vehiculos.size(); i++) { //buscar en la lista 
            Vehiculo recuperar = (Vehiculo) vehiculos.get(i); //---
            if (recuperar.getModelo().equalsIgnoreCase(modeloBuscar)) {
                bandera = true;
                System.out.println("PLACA: " + recuperar.getPlaca() + "\nNUMERO DE MOTOR: " + recuperar.getNumeroMotor() + "\nVALOR A PAGAR:" + recuperar.getValorPagar() + "\nPROPIETARIO:" + recuperar.getPropietario() + "\nMODELO:" + recuperar.getModelo());
            }
        }

        if (bandera == false) {
            System.out.println("NO SE ENCONTRO NUMERO MODELO DEL VEHICULO EN EL SISTEMA!");
        }
    }

    void guardarNumMotor() {
        numMotor = new int[vehiculos.size()];
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo recuperar = (Vehiculo) vehiculos.get(i); //----
            numMotor[i] = recuperar.getNumeroMotor();  //guardar los numeros del motor en el arreglo num mtor
        }
        System.out.println("NUMEROS DE MOTOR GUARDADOS");
    }

    void ordenarporBurbuja(int arreglo[]) {
        int n = arreglo.length;
        //variable usada pa
        int aux = 0;

        for (int i = 0; i < n - 1; i++) {
            /*Este ciclo se encraga de llevar el mayor al final del arreglo
			 * Va desde 0 hasta se haya ido ornando el mayor
			 * */
            for (int j = 0; j < n - i - 1; j++) {
                //en caso de que se cumpla la condicion se intercambia la posicion
                if (arreglo[j] > arreglo[j + 1]) {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }

        }

        //Listar el arreglo ordenado
        System.out.println("\n---Arreglo ordenado por metodo Burbuja----");
        for (int i : arreglo) {
            System.out.print(i + "-");
        }

    }

    public void ordenarPorInserccion() {
        int insercion; // variable temporal para contener el elemento a insertar

        // itera a trav�s de datos.length - 1 elementos
        for (int siguiente = 1; siguiente < numMotor.length; siguiente++) {
            // almacena el valor en el elemento actual
            insercion = numMotor[siguiente];

            // inicializa ubicaci�n para colocar el elemento
            int moverElemento = siguiente;

            // busca un lugar para colocar el elemento actual
            while (moverElemento > 0 && numMotor[moverElemento - 1] > insercion) {
                // desplaza el elemento una posici�n a la derecha
                numMotor[moverElemento] = numMotor[moverElemento - 1];
                moverElemento--;
            } // fin de while

            numMotor[moverElemento] = insercion; // coloca el elemento insertado
            //imprimirPasada( siguiente, moverElemento ); // imprime la pasada del algoritmo
        }
    }

    void buscar() {
        System.out.println("Buscanco...");
        System.out.print("Digite el numero a buscar: ");
        int numBuscado = in.nextInt();

        //llamo al metodo del algortimo de busqueda binaria
        int datoRet = this.busquedaBinaria(numBuscado);

        if (datoRet == -1) {
            System.out.println("Numero no Encontrado!!");
        } else {
            System.out.println("Encontrado. Posicion=" + datoRet);
        }

    }

    public int busquedaBinaria(int elementoBusqueda) {
        int inferior = 0; // extremo inferior del �rea de b�squeda
        int superior = numMotor.length - 1; // extremo superior del �rea de b�squeda
        int medio = (inferior + superior + 1) / 2; // elemento medio
        int ubicacion = -1; // devuelve el valor; -1 si no lo encontr�

        do {
            if (elementoBusqueda == numMotor[medio]) {
                ubicacion = medio; // la ubicaci�n es el elemento medio actual
            } // el elemento medio es demasiado alto
            else if (elementoBusqueda < numMotor[medio]) {
                superior = medio - 1; // elimina la mitad superior
            } else // el elemento medio es demasiado bajo
            {
                inferior = medio + 1; // elimina la mitad inferior
            }
            medio = (inferior + superior + 1) / 2; // recalcula el elemento medio
        } while ((inferior <= superior) && (ubicacion == -1));

        return ubicacion; // devuelve 
    }

    void menu() {
        int opc = 0;
        do {
            System.out.println("""
                               Muenu:
                               1.registro
                               2.buscar vehiculo por placa
                               3. buscar modelo
                               4. guardar numero de motor
                               5.ordenar por burbuja
                               6.ordenar por insercion
                               7. buscar numero de motorusando busqueda binaria
                               seleccione una opcion;
                               """);
            opc = in.nextInt();
            switch (opc) {
                case 1:
                    this.registrar();
                    break;
                case 2:
                    this.buscarVehiculo();
                    break;
                case 3:
                    this.buscarModelo();
                    break;
                case 4:
                    this.guardarNumMotor();
                    break;
                case 5:
                    this.ordenarporBurbuja(numMotor);
                    break;
                case 6:
                    this.ordenarPorInserccion();
                    break;
                case 7:
                    this.buscar();
                    this.busquedaBinaria(numMotor.length);
                    break;

            }

        } while (opc != 8);
    }

}
