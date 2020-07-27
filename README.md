# GreenFood_BryanPozo
Esta aplicación consta del diseño de una pequeña aplicación, la cual entorna a una tienda, contiene distintas activity con diferentes funciones.

1.	MainActity: trata de un Login y una contraseña (predefinidas )

2.	Home: Existen 4 ImageButtons como iconos, y una slider principal el cual interactúan en un ViewFlipper facilitada por el XML.

2.1	Gestionar Usuarios: Activity la cual consiste en generar el método de encriptar la contraseña bajo el algoritmo AES, que a través de un TextView nos mostrara la contraseña encriptada bajo el carácter de UTF-8.

2.2	Gestionar Alimentos: Activity basada por SQLite a través de los métodos CRUD donde se podrá INSERTAR, MOSTRAR, MODIFICAR Y ELIMINAR. Se trabajará con la clase AdminSQLiteOpenHelper para la configurar la base de datos y la creacion de las tablas.

2.3	Localización: Activity la cual nos dará interacción con el GoogleMaps y la interacción a una localización predefinida por nosotros.

2.4	Nutrición: Activity basada la cual realizara un calculo simple para obtener un valor final según la cantidad de alimentos seleccionados. También tiene una ImagenButtons que nos direccionara a una pagina web predefinida por nosotros. Adicional recibirá un mensaje recibido por el intercambio de valores por PutExtra y getExtra .
