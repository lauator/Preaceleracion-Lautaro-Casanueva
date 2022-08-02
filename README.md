Hola, soy Lautaro Casanueva y aca dejo mi challenge de ingreso para alkemy en la tecnologia kotlin. En el DEMO podran ver una pequeña aproximacion a la app

Challenge Android (Kotlin)🚀
Objetivo
El objetivo de este challenge es desarrollar una aplicación Android utilizando
una API que posee películas, programas de televisión y artistas: API Overview —
The Movie Database (TMDb). Esta API es gratuita y requiere registrarse
previamente ya que se necesitará una clave (key) para que los endpoints
respondan correctamente.
👉La app deberá tener una pantalla principal en donde se muestre una lista de
películas populares (ver The Movie Database API) con sus respectivos títulos y
portadas.
👉Cada una de esas películas podrá ser seleccionada y se desplegará una
nueva vista con los detalles de la misma (género, idioma original, popularidad,
fecha de estreno, entre otras). Para ello, consultar el siguiente endpoint: The
Movie Database API.
👉En caso de que alguna consulta falle o algún listado esté vacío deberán
mostrarse los correspondientes errores en pantalla.
¿Qué se evaluará?
● Consistencia de la aplicación: Bajo ningún punto de vista, la aplicación
deberá cerrarse inesperadamente.
● Diseños: Los diseños de las vistas solicitadas quedarán a criterio del
desarrollador y deberán ser flexibles de acuerdo a las dimensiones de los
dispositivos.
● Experiencia de usuario: La aplicación deberá ser intuitiva, de fácil uso y los
errores que se muestren en pantalla tendrán que ser de fácil interpretación.
● Calidad de código: Deberá ser legible y de fácil manipulación. En lo
posible, que respete los estándares de la tecnología.
Adicionales
En caso de que el desarrollador cuente con tiempo podrá incorporar al proyecto
la(s) siguiente(s) funcionalidad(es):
● Dado que el endpoint de películas populares es paginado, la aplicación
podrá consultar por nuevas a medida que el usuario navegue entre estas.
Es decir, que al llegar al final de la lista que se muestra en pantalla, la
aplicación busque nuevo contenido en la API.
● Agregar un campo de búsqueda, que permita filtrar aquellas películas que
contengan dicho texto. La búsqueda deberá realizarse entre el listado que
se encuentra visible, si no hay resultado satisfactorio, deberá mostrarse su
error correspondiente.
● La API posee un endpoint para evaluar una película determinada (ver The
Movie Database API). Agregar en la vista de detalle la posibilidad de
evaluar una película y actualizar la API con dicha información.
● Para aumentar la performance de la aplicación, se busca evitar la consulta
continua de una misma película. Por este motivo, la aplicación deberá
almacenar los detalles de las películas ya vistas. En caso de que el usuario
seleccione una de ellas se consultará dicha información guardada en el
dispositivo, caso contrario, deberá consultar a la API correspondiente.
