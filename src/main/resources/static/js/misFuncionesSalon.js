function autoInicioCategoria(){
    console.log("se esta ejecutando")
    $.ajax({
        url:"http://168.138.127.214:8080/api/Category/all",
       //url: "http://localhost:8080/api/Category/all",

        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            let $select = $("#select-category");
            $.each(respuesta, function (id, name) {
                $select.append('<option value='+name.id+'>'+name.name+'</option>');
                console.log("select "+name.id);
            }); 
        }
    
    })
}
//Manejador GET
function traerInformacionSalon() {
    $.ajax({
        url:"http://168.138.127.214:8080/api/Partyroom/all",
        //url: "http://localhost:8080/api/Partyroom/all",
        type: "GET",
        datatype: "JSON",
        success: function (response) {
            console.log(response);
            pintarRespuestaSalon(response);
        }

    });

}

function pintarRespuestaSalon(response){

    let myTable="<table>"
        myTable+="<tr>";
        myTable+="<td>Nombre</td>";
        myTable+="<td>Dueño</td>";
        myTable+="<td>Capacidad</td>";
        myTable+="<td>Descripcion</td>";
        myTable+="<td>Categoria</td>";
        "</tr>";

    for(i=0;i<response.length;i++){
        myTable+="<tr>";
        myTable+="<td>" + response[i].name + "</td>";
        myTable+="<td>" + response[i].owner + "</td>";
        myTable+="<td>" + response[i].capacity + "</td>";
        myTable+="<td>" + response[i].description + "</td>";
        myTable+="<td>" + response[i].category.name + "</td>";
        myTable+='<td><button class = "botonSalon2" onclick="borrar(' + response[i].id + ')">Borrar Salón</button></td>';
        myTable+='<td><button class = "botonSalon2" onclick="cargarDatosSalon(' + response[i].id + ')">Editar Salón</button></td>';
        myTable+='<td><button class = "botonSalon2" onclick="actualizar(' + response[i].id + ')">Actualizar Salón</button></td>';
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#miListaSalon").html(myTable);
}

//Capturar informacion para Actualizar

function cargarDatosSalon(id) {
    $.ajax({
        dataType: 'json',
        url:"http://168.138.127.214:8080/api/Partyroom/"+id,
        //url: "http://localhost:8080/api/Partyroom/" + id,
        type: 'GET',

        success: function (response) {
            console.log(response);
            var item = response;

            $("#id").val(item.id);
            $("#name2").val(item.name);
            $("#owner").val(item.owner);
            $("#capacity").val(item.capacity);
            $("#description2").val(item.description);

        },

        error: function (jqXHR, textStatus, errorThrown) {

        }
    });
}

function agregarSalon() {

    if($("#name2").val().length == 0 || $("#owner").val().length == 0 || $("#capacity").val().length == 0 || $("#description2").val().length == 0){
       alert("Todos los campos son obligatorios")
    }else{

            let elemento = {
                name: $("#name2").val(),
                owner: $("#owner").val(),
                capacity: $("#capacity").val(),
                description: $("#description2").val(),
                category:{id: +$("#select-category").val()},
            };

            console.log(elemento);
            $.ajax({
            type:'POST',
            contentType: "application/json; charset=utf-8",
            dataType: 'JSON',
            data: JSON.stringify(elemento),

            url:"http://168.138.127.214:8080/api/Partyroom/save",
            //url: "http://localhost:8080/api/Partyroom/save",


                success: function (response) {
                    console.log(response);
                    console.log("Se guardo Correctamente");
                    //Limpiar Campos
                    $("#resultado2").empty();
                    $("#name2").val("");
                    $("#owner").val("");
                    $("#capacity").val("");
                    $("#description2").val("");
                    

                    //Listar Tabla

                    alert("Se ha guardado Correctamente!")
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("No se Guardo Correctamente")
                }
            });
    }
}


//Manejador DELETE
function borrar(idElemento) {
    var elemento = {
        id: idElemento
    }

    var dataToSend = JSON.stringify(elemento);
console.log(dataToSend);
    $.ajax(
        {
            dataType: 'json',
            data: dataToSend,
            url:"http://168.138.127.214:8080/api/Partyroom/"+idElemento,
            //url: "http://localhost:8080/api/Partyroom/" + idElemento,
            type: 'DELETE',
            contentType: "application/JSON",
            success: function (response) {
                console.log(response);
                $("#miListaSalon").empty();
                traerInformacionSalon(response);

                alert("se ha Eliminado Correctamente!")
            },

            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se Elimino Correctamente!")
            }
        });
}

//Manejador PUT
function actualizar(idElemento) {
    
    if($("#name2").val().length == 0 || $("#owner").val().length == 0 || $("#capacity").val().length == 0 || $("#description2").val().length == 0){
        alert("Todos los campos son obligatorios")
    }else{
        let elemento = {
            id: idElemento,
            name: $("#name2").val(),
            owner: $("#owner").val(),
            capacity: $("#capacity").val(),
            description: $("#description2").val(),
            category:{id: +$("#select-category").val()},
        }

        console.log(elemento);
        let dataToSend = JSON.stringify(elemento);

        $.ajax({
            datatype: 'json',
            data: dataToSend,
            contentType: "application/JSON",
            url:"http://168.138.127.214:8080/api/Partyroom/update",
            //url: "http://localhost:8080/api/Partyroom/update",
            type: "PUT",

            success: function (response) {
                console.log(response);
                $("#miListaSalon").empty();
                alert("se ha Actualizado Correctamente!")

                //Limpiar Campos
                $("#resultado2").empty();
                $("#id").val("");
                $("#name2").val("");
                $("#owner").val("");
                $("#capacity").val("");
                $("#description2").val("");


            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("No se Actualizo Correctamente!")
            }
        });
    }

   
}
