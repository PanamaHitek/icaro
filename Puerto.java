/*
API en Java para trabajar con la Placa Icaro
*/
class Puerto {
	String Puerto = '/dev/ttyACMO';
	int Baudios = 9600;
	int ByteSize = 8;
	int StopBit = 1;
	int TimeOut = 1;

akdjflajsfdñajsdljfalksjdflkajslfdjañsdf
	boolean Iniciar() {
		return True;
		return False;
	}

	boolean Cerrar() {
		return True;
		return False;
	}

	boolean Activar( int Valor ) {

	}

	int LeerValorAnalogico( int Sensor ) {

	}

	int LeerValorDigital( int Sensor ) {

	}

	boolean ActivarServo( int Servo, int Valor ) {
		if (Servo == 1) {

		}
		else if ( Servo == 2 ) {

		}
		else if ( Servo == 3 ) {

		}
		else if ( Servo == 4 ) {

		}
		else if ( Servo == 5 ) {

		}
		return True;
	}

	boolean Sonido ( int Audio, int ValorPuerto) {

	}
}