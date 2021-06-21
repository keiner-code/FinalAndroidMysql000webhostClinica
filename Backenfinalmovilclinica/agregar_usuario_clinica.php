<?php 

$conexion = mysqli_connect("localhost","id17096619_localhost","dV1RZ$78??LNRE2\","id17096619_clinicafinal");

$nombre = $_POST["nombre"];
$apellido = $_POST["apellido"];
$telefono = $_POST["telefono"];
$direccion = $_POST["direccion"];
$estadocivil = $_POST["estadocivil"];
$profesion = $_POST["profesion"];
$estrato = $_POST["estracto"];
$cargo = $_POST["cargo"];
$nivelestudio = $_POST["nivelestudio"];

$consulta = "INSERT INTO usuarios(nombre,apellido,telefono,direccion,estadocivil,profesion,estrato,cargo, nivelestudio) VALUES ('$nombre','$apellido','$telefono','$direccion','$estadocivil','profesion','$estrato','$cargo','$nivelestudio')";

$resultado = mysqli_query($conexion,$consulta);


if($resultado){
     echo"Encuesta Insertada;
}else{
    echo "Error al insertar el producto";
}
 mysqli_close($conexion);
?>