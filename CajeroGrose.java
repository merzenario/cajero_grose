package cajero.ejemplo;
import java.util.Scanner;

public class CajeroGrose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int PIN_CORRECTO = 1234;
        double saldo = 100.000;
        int intentos = 0;
        boolean cuentaBloqueada = false;

        //autenticacion segun intentos
        while(intentos < 3){
            System.out.println("ingrese su PIN: ");
            int pinIngresado = scanner.nextInt();

            if(pinIngresado == PIN_CORRECTO){
                System.out.println("!!Welcome Gonorr***¡¡");
                break;
            }else{
                System.out.println("!!PIN incorrecto¡¡" +intentos);
            }
            if(intentos == 3);{
                cuentaBloqueada = true;
                System.out.println("!!Cuenta Bloqueado¡¡");
            }

        }
        if(cuentaBloqueada){
            scanner.close();
            return;
        }
        //menu
        int opcion;
        do { 
            System.out.println("Bienvenido al cajero gono****");
            System.out.println("1. Consultar Chichigua");
            System.out.println("2. Retirar los pesos");
            System.out.println("3. Depositar");
            System.out.println("4. Open the parch");
            opcion = scanner.nextInt();

            ///opciones
            switch(opcion){
                case 1:
                    System.out.println("Ay mari*** que miseria: "+saldo);
                    break;
                case 2:
                    System.out.println("Cuanto quiere?: ");
                    double retiro = scanner.nextDouble();
                    if(retiro > 0 && retiro <= saldo){
                        saldo-= retiro;
                        System.out.println("Que chimb**, lo que queda es: "+saldo);
                    }else{
                        System.out.println("Despertate pues!! apenas tenes: "+saldo);
                    }    
                    break;
                case 3:
                    System.out.println("Cuanto depositas?: ");
                    double deposito = scanner.nextDouble();
                    if(deposito > 0){
                        saldo+= deposito;
                        System.out.println("Deposito exitoso!!! Nuevo saldo: "+saldo);
                    } 
                    break;
                case 4:     
                    System.out.println("Nos pillamos!!");
                default:
                    System.out.println("Avispate pues!! eso no es una opcion!!");
            }
        } while (opcion!= 4);
        scanner.close();
       }
}