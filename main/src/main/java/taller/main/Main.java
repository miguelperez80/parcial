
package taller.main;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        port(8081);

        try {
            // Crear un objeto Gson para la conversión de objetos a formato JSON
            Gson gson = new Gson();

            // Lista de vehículos en el parqueadero
            LinkedList<Vehiculo> vehiculos = new LinkedList<>();

            // Automóvil creado por defecto y agregado a la lista
            Automovil auto = new Automovil("Mazda", "3", "ZYX987", 1500, 4, 1700);
            vehiculos.add(auto);

            // Motocicleta creada
            Motocicleta moto = new Motocicleta("Honda", "CBR600", "XYZ789", 1500, 60, 1800);

            // Definir endpoints

            // Endpoint para obtener información sobre la motocicleta
            get("/motocicleta", (req, res) -> {
                res.type("application/json");
                return gson.toJson(moto);
            });

            // Endpoint para obtener el listado de vehículos en el parqueadero
            get("/vehiculos", (req, res) -> {
                res.type("application/json");
                return gson.toJson(vehiculos);
            });

            // Endpoint para agregar un nuevo vehículo al parqueadero
            post("/agregarVehiculo/:tipo/:marca/:modelo/:placa/:atributoEspecifico/:hora_llegada/:hora_salida", (req, res) -> {
                res.type("application/json");

                // Obtener parámetros de la URL
                String tipo = req.params(":tipo");
                String marca = req.params(":marca");
                String modelo = req.params(":modelo");
                String placa = req.params(":placa");
                int atributoEspecifico = Integer.parseInt(req.params(":atributoEspecifico"));
                int hora_llegada = Integer.parseInt(req.params(":hora_llegada"));
                int hora_salida = Integer.parseInt(req.params(":hora_salida"));

                // Crear un nuevo vehículo y agregarlo al parqueadero
                Vehiculo nuevoVehiculo;
                if ("automovil".equals(tipo)) {
                    nuevoVehiculo = new Automovil(marca, modelo, placa, hora_llegada, atributoEspecifico, hora_salida);
                } else if ("motocicleta".equals(tipo)) {
                    nuevoVehiculo = new Motocicleta(marca, modelo, placa, hora_llegada, atributoEspecifico, hora_salida);
                } else {
                    // Tipo de vehículo no válido
                    res.status(400);
                    return gson.toJson("Tipo de vehículo no válido");
                }

                vehiculos.add(nuevoVehiculo);

                return gson.toJson(nuevoVehiculo);
            });

            // Endpoint para registrar la hora de salida de un vehículo
            post("/registrarSalida/:placa/:hora_salida", (req, res) -> {
                res.type("application/json");

                // Obtener parámetros de la URL
                String placa = req.params(":placa");
                int hora_salida = Integer.parseInt(req.params(":hora_salida"));

                // Buscar el vehículo por placa en la lista de vehículos
                for (Vehiculo vehiculo : vehiculos) {
                    if (vehiculo.getPlaca().equals(placa)) {
                        vehiculo.setHora_salida(hora_salida);
                        return gson.toJson(vehiculo);
                    }
                }

                // Devolver mensaje de error si no se encuentra el vehículo
                res.status(404);
                return gson.toJson("Vehículo no encontrado");
            });

            // Endpoint para obtener un informe de ganancias por vehículo
            get("/informeGanancias", (req, res) -> {
                res.type("application/json");

                // Calcular las ganancias por cada vehículo en el parqueadero
                LinkedList<InformeGanancias> informeGanancias = new LinkedList<>();
                int totalVehiculos = vehiculos.size();

                for (Vehiculo vehiculo : vehiculos) {
                    int ganancia = vehiculo.calcularGanancia(totalVehiculos);
                    informeGanancias.add(new InformeGanancias(vehiculo.getPlaca(), ganancia));
                }

                // Mostrar el informe de ganancias
                return gson.toJson(informeGanancias);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
