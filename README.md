Este docmento da una breve informacion referente a la prueba de automatizacion de la pagina demoblaze.com

Estos escenario por cuesestion de tiempo se hizo un "happy path" en donde todo se ejecuta exitosamente.
* Alcance  
    • Agregar dos productos al carrito
    • Visualizar el carrito
    • Completar el formulario de compra
    • Finalizar la compra

  La auomatizacion hace lo siguiente:
    * Se logea antes de seleccionar los prductos
    * En el escenario seleccionar 2 productos (telefono & laptop)
    * Una vez seleccionado los items, va al link de ver el carrito de compra(cart)
    * Ahi se realiza a compra
    * Antes de confirmar la compra hay que llenar un formalario con la informacion del cliente
    * Se confirma la compra y concluye el programa

* Instrucciones
      - Importar el proyecto al IDe que se desea realizar la prueba. Yo lo realice en IntelliJ community edition
      - Una vez descargado e importado favor de verificar la version del navegador de Google Chrome sea compatible con el proyecto.
        actualemte la ultima version es la Version 147.0.7727.102
      - En la clase DemoBlazerStore existe un metodo llamado initCustomer() la cual se puede inicializar la informacion del cliente que sera llenado al realizar la
          la compra
      - En la clase Main.java se puede cambiar un suaurio y contraseña en caso de tener para la prueba o utilizar las que por default estan alli (toymaru_101)
      - Se ejecuta en la clase Main.java y el proceso de automatizacion se ejecutara paso a paso.
    
