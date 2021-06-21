<?php 

$conexion = mysqli_connect("localhost","id17096619_localhost","dV1RZ$78??LNRE2\","id17096619_clinicafinal");

$res1 = $_POST["respuesta1"];
$res2 = $_POST["respuesta2"];
$res3 = $_POST["respuesta3"];
$res4 = $_POST["respuesta4"];
$res5 = $_POST["respuesta5"];

$consulta = "INSERT INTO datosencuesta(respuesta1,respuesta2,respuesta3,respuesta4,respuesta5) VALUES ('$res1','$res2','$res3','$res4','$res5')";

$resultado = mysqli_query($conexion,$consulta);


if($resultado){
     echo"Encuesta Insertada;
}else{
    echo "Error al insertar el producto";
}
 mysqli_close($conexion);
?>