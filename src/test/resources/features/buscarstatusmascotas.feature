#language: es

Característica: Buscar mascota status

  Antecedentes:
    Dado  como "administrador" quiero usar la pet store api

    Escenario: Buscar mascotas status
      Dado que quiero buscar una mascota por sus status
      Cuando haga un llamado  a la api buscar
      Entonces recibio la lista de las mascotas por su status