#language: es

@regresion
Característica: registro de un usuario

  como usuario cliente de la tienda
  quiero tener una cuenta para poder
  iniciar sesion

  Escenario: Registro correcto de un usuario cliente
    Dado que el cliente entra a la pagina de registro
    Cuando diligencia correctamente todos los campos
    Entonces se muestra el mensaje "Your registration completed"

  Escenario: Registro incorrecto de un usuario cliente
    Dado que el cliente entra a la pagina de registro
    Cuando llena todos los campos excepto Last name
    Entonces se muestra un mensaje junto al campo Last name