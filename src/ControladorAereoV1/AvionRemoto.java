package ControladorAereoV1;

import AvionV1.IAvionSerializable;
import RMIAvionControladorAereoV1.ClienteControladorAereo;

public class AvionRemoto {
 private String ip;
 private Integer puerto;
 private IAvionSerializable avionSerial;
 private ClienteControladorAereo clienteControladorAereo;
}
