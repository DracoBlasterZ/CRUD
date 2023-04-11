package model;

public class Cliente {

	public static void main(String[] args) {

		DbConection dbc = new DbConection();

		// Conéctate a la base de datos
		dbc.connect("192.168.4.105:3306", "remote", "P@ssw0rd_Remote");

		// Elimina y crea la base de datos ud18_ejercicio2
		dbc.createDB("clientes");

		// Selecciona la base de datos
		dbc.selectDB("clientes");

		// Crear tabla cliente
		String tableName1 = "cliente";
		String tableColumns1 = "id INT AUTO_INCREMENT, nombre VARCHAR(100),"
				+ " apellido VARCHAR(100),direccion VARCHAR(300),dni char(8), fecha datatime, PRIMARY KEY (id)";
		dbc.createTable("cliente", tableName1, tableColumns1);

		// Insertar registros en la tabla cliente
		String columns1 = "id, nombre, apellido, direccion, dni, fecha";
		String values1_1 = "1, 'Pepito','Bonito','Bajo un puente', 64587573, 2000-11-08";
		dbc.insertData("ud18_ejercicio2", tableName1, columns1, values1_1);


		// Enseñar y Eliminar datos en la tabla
		dbc.getValues("clientes", "cliente", columns1);

		// Cerrar conexión
		dbc.closeConnection();

	}

}
