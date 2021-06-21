<?php 

$json = array();

   if(isset($_GET["id"])){
     $id = $_GET["id"];
     
     $conexion = mysqli_connect("localhost","id17096619_localhost","dV1RZ$78??LNRE2\","id17096619_clinicafinal");
     
     $consulta = "SELECT * FROM datosencuesta WHERE id = '{$id}'";
     $resultado = mysqli_query($conexion,$consulta);

     if($registro = mysqli_fetch_array($resultado)){
         $json["datosencuesta"][]=$registro;
     }else{
            echo"Encuesta No Encontrado";
          }

       mysqli_close($conexion);
       echo json_encode($json);
   }else{

          echo"Por Favor Ingrese El Codigo";

        }

?>