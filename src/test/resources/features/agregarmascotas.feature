#language: es

Característica: Agregar mascota a la tienda

   Antecedentes:
   Dado  como "administrador" quiero usar la pet store api


  Escenario: Agregar mascota a la tienda
    Dado que quiero agregar una mascota a la tienda
    Cuando  haga un llamado a la api
    Entonces recibo un status 200 y su id


