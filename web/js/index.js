function modificar (id, tr){
    document.getElementById("id").value = id;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
      if(this.readyState == 4 && this.status == 200) {
          var object = JSON.parse(xhttp.responseText);
          document.getElementById("TrElement").value = tr;
          document.getElementById("nombre").value = object.nombre;
          document.getElementById("apellido").value = object.apellido;
          document.getElementById("correo").value = object.correo;
          document.getElementById("contrasena").value = object.contrasena;
          document.getElementById("descripcion").value = object.descripcion;
      }  
    };
    xhttp.open("GET", '/miPrimerWeb/usuario.do?id='+id+'&modificar=1' , true);
    xhttp.send();
}

function guardar () {
    
    var id = document.getElementById("id").value;
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var correo = document.getElementById("correo").value;
    var contrasena = document.getElementById("contrasena").value;
    var descripcion = document.getElementById("descripcion").value;
    
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
      if(this.readyState == 4 && this.status == 200) {
          
          var tr = document.getElementById("TrElement").value;
          var tr2 = document.getElementById(tr);
          tr2.childNodes[5].innerHTML = nombre;
          tr2.childNodes[7].innerHTML = apellido;
          tr2.childNodes[9].innerHTML = correo;
          tr2.childNodes[11].innerHTML = descripcion;
          
          $("#exampleModal").modal("hide");
          Swal.fire(
            'Cambios guardados!',
            'Los cambios se guardaron con éxito!',
            'success'
          )
      }  
    };
    
    xhttp.open("POST", '/miPrimerWeb/usuario.do', true);
    xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhttp.send("btnModificar=modificar&id="+id+"&nombre="+nombre+"&apellido="+apellido+"&email="+correo+"&contrasena="+contrasena+"&descripcion="+descripcion);
}



function eliminar (id, tr) {
    
    Swal.fire({
  title: 'Está seguro de eliminar este registro?',
  text: "Los cambios no podrán deshacerse!",
  type: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Si eliminar!'
}).then(function (result) {
  if (result.value) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
    if(this.readyState == 4 && this.status == 200) {
          Swal.fire(
            'Eliminado!',
            'El registro fue eliminado con éxito!',
            'success'
          )
    var tbody = document.getElementById("cuerpoBody");
    var tr2 = document.getElementById(tr);
    var resultado = tbody.removeChild(tr2);
        
      }  
    };
    
    xhttp.open("GET", '/miPrimerWeb/usuario.do?btnEliminar=eliminar&id='+id, true);
    xhttp.send();
  }
})

}

$("#exampleModal").on('hide.bs.modal', function(){
    document.getElementById("id").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("apellido").value = "";
    document.getElementById("correo").value = "";
    document.getElementById("contrasena").value = "";
    document.getElementById("descripcion").value = "";
});