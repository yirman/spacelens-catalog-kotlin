# spacelens-catalog-kotlin

Aplicación móvil para mostrar listado y detalle de productos de Spacelens.

######Herramientas adicionales utilizadas

**Realm + LiveData** para persistencia y exposición de datos hacia la capa de la interfaz.
**Retrofit** para consumo de servicios web.
**Glide** para descarga de imágenes.


######Organización del proyecto

- En el paquete **model** están definidos los modelos de datos, que a su vez definen el esquema de la base de datos.
- En el paquete **repository.database** está definido el data access object para la entidad Product con los métodos más básicos para consulta e inserción de uno o varios productos.
- En el paquete **repository.web** está definido el servicio web a consultar + mecanismo para autenticación respectivo para el servicio (Autenticación Básica)
  La clase ProductRepository reune las fuentes de recursos (base de datos y servicios rest) para la consulta de datos en local o remoto. Además se encuentran las constantes para el api rest(url base + credenciales)
- En el paquete **utils** están contenidas clases auxiliares que permiten "envolver" los resultados de las consultas a la base de datos en LiveData para la reacción a los cambios hechos en bd.
- En el paquete **ui** están las actividades y el adaptador para los item del listado de productos.
- En el paquete **viewmodel** está el viewmodel con los métodos necesarios para acceder a la consulta y exposición del catálogo de productos desde las distintas fuentes de recursos (base de datos y servicios web), haciendo uso de corutinas para las peticiones asíncronas al api.
