$(document).ready( function () {

    $("#buscar_producto").autocomplete({
        source: function (request, response){
            $.ajax({
                url: `/ventas/buscar-productos/${request.term}`,
                dataType: "json",
                data:{
                    term:request.term
                },
                success: function (data){
                    response($.map(data, function(item){
                        return {
                            value: item.id,
                            label: `${item.descripcion} . $${item.precio}`
                        }
                    }));
                }
            });
        },
        select: function(event, ui){
            //crear una linea para la tabla
            let  linea = $("#ventaItems").html();

            //Construir las celdas
            let producto = ui.item.label;
            let descripcion = producto.split('-')[0];
            let precio = producto.split('-')[1];
            precio = precio?.split( '$' )[1];
            let id = ui.item.value;

            //console.log(`Producto seleccionado: ${producto}`);
            linea = linea.replace(/{ID}/g, id);
            linea = linea.replace(/{DESCRIPCION}/g, descripcion);
            linea = linea.replace(/{PRECIO}/g, precio);
           // console.log(`Producto seleccionado: ${linea}`);


            $("#tabla tbody").append(linea);
        }
    });
});