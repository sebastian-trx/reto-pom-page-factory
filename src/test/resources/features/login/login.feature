#language: es

@regresion
Característica: Iniciar sesion con un usuario registrado

  como usuario cliente, registrado
  en la tienda quiero iniciar sesion

  Escenario: Iniciar sesion con los mismos datos ingresados en el registro
    Dado que el cliente es un usuario registrado
    Cuando el cliente inicia sesion
    Entonces se muestra la opcion Log out en la LandingPage