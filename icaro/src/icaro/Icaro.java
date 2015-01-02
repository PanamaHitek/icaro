package icaro;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Icaro {
//OutputStream para el envío de datos por el Puerto Serie

    private static OutputStream Output = null;

    //Variable que representa el Puerto Serie
    private static SerialPort serialPort;

    //Variables con los parámetros por defecto del Puerto Serie
    private static int ByteSize = 8;
    private static int StopBits = 1;
    private static int Parity = 0;
    private static int TimeOut = 2000;

    //Variable flag que representa el estado del Puerto Serie
    private static boolean portOpen = true;

    public void setParity(int Bytes) {
        /*Método para establecer la paridad
         0 = Sin Paridad
         1 = Paridad Impar
         2 = Paridad Par
         3 = Paridad Marcada
         4 = Paridad Espaciada
         */
        if ((Bytes >= 0) && (Bytes <= 4)) {
            Parity = Bytes;
        } else {
            System.out.println("La paridad solamente puede ser: \n"
                    + "0 = Sin Paridad\n"
                    + "1 = Paridad Impar\n"
                    + "2 = Paridad Par\n"
                    + "3 = Paridad Marcada\n"
                    + "4 = Paridad Espaciada\n"
                    + "Se conserva la paridad por defecto (0- Sin Paridad)");
        }
    }

    public void setByteSize(int Bytes) {

        /*Método para establecer el ByteSize
         Se aceptan valores de entrada entre 5 y 8
         */
        if ((Bytes >= 5) && (Bytes <= 8)) {
            ByteSize = Bytes;
        } else {
            System.out.println("Sólo se aceptan valores entre 5 y 8 para el ByteSize "
                    + "\nSe conserva el valor por defecto (8 Bytes)");
        }
    }

    public void setStopBits(int Bytes) {
        /*Método para establecer el StopBit
         1 = 1 StopBit
         2 = 2 StopBits
         3 = 1.5 StopBits
         */
        if ((Bytes >= 1) && (Bytes <= 3)) {
            StopBits = Bytes;
        } else {
            System.out.println("Sólo se aceptan valores entre 1 y 3 para StopBit (3 es para 1.5 StopBits)."
                    + "\nSe conserva el valor por defecto (1 Bit)");
        }
    }

    public void setTimeOut(int time) {
        //Método para establecer el TimeOut
        TimeOut = time;
    }

    public void Iniciar(String PORT_NAME, int DATA_RATE) throws Exception {
        /*
         Método para abrir el Puerto Serie
         Se requieren como parámetros el nombre del puerto y el BaudRate
         Si no se establecen los parámetros para la conexión (TimeOut, ByteSize, StopBits, Psrity)
         el algoritmo tomará los valores establecidos por defecto en la declaración de las variables.
        
         El flag portOpen es el encargado de evitar que se intente abrir el puerto 2 veces.
         */
        if (!portOpen) {
            try {
                CommPortIdentifier portId = null;
                Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

                while (portEnum.hasMoreElements()) {
                    CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
                    if (PORT_NAME.equals(currPortId.getName())) {
                        portId = currPortId;
                        break;
                    }
                }
                serialPort = (SerialPort) portId.open(this.getClass().getName(), TimeOut);
                serialPort.setSerialPortParams(DATA_RATE, ByteSize, StopBits, Parity);

                //Se establece la variable para enviar los datos a través del Puerto Serie.
                Output = serialPort.getOutputStream();

                //Se establece el valor del flag portOpen como true, indicando que se ha iniciado la conexión
                //con el puerto Serie
                portOpen = true;

                System.out.println("Se ha iniciado la conexión con el Puerto Serie");
            } catch (IOException ex) {
                Logger.getLogger(Icaro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedCommOperationException ex) {
                throw new Exception("Operación no permitida.");
            } catch (PortInUseException ex) {
                throw new Exception("El puerto seleccionado ya está en uso.");
            }
        } else {
            throw new Exception("El Puerto Serie ya ha sido abierto. Imposible abrir 2 veces.");
        }
    }

    public void Cerrar() throws Exception {
        if (!portOpen) {
            serialPort.close();
            portOpen = false;
            System.out.println("Se ha finalizado la conexión con el Puerto Serie");
        } else {
            throw new Exception("El Puerto Serie no se ha abierto. Imposible Cerrar");
        }
    }

    boolean Activar(int Valor) {
//return frue;
        return false;
    }

    int LeerValorAnalogico(int Sensor) {
        int Output = 0;
        return Output;
    }

    int LeerValorDigital(int Sensor) {
        int Output = 0;
        return Output;
    }

    boolean ActivarServo(int Servo, int Valor) {
        if (Servo == 1) {

        } else if (Servo == 2) {

        } else if (Servo == 3) {

        } else if (Servo == 4) {

        } else if (Servo == 5) {

        }
        //return frue;
        return false;
    }

    boolean Sonido(int Audio, int ValorPuerto) {
//return frue;
        return false;
    }

}
