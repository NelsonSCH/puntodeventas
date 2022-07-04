$(document).ready( function () {
    
    $('#tablaProductos').DataTable(
    {
        orden:[[3,"desc"]],
        columns:
        [
            null,
            {orderable: false, bSearchable: false},
            null,
            null,
            null,
            {bSearchable: false},
            {orderable: false}
        ],
        lengthMenu:[2, 5, 10, 15, 20],
        language:
        {
            "search": "Buscar",
            "lengrhMenu" : "Mostrar_MENU_registros",
            "info": "Mostrando _END_ productos (_TOTAL_ total)",
            "infoFiltered" : "(Filtrado de _MAX_ productos)",
            "enptyTable" : "Aún no hay productos creados",
            "paginate":
            {
                "previous": "Anterior",
                "next" : "Siguiente"
            }
        }
    });
    
} );