# Guia-01
Programacion Avanzada TP 01

La tienda y despensa “Todo dulce”, que comercializa tanto golosinas por kilo como en
paquetes requiere el desarrollo una aplicación JAVA con OO para la registración y emisión
de las facturas correspondiente a sus ventas.

De cada factura, se conoce la fecha de emisión, fecha de vencimiento (30 días a partir de
la fecha de emisión), el número de factura, formado por 4 dígitos numéricos para el
centro emisor, un guion y 8 dígitos numéricos consecutivos. El centro emisor representa
la sucursal donde se realiza la venta. Según la condición de IVA del cliente que realiza la
compra, se emite factura A o factura B, cuya diferencia es la forma de imprimir el valor
del IVA. El primer caso corresponde a los clientes que son responsables inscriptos ante la
AFIP y el segundo, para todo el resto. En la factura B, el precio de la golosina vendida
incluye el 21% correspondiente al IVA, mientras que en la factura A, se visualiza
totalizado al final de la misma. La tienda opera habitualmente con 15 clientes mayoristas,
de los cuales conoce el CUIT, razón social y condición de IVA frente a la AFIP.

Cada factura puede contener varias golosinas junto con la cantidad vendida para cada
caso, precio unitario y precio total.
Algunas golosinas se venden por kilo y otras en paquete. Las golosinas que se
comercializan por kilo se identifican por su código, descripción, precio de venta, sabores
correspondientes y si están en oferta, el porcentaje de descuento a aplicar.
De las golosinas empaquetas, se conoce código, sabores, precio de venta, descripción, si
aplican la promoción 2x1 y los depósitos donde están almacenadas.

La tienda opera con 5 depósitos distintos, algunos propios y otros externos que se
identifican por el nombre y domicilio.
Cuando una factura es abonada se registra, la fecha (fecha del día) y forma de pago:
tarjeta de débito, tarjeta de crédito o transferencia bancaria, número de recibo y número
de transacción.

Se pide:

a) Definir la estructura completa de las clases que responda al modelo planteado,
incluyendo todas las relaciones conocidas, una clase abstracta y una clase final.
Presentar el diagrama de clases correspondiente en UML en formato jpg.

b) Ingresar por teclado, la información correspondiente a cada una de las facturas
generadas. Mostrar por pantalla cada factura registrada, incluyendo todos sus datos,
el nombre de la tienda, datos de las golosinas, precios, subtotales, IVA y totales con 3
valores decimales.

c) Ingresar por teclado los datos de los clientes, golosinas y depósitos con los que opera
la tienda.

d) A partir de un número de factura ingresado por teclado, registrar el pago de la misma
o bien, modificar el existente.

e) Para cada uno de los clientes, mostrar su CUIT y razón social, números de factura
correspondientes, tipo (factura A o B), fecha de emisión y de vencimiento de aquellas
emitidas durante los dos últimos meses. Incluir la descripción, cantidad, precio de las
golosinas vendidas y si tiene alguna promoción o descuento aplicado.

f) Mostrar por pantalla los números de facturas vencidas impagas, ordenados en forma
descendente cuyo importe total vendido supere el valor ingresado como argumento de
la aplicación y se trate de ventas exclusivas de golosinas por peso.

g) Mediante el uso de datos miembros de tipo estático incluido en una clase del modelo,
mostrar la cantidad de facturas B generadas.

h) Para cada periodo del año actual (mes y año), mostrar por pantalla la cantidad de
facturas A emitidas, la cantidad de facturas B emitidas y el total de IVA a informar a la
AFIP (total de IVA facturado).

i) Indicar la cantidad de golosinas en paquete, que no fueron vendidas durante el año en
curso a ningún cliente responsable inscripto.

j) Mostrar por pantalla, número de factura, fecha de pago (si existe) de todas las
facturas cuyas golosinas vendidas comienzan con las dos primeras letras ingresadas
por teclado.

Implementar mediante el uso de interfaces, polimorfismo, métodos polimórficos, ciclos
avanzados, operador condicional y sentencia de selección múltiple. Considerar los valores
indicados en el enunciado como parte de las variables de la interfaz.

Incluir un menú para acceder a cada una de las opciones mencionadas.
