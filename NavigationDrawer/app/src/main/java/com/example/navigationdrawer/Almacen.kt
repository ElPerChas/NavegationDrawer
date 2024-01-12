package com.example.navigationdrawer

class Almacen() {
    var productos = arrayOf("Silla tapizada para salon","Sofa para salon","Mesa comedor 6 personas",
        "Iphone 15 128GB","Portatil ASUS GAMING ","Monitor PC 144Hz","Sudadera Gris Hombre",
        "Camiseta Blanca Nike","Zapatillas Nike","Nevera Ultrafrozen 2.0","Sarten acero",
        "Tostadora ultratost","Pack coches juguete","Coche radiocontrol","Drone GPS con camara",
        "Lampara de diseño","Planta artificial","Figura decorativa")
    var descripcion = arrayOf(
        "Silla tapizada para salón: Una cómoda silla diseñada para proporcionar elegancia y comodidad en tu salón. Tapizada con materiales de alta calidad.",
        "Sofá para salón: Un sofá espacioso y acogedor ideal para tu sala de estar. Con un diseño moderno y tela suave para una experiencia de descanso perfecta.",
        "Mesa comedor 6 personas: Mesa de comedor elegante y funcional para hasta 6 personas. Perfecta para cenas familiares o reuniones con amigos.",
        "iPhone 15 128GB: El último modelo de iPhone con 128GB de almacenamiento. Experimenta la potencia y la innovación en la palma de tu mano.",
        "Portátil ASUS GAMING: Un portátil potente diseñado para gamers. Con gráficos de alta calidad y un rendimiento excepcional para tus sesiones de juego.",
        "Monitor PC 144Hz: Disfruta de una experiencia de juego suave con este monitor de alta frecuencia de actualización. Colores vibrantes y tiempo de respuesta rápido.",
        "Sudadera Gris Hombre: Una sudadera cómoda y elegante en color gris para hombres. Fabricada con materiales de alta calidad para un ajuste perfecto.",
        "Camiseta Blanca Nike: Camiseta blanca de la reconocida marca Nike. Diseño clásico y materiales transpirables para un estilo deportivo.",
        "Zapatillas Nike: Zapatillas deportivas de Nike para un estilo activo y cómodo. Perfectas para el uso diario o actividades deportivas.",
        "Nevera Ultrafrozen 2.0: Una nevera moderna con funciones avanzadas, como ultracongelación. Ideal para mantener tus alimentos frescos por más tiempo.",
        "Sartén de acero: Sartén duradera y resistente hecha de acero de alta calidad. Perfecta para cocinar deliciosas comidas.",
        "Tostadora Ultratost: Tostadora moderna con funciones avanzadas para un tostado perfecto. Diseño elegante y fácil de usar.",
        "Pack coches juguete: Set de coches de juguete para horas de diversión. Perfecto para regalos o para agregar a la colección de juguetes.",
        "Coche radiocontrol: Coche teledirigido de alta velocidad y maniobrabilidad. Diviértete controlándolo a distancia.",
        "Drone GPS con cámara: Drone equipado con GPS y cámara para capturar impresionantes imágenes aéreas. Fácil de controlar y perfecto para aficionados a la fotografía.",
        "Lámpara de diseño: Lámpara moderna y elegante para iluminar tu espacio con estilo. Diseño único que agrega un toque contemporáneo a cualquier habitación.",
        "Planta decorativa: Planta artificial decorativa para agregar un toque de naturaleza a tu hogar sin preocuparte por el mantenimiento.",
        "Figura de colección: Figura coleccionable para entusiastas. Detalles intrincados y calidad excepcional para exhibir en tu colección."
    )

    var img= arrayOf(R.drawable.silla,R.drawable.sofa,R.drawable.mesa,R.drawable.iphone,
        R.drawable.portatil,R.drawable.monitor,R.drawable.sudadera,R.drawable.camiseta,
        R.drawable.zapatillas,R.drawable.nevera,R.drawable.sarten,R.drawable.tostadora,
        R.drawable.cochejuguete,R.drawable.cocherc,R.drawable.drone,R.drawable.lampara,
        R.drawable.planta,R.drawable.figura)
    var categorias= arrayOf("Hogar","Electronica","Ropa","Cocina","Juguetes","Decoracion")
    var numCategoria=0
    val productosAlmacenados= arrayListOf<Productos>()
    init {
        var count=0
        for (prod in productos){
            if (count%3==0&&count!=0){
                numCategoria++
            }
            productosAlmacenados.add(Productos(prod,Math.random()*50,descripcion[count],img[count],categorias[numCategoria]))
            count++
        }
    }

}