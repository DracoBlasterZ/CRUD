package model;

public class Cliente {

	public static void main(String[] args) {

		DbConection dbc = new DbConection();

		// Conéctate a la base de datos
		dbc.connect("localhost", "root", "Camila1234_");

		// Elimina y crea la base de datos ud18_ejercicio2
		dbc.createDB("clientes");

		// Selecciona la base de datos
		dbc.selectDB("clientes");

		// Crear tabla cliente
		String tableColumns1 = "id INT AUTO_INCREMENT, nombre VARCHAR(100),"
				+ " apellido VARCHAR(100),direccion VARCHAR(300),dni char(8), fecha date, PRIMARY KEY (id)";
		dbc.createTable("clientes", "cliente", tableColumns1);

		// Insertar registros en la tabla cliente
		String columns1 = "nombre, apellido, direccion, dni, fecha";
		String values1_1 = "'Juan', 'Pérez', 'Calle Falsa 123', '12345678', '2023-04-11'";
		dbc.insertData("clientes", "cliente", columns1, values1_1);


		// Enseñar datos
		dbc.getValues("clientes", "cliente", columns1);

		// Cerrar conexión
		dbc.closeConnection();

	}

}
