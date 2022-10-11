function leerCuatrimotos(){
    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/quadbike/quadbike',
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
        myTable+="<td>"+items[i].brand+"</td>";
        myTable+="<td>"+items[i].model+"</td>";
        myTable+="<td>"+items[i].category_id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td> <button onclick='borrarCuatrimoto("+items[i].id+")'>Borrar</button><br>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);
}

function guardarCuatrimoto(){
    let id=$("#idCuatrimoto").val();
    let marca=$("#marca").val();
    let modelo=$("#modelo").val();
    let categoria=$("#categoriaId").val();
    let nombre=$("#nombreCuatrimoto").val();

    let data={
        id:id,
        brand:marca,
        model:modelo,
        category_id:categoria,
        name:nombre,
    };

    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/quadbike/quadbike',
        type : 'POST', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            alert("Se ha actualizado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerCuatrimotos();
        }
    });   
}

function editarCuatrimoto(){
    let id=$("#idCuatrimoto").val();
    let marca=$("#marca").val();
    let modelo=$("#modelo").val();
    let categoria=$("#categoriaId").val();
    let nombre=$("#nombreCuatrimoto").val();

    let data={
        id:id,
        brand:marca,
        model:modelo,
        category_id:categoria,
        name:nombre,
    };

    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/quadbike/quadbike',
        type : 'PUT', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            alert("Se ha actualizado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerCuatrimotos();
        }
    });   
}

function borrarCuatrimoto(id){
    let data={
        id:id
    };
    
    let dataToSend=JSON.stringify(data);
    console.log(dataToSend);

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/quadbike/quadbike',
        type : 'DELETE', data:dataToSend, contentType: 'application/json',

        success:function(respuesta){
            $("#resultado").empty();
            alert("Se ha eliminado el dato");
        },
        error : function(xhr, status) {
            alert('Ha sucedido un problema');
        },
        complete : function(){
            leerCuatrimotos();
        }
    });    
}

function buscarPorId(){
    let id=$("#idCuatrimoto").val();
    let marca=$("#marca").val();
    let modelo=$("#modelo").val();
    let categoria=$("#categoriaId").val();
    let nombre=$("#nombreCuatrimoto").val();

    let data={
        id:id,
    };

    $.ajax({
        url : 'https://gc01a368eb5b702-aegxvruuz5h6pnip.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/quadbike/quadbike/'+id,
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
        myTable+="<td>"+items[0].brand+"</td>";
        myTable+="<td>"+items[0].model+"</td>";
        myTable+="<td>"+items[0].category_id+"</td>";
        myTable+="<td>"+items[0].name+"</td>";
        myTable+="<td> <button onclick='borrarCuatrimoto("+items[0].id+")'>Borrar</button><br>";
        myTable+="</tr>";

        myTable+="</table>";
        $("#resultado").append(myTable);
    }