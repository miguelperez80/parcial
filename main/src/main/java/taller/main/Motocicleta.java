package taller.main;

public class Motocicleta extends Vehiculo {

    private int cilindrada;
    private int hora_salida;

    public Motocicleta(String marca, String modelo, String placa, int hora_llegada, int cilindrada, int hora_salida) {
        super(marca, modelo, placa, hora_llegada);
        this.cilindrada = cilindrada;
        this.hora_salida = hora_salida;
    }

    public void setHora_salida(int hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getHora_salida() {
        return hora_salida;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}

