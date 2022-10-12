function leerClientes(){
    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client',
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
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].email+"</td>";
        myTable+="<td>"+items[i].age+"</td>";
        myTable+="<td> <button onclick='borrarCliente("+items[i].id+")'>Borrar</button><br>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}

function guardarCliente(){
    let id=$("#idCliente").val();
    let nombre=$("#nombreCliente").val();
    let correo=$("#correoCliente").val();
    let edad=$("#edadCliente").val();

    let data={
        id:id,
        name:nombre,
        email:correo,
        age:edad
    };

    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client',
        type : 'POST', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            alert("Se ha guardado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerClientes();
        }
    });   
}

function editarCliente(){
    let id=$("#idCliente").val();
    let nombre=$("#nombreCliente").val();
    let correo=$("#correoCliente").val();
    let edad=$("#edadCliente").val();

    let data={
        id:id,
        name:nombre,
        email:correo,
        age:edad
    };

    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client',
        type : 'PUT', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            alert("Se ha actualizado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerClientes();
        }
    });   
}

function borrarCliente(id){
    let data={
        id:id
    };
    
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client',
        type : 'DELETE', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            alert("Se ha eliminado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerClientes();
        }
    });    
}

function buscarPorId(){
    let id=$("#idCliente").val();
    let nombre=$("#nombreCliente").val();
    let correo=$("#correoCliente").val();
    let edad=$("#edadCliente").val();

    let data={
        id:id,
    };

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client/'+id,
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
        myTable+="<td>"+items[0].name+"</td>";
        myTable+="<td>"+items[0].email+"</td>";
        myTable+="<td>"+items[0].age+"</td>";
        myTable+="<td> <button onclick='borrarCliente("+items[0].id+")'>Borrar</button><br>";
        myTable+="</tr>";

        myTable+="</table>";
        $("#resultado").append(myTable);
    }