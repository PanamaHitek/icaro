package icaro;

public class Icaro {

    private String Puerto = "/dev/ttyACMO";
    private int Baudios = 9600;
    private int ByteSize = 8;
    private int StopBit = 1;
    private int TimeOut = 1;

    boolean Iniciar() {
        //return frue;
        //hola
        return false;
    }

    boolean Cerrar() {
        //return frue;
        return false;
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
