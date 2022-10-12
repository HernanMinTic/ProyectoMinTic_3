function leerMensajes(){
    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message',
        type : 'GET', dataType : 'json',

        success:function(respuesta){
            console.log(respuesta);
            mostrarTabla(respuesta.items);
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        }
    });
}

function mostrarTabla(items){
    
    let myTable ="<table>";
    $("#resultado").empty();

    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].messagetext+"</td>";
        myTable+="<td> <button onclick='borrarMensaje("+items[i].id+")'>Borrar</button><br>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}

function guardarMensaje(){
    let id=$("#idMensaje").val();
    let mensaje=$("#mensaje").val();

    let data={
        id:id,
        messagetext:mensaje
    };

    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message',
        type : 'POST', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#messagetext").val("");
            alert("Se ha guardado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerMensajes();
        }
    });   
}

function editarMensaje(){
    let id=$("#idMensaje").val();
    let mensaje=$("#mensaje").val();

    let data={
        id:id,
        messagetext:mensaje
    };

    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message',
        type : 'PUT', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#messagetext").val("");
            alert("Se ha guardado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerMensajes();
        }
    });   
}

function borrarMensaje(id){
    let data={
        id:id
    };
    
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message',
        type : 'DELETE', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            alert("Se ha eliminado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerMensajes();
        }
    });    
}

function buscarPorId(){
    let id=$("#idMensaje").val();
    let mensaje=$("#mensaje").val();

    let data={
        id:id,
    };

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message/'+id,
        type : 'GET', dataType : 'json',

        success:function(respuesta){
            console.log(respuesta);
            mostrarPorId(respuesta.items);
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        }
    });
}

function mostrarPorId(items){

        let myTable ="<table>";
        $("#resultado").empty();

        myTable+="<tr>";
        myTable+="<td>"+items[0].id+"</td>";
        myTable+="<td>"+items[0].messagetext+"</td>";
        myTable+="<td> <button onclick='borrarMensaje("+items[0].id+")'>Borrar</button><br>";
        myTable+="</tr>";

        myTable+="</table>";
        $("#resultado").append(myTable);
    }