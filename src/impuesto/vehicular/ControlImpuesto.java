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
    int numMotor[];
    ArrayList vehiculos = new ArrayList();

    void registrar() {
        System.out.println("...REGISTRO VEHICULO...");
        System.out.print("Digite el numero de placa: ");
        String placa = in.nextLine();
        System.out.print("Digite el numero del motor: ");
        int numeroMotor = in.nextInt();
        System.out.print("Digite el valor a pagar: ");
        double valorPagar = in.nextDouble();
        System.out.print("Digite el nombre del propietario: ");
        String propietario = in.nextLine();
        System.out.print("Digite el modelo del vehiculo: ");
        String modelo = in.nextLine();

        Vehiculo objeto = new Vehiculo();

        objeto.setPlaca(placa);
        objeto.setNumeroMotor(numeroMotor);
        objeto.setValorPagar(valorPagar);
        objeto.setPropietario(propietario);
        objeto.setModelo(modelo);

        vehiculos.add(objeto);

        System.out.println("VEHICULO REGISTRADO");

    }

    void buscarVehiculo() {
        boolean bandera = false;

        System.out.println("...BUSCAR VEHICULO POR NUMERO DE PLACA...");
        System.out.print("Digite placa a buscar: ");
        String placaBuscar = in.nextLine();

        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo recuperar = (Vehiculo) vehiculos.get(i);
            if (recuperar.getPlaca().equalsIgnoreCase(placaBuscar)) {
                bandera = true;
                System.out.println("PLACA: " + recuperar.getPlaca() + "\nNUMERO DE MOTOR: " + recuperar.getNumeroMotor() + "\nVALOR A PAGAR:" + recuperar.getValorPagar() + "\nPROPIETARIO:" + recuperar.getPropietario() + "\nMODELO:" + recuperar.getModelo());
            }
        }

        if (bandera == false) {
            System.out.println("NO SE ENCONTRO NUMERO DE PLACA EN EL SISTEMA!");
        }
    }

    void buscarModelo() {
        boolean bandera = false;

        System.out.println("...BUSCAR VEHICULO POR MODELO...");
        System.out.print("Digite modelo de vehiculo a buscar: ");
        String modeloBuscar = in.nextLine();

        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo recuperar = (Vehiculo) vehiculos.get(i);
            if (recuperar.getModelo().equalsIgnoreCase(modeloBuscar)) {
                bandera = true;
                System.out.println("PLACA: " + recuperar.getPlaca() + "\nNUMERO DE MOTOR: " + recuperar.getNumeroMotor() + "\nVALOR A PAGAR:" + recuperar.getValorPagar() + "\nPROPIETARIO:" + recuperar.getPropietario() + "\nMODELO:" + recuperar.getModelo());
            }
        }

        if (bandera == false) {
            System.out.println("NO SE ENCONTRO NUMERO MODELO DEL VEHICULO EN EL SISTEMA!");
        }
    }

    void guardarNumMotor(){
        numMotor=new int [vehiculos.size()];
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo recuperar = (Vehiculo) vehiculos.get(i);
            numMotor[i]=recuperar.getNumeroMotor();
        }
        System.out.println("NUMEROS DE MOTOR GUARDADOS");
    }
    
    void ordenarporBurbuja(int arreglo[]){
		int n=arreglo.length;
		//variable usada pa
		int aux=0;
		
		for (int i = 0; i < n-1; i++) {
			/*Este ciclo se encraga de llevar el mayor al final del arreglo
			 * Va desde 0 hasta se haya ido ornando el mayor
			 * */
			for (int j = 0; j < n-i-1; j++) {
				//en caso de que se cumpla la condicion se intercambia la posicion
				if(arreglo[j]>arreglo[j+1]){
					aux=arreglo[j];
					arreglo[j]=arreglo[j+1];
					arreglo[j+1]=aux;
				}
			}
			
		}
		
		//Listar el arreglo ordenado
		System.out.println("\n---Arreglo ordenado por metodo Burbuja----");
		for (int i : arreglo) {
			System.out.print(i+"-");
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
}
