#language: es

@regresion
Característica: Escribir una consulta

  como usuario cliente de la tienda
  quiero dejar por escrito un consulta
  en el apartado de contactUs

  Escenario: Envio de consulta con los 3 campos correctamente diligenciados
    Dado que el cliente entra a la pagina de contactUs
    Cuando diligencia correctamente todos los campos
    Entonces se muestra un mensaje diciendo que la consulta ha sido enviada
